package com.tinnova.tinnovaproject.builder;

import com.tinnova.tinnovaproject.model.domain.Veiculo;
import com.tinnova.tinnovaproject.model.dto.VeiculoDTO;
import org.springframework.stereotype.Component;

/**
 * @author Rafael Veiga
 */

@Component
public class VeiculoBuilder {

    public VeiculoDTO build(Veiculo complexType){
        VeiculoDTO veiculoDTO = new VeiculoDTO();

        return buildVeiculoDTO(veiculoDTO, complexType);
    }

    private VeiculoDTO buildVeiculoDTO(VeiculoDTO veiculoDTO, Veiculo veiculo) {
        veiculoDTO.setFabricante(veiculo.getFabricante());
        veiculoDTO.setMarca(veiculo.getMarca());
        veiculoDTO.setAno(veiculo.getAno());

        if (veiculo.getDescricao()!=null){
            veiculoDTO.setDescricao(veiculo.getDescricao());
        }

        veiculoDTO.setVendido(veiculo.getVendido());
        veiculoDTO.setDataRegistro(veiculo.getDataRegistro());
        veiculoDTO.setDataAtualizacao(veiculo.getDataAtualizacao());

        return veiculoDTO;
    }
}
