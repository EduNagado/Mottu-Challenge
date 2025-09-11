package com.projectMottu.gef.dto;

import com.projectMottu.gef.model.Cargo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioRequest(
        @NotBlank(message = "O nome de usuário é obrigatório.") String nome,
        @Email(message = "Email fora do formato correto.") String email,
        @NotNull(message = "A senha do usuario é obrigatório.") String password,
        @CPF(message = "CPF fora do formato correto.") String cpf,
        @NotNull(message = "O cargo do usuario é obrigatorio.") Cargo cargo
        ) {
}
