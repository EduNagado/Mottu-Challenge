package com.projectMottu.gef.service;


import com.projectMottu.gef.dto.UsuarioRequest;
import com.projectMottu.gef.dto.UsuarioResponse;
import com.projectMottu.gef.mapper.UsuarioMapper;
import com.projectMottu.gef.model.Usuario;
import com.projectMottu.gef.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper = new UsuarioMapper();

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponse save(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioMapper.usuarioRequest(usuarioRequest);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioMapper.usuarioResponse(usuarioSalvo);
    }

    public Page<UsuarioResponse> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable)
                .map(usuarioMapper::usuarioResponse);
    }

    public Usuario findUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public UsuarioResponse findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(usuarioMapper::usuarioResponse).orElse(null);
    }

    public UsuarioResponse update(UsuarioRequest usuarioRequest, Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioRequest.nome());
            usuario.setEmail(usuarioRequest.email());
            usuario.setPassword(usuarioRequest.password());
            usuario.setCargo(usuarioRequest.cargo());

            Usuario usuarioAtualizado = usuarioRepository.save(usuario);
            return usuarioMapper.usuarioResponse(usuarioAtualizado);
        }

        return null;
    }

    public boolean delete(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return true;
        }
        return false;
    }
}