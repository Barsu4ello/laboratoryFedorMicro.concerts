package com.cvetkov.fedor.laboratoryworkmicro.concerts.controller;

import com.cvetkov.fedor.laboratoryworkmicro.concerts.service.CountryService;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.CountryRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.CountryResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.CountryUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    // @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Page<CountryResponse> getAllCountries(@PageableDefault(size = 5) Pageable pageable) {
        return countryService.getAllPage(pageable);
    }

    @GetMapping("/all-country")
    // @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<CountryResponse> getAllCountries() {
        return countryService.getAllList();
    }

    @GetMapping("/{id}")
    // @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public CountryResponse getCountryById(@PathVariable Long id) {
        return countryService.findById(id);
    }

    @PostMapping
    // @PreAuthorize("hasAuthority('ADMIN')")
    public void addCountry(@Valid @RequestBody CountryRequest countryRequest) {
        countryService.save(countryRequest);
    }

    @PutMapping
    // @PreAuthorize("hasAuthority('ADMIN')")
    public void updateCountry(@Valid @RequestBody CountryUpdate countryUpdate) {
        countryService.update(countryUpdate);
    }

    @DeleteMapping("/{id}")
    // @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteById(id);
    }
}
