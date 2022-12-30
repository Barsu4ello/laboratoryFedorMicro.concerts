package com.cvetkov.fedor.laboratoryworkmicro.concerts.controller;

import com.cvetkov.fedor.laboratoryworkmicro.concerts.service.CityService;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.CityRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.CityResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.CityUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/city")
public class CityController {

    private final CityService cityService;

    @GetMapping
    // @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Page<CityResponse> getAllCities(@PageableDefault(size = 5) Pageable pageable) {
        return cityService.getAllPage(pageable);
    }

    @GetMapping("/all-city")
    // @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<CityResponse> getAllCities() {
        return cityService.getAllList();
    }

    @GetMapping("/{id}")
    // @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public CityResponse getCityById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @PostMapping
    // @PreAuthorize("hasAuthority('ADMIN')")
    public void addCity(@Valid @RequestBody CityRequest cityRequest) {
        cityService.save(cityRequest);
    }

    @PutMapping
    // @PreAuthorize("hasAuthority('ADMIN')")
    public void updateCity(@Valid @RequestBody CityUpdate cityUpdate) {
        cityService.update(cityUpdate);
    }

    @DeleteMapping("/{id}")
    // @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteById(id);
    }
}
