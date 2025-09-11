package com.projectMottu.gef.model;

public enum Cargo {
    ADMINISTRADOR ("administrador"),
    GERENTE("gerente"),
    ATENDENTE("atendente"),
    MECANICO ("mecanico"),
    AUXILIAR("auxiliar"),
    ENTREGADOR("entregador");


    private final String role;

    Cargo(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
