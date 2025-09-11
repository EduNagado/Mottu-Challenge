package com.projectMottu.gef.model;

import jakarta.persistence.*;

@Entity
@Table(name = "moto")
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_seq")
    @SequenceGenerator(name = "moto_seq", sequenceName = "SEQ_MOTO", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Modelo modelo;

    private String placa;
    private Integer ano;
    private String cor;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "cadastro_por")
    private Usuario cadastroPor;

    @ManyToOne
    @JoinColumn(name = "patio_id")
    private Patio patio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
