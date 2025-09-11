package com.projectMottu.gef.dto;

import com.projectMottu.gef.model.Status;
import com.projectMottu.gef.validation.AnoValido;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Year;


public record MotoRequest(
        @NotBlank(message = "O modelo da moto é obrigatório.") String modelo,
        @AnoValido(message = "O ano deve ser entre 1000 e o próximo ano")
        @NotNull(message = "O ano da moto é obrigatório.") Integer ano,
        @NotBlank(message = "A cor da moto é obrigatória.") String cor,
        @NotBlank(message = "A placa da moto é obrigatória.") String placa,
        @NotNull(message = "O status da moto é obrigatório.") Status status
) {
}
