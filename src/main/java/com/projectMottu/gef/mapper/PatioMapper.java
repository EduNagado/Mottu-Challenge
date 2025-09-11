package com.projectMottu.gef.mapper;


import com.projectMottu.gef.dto.PatioRequest;
import com.projectMottu.gef.dto.PatioResponse;
import com.projectMottu.gef.model.Patio;

public class PatioMapper {

    public Patio requestPatio(PatioRequest patioRequest) {
        Patio patio = new Patio();
        patio.setLocalizacao(patioRequest.localizacao());
        patio.setQuantidadeVagas(patioRequest.quantidadeVagas());
        return patio;
    }

    public PatioResponse responsePatio(Patio patio) {
        return new PatioResponse(
                patio.getIdPatio(),
                patio.getLocalizacao(),
                patio.getQuantidadeVagas());
    }
}
