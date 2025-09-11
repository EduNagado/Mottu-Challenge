package com.projectMottu.gef.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "patio")
public class Patio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatio;
    private String localizacao;
    private Integer quantidadeVagas;

    @ManyToOne
    @JoinColumn(name = "cadastro_por") // FK para usuario.id
    private Usuario cadastroPor;
    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Moto> motos = new ArrayList<>();

    public Long getIdPatio() {
        return idPatio;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(Integer quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }
}
