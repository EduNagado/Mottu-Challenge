package com.projectMottu.gef.mapper;


import com.projectMottu.gef.dto.MotoRequest;
import com.projectMottu.gef.dto.MotoResponse;
import com.projectMottu.gef.model.Modelo;
import com.projectMottu.gef.model.Moto;

public class MotoMapper {

    public Moto requestMoto(MotoRequest motoRequest) {
        Moto moto = new Moto();

        moto.setModelo(Modelo.valueOf(motoRequest.modelo().toUpperCase()));
        moto.setAno(motoRequest.ano());
        moto.setCor(motoRequest.cor());
        moto.setPlaca(motoRequest.placa());
        moto.setStatus(motoRequest.status());


        return moto;
    }

    public MotoResponse responseMoto(Moto moto) {
        return new MotoResponse(
                moto.getId(),
                moto.getModelo().name(),
                moto.getAno(),
                moto.getCor(),
                moto.getPlaca(),
                moto.getStatus());
    }
}

