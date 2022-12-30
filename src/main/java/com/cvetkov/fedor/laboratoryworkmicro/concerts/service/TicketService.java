package com.cvetkov.fedor.laboratoryworkmicro.concerts.service;

import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.TicketRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.TicketResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.TicketUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {
    Page<TicketResponse> getAllPage(Pageable pageable);

    List<TicketResponse> getAllList();

    TicketResponse findById(Long id);

    void save(TicketRequest ticketRequest);

    void update(TicketUpdate ticketUpdate);

    void deleteById(Long id);
}
