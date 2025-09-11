package com.projectMottu.gef.service;


import com.projectMottu.gef.dto.MotoRequest;
import com.projectMottu.gef.dto.MotoResponse;
import com.projectMottu.gef.mapper.MotoMapper;
import com.projectMottu.gef.model.Modelo;
import com.projectMottu.gef.model.Moto;
import com.projectMottu.gef.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class MotoService {
    private final MotoRepository motoRepository;
    private final MotoMapper motoMapper = new MotoMapper();

    @Autowired
    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public MotoResponse save(MotoRequest motoRequest) {
        return motoMapper.responseMoto(motoRepository.save(motoMapper.requestMoto(motoRequest)));
    }

    public Page<MotoResponse> findAll(Pageable pageable) {
        return motoRepository.findAll(pageable).map(motoMapper::responseMoto);
    }

    public Moto findMotoById(Long id) {
        Optional<Moto> moto = motoRepository.findById(id);
        return moto.orElse(null);
    }

    public MotoResponse findById(Long id) {
        Optional<Moto> moto = motoRepository.findById(id);
        return moto.map(motoMapper::responseMoto).orElse(null);
    }

    public MotoResponse update(MotoRequest motoRequest, Long id) {
        Optional<Moto> motoOptional = motoRepository.findById(id);
        if (motoOptional.isPresent()) {
            Moto moto = motoOptional.get();

            moto.setModelo(Modelo.valueOf(motoRequest.modelo().toUpperCase()));
            moto.setAno(motoRequest.ano());
            moto.setCor(motoRequest.cor());
            moto.setPlaca(motoRequest.placa());
            moto.setStatus(motoRequest.status());

            Moto motoAtualizada = motoRepository.save(moto);
            return motoMapper.responseMoto(motoAtualizada);
        }

        return null;
    }

    public boolean delete(Long id) {
        Optional<Moto> moto = motoRepository.findById(id);
        if (moto.isPresent()) {
            motoRepository.delete(moto.get());
            return true;
        }
        return false;
    }
}