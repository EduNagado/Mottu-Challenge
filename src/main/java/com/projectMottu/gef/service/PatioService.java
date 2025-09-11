package com.projectMottu.gef.service;


import com.projectMottu.gef.dto.PatioRequest;
import com.projectMottu.gef.dto.PatioResponse;
import com.projectMottu.gef.mapper.PatioMapper;
import com.projectMottu.gef.model.Patio;
import com.projectMottu.gef.repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatioService {
    private final PatioRepository patioRepository;
    private final PatioMapper patioMapper = new PatioMapper();

    @Autowired
    public PatioService(PatioRepository patioRepository) {
        this.patioRepository = patioRepository;
    }

    public PatioResponse save(PatioRequest patioRequest) {
        return patioMapper.responsePatio(patioRepository.save(patioMapper.requestPatio(patioRequest)));
    }

    public Page<PatioResponse> findAll(Pageable pageable) {
        return patioRepository.findAll(pageable).map(patioMapper::responsePatio);
    }

    public Patio findPatioById(Long id) {
        Optional<Patio> patio = patioRepository.findById(id);
        return patio.orElse(null);
    }

    public PatioResponse findById(Long id) {
        Optional<Patio> patio = patioRepository.findById(id);
        return patio.map(patioMapper::responsePatio).orElse(null);
    }

    public PatioResponse update(PatioRequest patioRequest, Long id) {
        Optional<Patio> patioOptional = patioRepository.findById(id);
        if (patioOptional.isPresent()) {
            Patio patio = patioOptional.get();
            patio.setLocalizacao(patioRequest.localizacao());
            patio.setQuantidadeVagas(patioRequest.quantidadeVagas());

            Patio patioAtualizado = patioRepository.save(patio);
            return patioMapper.responsePatio(patioAtualizado);
        }

        return null;
    }

    public boolean delete(Long id) {
        Optional<Patio> patio = patioRepository.findById(id);
        if (patio.isPresent()) {
            patioRepository.delete(patio.get());
            return true;
        }
        return false;
    }
}
