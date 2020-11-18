package com.tinnova.tinnovaproject.model.dto;

public class VeiculoDTO {

    private String fabricante;
    private String marca;
    private Boolean isVendido;
    private Integer ano;
    private String descricao;
    private String dataRegistro;
    private String dataAtualizacao;

    public VeiculoDTO() {
    }

    public VeiculoDTO(String fabricante, String marca, Boolean isVendido, Integer ano, String descricao, String dataRegistro, String dataAtualizacao) {
        this.fabricante = fabricante;
        this.marca = marca;
        this.isVendido = isVendido;
        this.ano = ano;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getVendido() {
        return isVendido;
    }

    public void setVendido(Boolean vendido) {
        isVendido = vendido;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
