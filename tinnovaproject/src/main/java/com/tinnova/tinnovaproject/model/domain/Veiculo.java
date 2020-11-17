package com.tinnova.tinnovaproject.model.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="TB_VEICULO")
public class Veiculo {

    @Id
    @Column(name= "ID_VEICULO", nullable = false, updatable = false, precision = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NOME_FABRICANTE", nullable = false)
    private String fabricante;

    @Column(name="NOME_MARCA", nullable = false)
    private String marca;

    @Column(name="ES_VENDIDO", nullable = false)
    private Boolean isVendido;

    @Column(name="ANO_VEICULO", nullable = false)
    private Integer ano;

    @Column(name="DESCRICAO")
    private String descricao;

    @Column(name = "DT_CRIACAO", nullable = false)
    private LocalDateTime dataRegistro;

    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
