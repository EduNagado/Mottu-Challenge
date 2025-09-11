package com.projectMottu.gef.dto;

import com.projectMottu.gef.model.Status;


public record MotoResponse(
        Long idMoto,
        String modelo,
        Integer ano,
        String cor,
        String placa,
        Status status
) {


}
