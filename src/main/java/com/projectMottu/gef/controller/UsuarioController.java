package com.projectMottu.gef.controller;


import com.projectMottu.gef.dto.UsuarioRequest;
import com.projectMottu.gef.dto.UsuarioResponse;
import com.projectMottu.gef.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/usuarios")
@Tag(name = "Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // CREATE
    @Operation(summary = "Cria um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso!",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponse.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros informados são inválidos!",
                    content = @Content(schema = @Schema()))
    })
    @PostMapping
    public ResponseEntity<UsuarioResponse> createUsuario(@Valid @RequestBody UsuarioRequest usuario) {
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    // READ ALL
    @Operation(summary = "Lista todos os usuários")
    @GetMapping
    public ResponseEntity<Page<UsuarioResponse>> readUsuarios(@RequestParam(defaultValue = "0") Integer pageNumber) {
        Pageable pageable = PageRequest
                .of(pageNumber, 5, Sort.by("nome").ascending());
        return new ResponseEntity<>(usuarioService.findAll(pageable), HttpStatus.OK);
    }

    // READ BY ID
    @Operation(summary = "Retorna um usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso!",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponse.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado para o ID fornecido!",
                    content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> readUsuario(@PathVariable Long id) {
        UsuarioResponse usuario = usuarioService.findById(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    // UPDATE
    @Operation(summary = "Atualiza um usuário existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário atualizado com sucesso!",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponse.class))),
            @ApiResponse(responseCode = "400", description = "Nenhum usuário encontrado para o ID fornecido!",
                    content = @Content(schema = @Schema()))
    })
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> updateUsuario(@PathVariable Long id,
                                                         @Valid @RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse usuario = usuarioService.update(usuarioRequest, id);
        if (usuario == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    // DELETE
    @Operation(summary = "Exclui um usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário excluído com sucesso!",
                    content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "400", description = "Nenhum usuário encontrado para o ID fornecido!",
                    content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        boolean deletado = usuarioService.delete(id);
        if (!deletado) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
