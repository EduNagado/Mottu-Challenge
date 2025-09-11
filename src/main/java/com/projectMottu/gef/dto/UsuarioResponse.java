package com.projectMottu.gef.dto;

import com.projectMottu.gef.model.Cargo;


public record UsuarioResponse(
        Long idUsuario,
        String nome,
        String email,
        String password,
        String cpf,
        Cargo cargo
) {
}
