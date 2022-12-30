package com.cvetkov.fedor.laboratoryworkmicro.concerts.service.impl;

import com.cvetkov.fedor.laboratoryworkmicro.concerts.repository.ConcertRepository;
import com.cvetkov.fedor.laboratoryworkmicro.concerts.service.ConcertService;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.ConcertRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.ConcertResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.ConcertUpdate;
import com.cvetkov.fedor.laboratoryworkmicro.entities.mapper.ConcertMapper;
import com.cvetkov.fedor.laboratoryworkmicro.utils.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService {
    private final ConcertRepository concertRepository;
    private final ConcertMapper concertMapper;

    @Override
    public Page<ConcertResponse> getAllPage(Pageable pageable) {
        return concertMapper.concerToConcertResponsePage(concertRepository.findAll(pageable));
    }

    @Override
    public List<ConcertResponse> getAllList() {
        return concertMapper.concertToConcertResponseList(concertRepository.findAll());
    }

    @Override
    public ConcertResponse findById(Long id) {
        return concertMapper
                .concertToConcertResponse(concertRepository
                        .findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException("Concert with id " + id + " not found")));
    }

    @Override
    public void save(ConcertRequest authorRequest) {
        concertRepository.save(concertMapper.concertRequestToConcert(authorRequest));
    }

    @Override
    public void update(ConcertUpdate authorUpdate) {
        concertRepository.save(concertMapper.concertUpdateToConcert(authorUpdate));
    }

    @Override
    public void deleteById(Long id) {
        concertRepository.deleteById(id);
    }
}
