package com.tinnova.tinnovaproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.tinnova.tinnovaproject.model.dto.VeiculoDTO;
import com.tinnova.tinnovaproject.services.ConcessionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class ConcessionariaController {

    @Autowired
    private ConcessionariaService concessionariaService;

    @GetMapping(path = "/veiculos")
    public ResponseEntity<List<VeiculoDTO>> getVeiculos(){
        List<VeiculoDTO> listaVeiculos = concessionariaService.getAllVeiculos();
        return ResponseEntity.ok(listaVeiculos);
    }

    @GetMapping(path = "/veiculos/{id}")
    public ResponseEntity<VeiculoDTO> getVeiculoByID(@PathVariable("id") Long veiculoId){
        VeiculoDTO veiculoDTO = concessionariaService.getVeiculoById(veiculoId);
        return ResponseEntity.ok(veiculoDTO);
    }

    @PostMapping(value = "/veiculos")
    public ResponseEntity<VeiculoDTO> addVeiculo(@RequestBody @Valid VeiculoDTO veiculo){
        VeiculoDTO veiculoDTO = concessionariaService.addVeiculo(veiculo);
        return ResponseEntity.ok(veiculoDTO);
    }

    @PutMapping(value = "/veiculos/{id}")
    public ResponseEntity<VeiculoDTO> updateVeiculo(@RequestBody @Valid VeiculoDTO veiculo, @PathVariable("id") Long veiculoId){
        VeiculoDTO veiculoDTO = concessionariaService.updateVeiculo(veiculoId, veiculo);
        return ResponseEntity.ok(veiculoDTO);
    }

    @PatchMapping(path = "/veiculos/{id}")
    public ResponseEntity<VeiculoDTO> updateVeiculo(@RequestBody JsonPatch veiculoParcial, @PathVariable("id") Long veiculoId) throws JsonPatchException, JsonProcessingException {
         VeiculoDTO veiculoDTO = concessionariaService.updateVeiculo(veiculoId, veiculoParcial);
        return ResponseEntity.ok(veiculoDTO);
    }

    @DeleteMapping(path = "/veiculos/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable("id") Long veiculoId){
        concessionariaService.deleteVeiculo(veiculoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
