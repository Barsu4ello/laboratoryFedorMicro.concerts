package com.cvetkov.fedor.laboratoryworkmicro.concerts.repository;

import com.cvetkov.fedor.laboratoryworkmicro.entities.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
