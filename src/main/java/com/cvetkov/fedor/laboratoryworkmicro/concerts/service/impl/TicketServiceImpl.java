package com.cvetkov.fedor.laboratoryworkmicro.concerts.service.impl;

import com.cvetkov.fedor.laboratoryworkmicro.concerts.feign.UserFeignClient;
import com.cvetkov.fedor.laboratoryworkmicro.concerts.repository.TicketRepository;
import com.cvetkov.fedor.laboratoryworkmicro.concerts.service.TicketService;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.TicketRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.TicketResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.TicketUpdate;
import com.cvetkov.fedor.laboratoryworkmicro.entities.mapper.TicketMapper;
import com.cvetkov.fedor.laboratoryworkmicro.utils.exception.ExceptionResponseStatusChecker;
import com.cvetkov.fedor.laboratoryworkmicro.utils.exception.ObjectNotFoundException;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
//    private final UserFeignClient userFeignClient;

    @Override
    public Page<TicketResponse> getAllPage(Pageable pageable) {
        return ticketMapper.ticketToTicketResponsePage(ticketRepository.findAll(pageable));
    }

    @Override
    public List<TicketResponse> getAllList() {
        return ticketMapper.ticketToTicketResponseList(ticketRepository.findAll());
    }

    @Override
    public TicketResponse findById(Long id) {
        return ticketMapper
                .ticketToTicketResponse(ticketRepository
                        .findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException("Ticket with id " + id + " not found")));
    }

    @Override
    public void save(TicketRequest ticketRequest) {
        // Проверим есть такой пользователь в микросервисе users, иначе будет FeignException //(c KeyCloak это не надо)
//        Long userId = ticketRequest.getUserId();
//        userFeignClient.getUserById(userId);

        ticketRepository.save(ticketMapper.ticketRequestToTicket(ticketRequest));
    }

    @Override
    public void update(TicketUpdate ticketUpdate) {
        // Проверим есть такой пользователь в микросервисе users, иначе будет FeignException //(c KeyCloak это не надо)
//        Long userId = ticketUpdate.getUserId();
//        userFeignClient.getUserById(userId);

        ticketRepository.save(ticketMapper.ticketUpdateToTicket(ticketUpdate));
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }
}
