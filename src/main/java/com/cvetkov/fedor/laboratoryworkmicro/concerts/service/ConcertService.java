package com.cvetkov.fedor.laboratoryworkmicro.concerts.service;

import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.ConcertRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.ConcertResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.ConcertUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConcertService {
    Page<ConcertResponse> getAllPage(Pageable pageable);

    List<ConcertResponse> getAllList();

    ConcertResponse findById(Long id);

    void save(ConcertRequest authorRequest);

    void update(ConcertUpdate authorUpdate);

    void deleteById(Long id);
}
