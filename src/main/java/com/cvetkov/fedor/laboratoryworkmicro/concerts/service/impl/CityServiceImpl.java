package com.cvetkov.fedor.laboratoryworkmicro.concerts.service.impl;

import com.cvetkov.fedor.laboratoryworkmicro.concerts.repository.CityRepository;
import com.cvetkov.fedor.laboratoryworkmicro.concerts.service.CityService;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.CityRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.CityResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.CityUpdate;
import com.cvetkov.fedor.laboratoryworkmicro.entities.mapper.CityMapper;
import com.cvetkov.fedor.laboratoryworkmicro.utils.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
//    private final UserRepository userRepository;
    private final CityMapper cityMapper;

    @Override
    public Page<CityResponse> getAllPage(Pageable pageable) {
        return cityMapper.cityToCityResponsePage(cityRepository.findAll(pageable));
    }

    @Override
    public List<CityResponse> getAllList() {
        return cityMapper.cityToCityResponseList(cityRepository.findAll());
    }

    @Override
    public CityResponse findById(Long id) {
        return cityMapper
                .cityToCityResponse(cityRepository
                        .findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException("City with id " + id + " not found")));
    }

    @Override
    public void save(CityRequest authorRequest) {
        cityRepository.save(cityMapper.cityRequestToCity(authorRequest));
    }

    @Override
    public void update(CityUpdate authorUpdate) {
        cityRepository.save(cityMapper.cityUpdateToCity(authorUpdate));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
//        List<User> users = userRepository.findUSersByCityId(id);
//        users = users.stream().peek(user -> user.setCity(null)).collect(Collectors.toList());
//        userRepository.saveAll(users);
        cityRepository.deleteById(id);
    }
}
