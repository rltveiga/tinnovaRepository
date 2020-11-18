package com.tinnova.tinnovaproject.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.tinnova.tinnovaproject.builder.VeiculoBuilder;
import com.tinnova.tinnovaproject.exception.FornecedorNotFoundException;
import com.tinnova.tinnovaproject.exception.VeiculoNotFoundException;
import com.tinnova.tinnovaproject.model.domain.Veiculo;
import com.tinnova.tinnovaproject.model.dto.VeiculoDTO;
import com.tinnova.tinnovaproject.model.indicador.FabricanteEnum;
import com.tinnova.tinnovaproject.repository.VeiculoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Rafael Veiga
 */
@Service
public class ConcessionariaService {

    private static final Logger LOGGER =  LogManager.getLogger(ConcessionariaService.class);

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private VeiculoBuilder veiculoBuilder;

    public List<VeiculoDTO> getAllVeiculos(){
        List<VeiculoDTO> veiculoDTOList = new ArrayList<>();
        List<Veiculo> veiculosDB = veiculoRepository.findAll();

        for (Veiculo veiculo : veiculosDB){
            VeiculoDTO veiculoDTO = veiculoBuilder.build(veiculo);
            veiculoDTOList.add(veiculoDTO);
        }

        return veiculoDTOList;
    }

    public VeiculoDTO getVeiculoById(Long id){

        VeiculoDTO veiculoDTO;
        Optional<Veiculo> veiculosDB = veiculoRepository.findById(id);

        if(!veiculosDB.isPresent()){
            LOGGER.error("Veiculo com id "+id+" Nao Encontrado!");
            throw new VeiculoNotFoundException();
        }else{
            veiculoDTO = veiculoBuilder.build(veiculosDB.get());
        }

        return veiculoDTO;
    }

    public VeiculoDTO addVeiculo(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo();

        if(this.validaFabricante(veiculoDTO.getFabricante()) == null){
            LOGGER.error("Fabricante "+veiculo.getFabricante()+" Nao Encontrado!");
            throw new FornecedorNotFoundException();
        }else{
            veiculo.setFabricante(veiculoDTO.getFabricante());
        }

        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setAno(veiculoDTO.getAno());
        veiculo.setDescricao(veiculoDTO.getDescricao());
        veiculo.setVendido(veiculoDTO.getVendido());
        veiculo.setDataRegistro(this.converteDataParaString(LocalDateTime.now()));
        veiculo.setDataAtualizacao(this.converteDataParaString(LocalDateTime.now()));

        veiculoRepository.save(veiculo);

        return veiculoDTO;
    }

    public VeiculoDTO updateVeiculo(Long id, VeiculoDTO veiculoDTO) {

        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        Veiculo veiculo;

        if(veiculoOptional.isPresent()){

            veiculo = veiculoOptional.get();

            if(this.validaFabricante(veiculoDTO.getFabricante()) == null){
                LOGGER.error("Fabricante "+veiculo.getFabricante()+" Nao Encontrado.");
                throw new FornecedorNotFoundException();
            }else{
                veiculo.setFabricante(veiculoDTO.getFabricante());
            }

            veiculo.setMarca(veiculoDTO.getMarca());
            veiculo.setAno(veiculoDTO.getAno());
            veiculo.setDescricao(veiculoDTO.getDescricao());
            veiculo.setVendido(veiculoDTO.getVendido());
            veiculo.setDataAtualizacao(this.converteDataParaString(LocalDateTime.now()));

        }else {
            LOGGER.error("Veiculo com id "+id+" Nao Encontrado!");
            throw new VeiculoNotFoundException();
        }

        veiculoRepository.save(veiculo);

        return veiculoDTO;
    }

    public VeiculoDTO updateVeiculo(Long id, JsonPatch veiculoDTO) throws JsonPatchException, JsonProcessingException {

        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(VeiculoNotFoundException::new);
        Veiculo veiculoPatch = applyPatchToVeiculo(veiculoDTO, veiculo);

        return this.updateVeiculo(id, veiculoBuilder.build(veiculoPatch));
    }

    public void deleteVeiculo(Long id){
        veiculoRepository.deleteById(id);
    }

    /**
     * @return FabricanteEnum
     * @implNote Validacao de fabricante feita atraves de enum para nao ter que gerar
     * dump de banco ou automatizar um insert na subida.
     * Em termos praticos faria a validacao e controle dos fabricantes no banco de dados.
     * Optei por essa solucao por falta de tempo.
     */
    private FabricanteEnum validaFabricante(String fabricante){
        return FabricanteEnum.fromString(fabricante);
    }

    private Veiculo applyPatchToVeiculo(JsonPatch patch, Veiculo targetVeiculo) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetVeiculo, JsonNode.class));
        return objectMapper.treeToValue(patched, Veiculo.class);
    }

    private String converteDataParaString(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = localDateTime.format(formatter); // "1986-04-08 12:30"

        return formattedDateTime;
    }
}
