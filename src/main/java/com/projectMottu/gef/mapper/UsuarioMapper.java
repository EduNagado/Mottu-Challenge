package com.projectMottu.gef.mapper;


import com.projectMottu.gef.dto.UsuarioRequest;
import com.projectMottu.gef.dto.UsuarioResponse;
import com.projectMottu.gef.model.Usuario;

public class UsuarioMapper {

    public Usuario usuarioRequest(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.nome());
        usuario.setPassword(usuarioRequest.password());
        usuario.setEmail(usuarioRequest.email());
        usuario.setCpf(usuarioRequest.cpf());
        usuario.setCargo(usuarioRequest.cargo());
        return usuario;
    }

public UsuarioResponse usuarioResponse(Usuario usuario) {
    return new UsuarioResponse(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getPassword(),
            usuario.getCpf(),
            usuario.getCargo()
    );
    }
}
