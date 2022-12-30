package com.cvetkov.fedor.laboratoryworkmicro.concerts.repository;

import com.cvetkov.fedor.laboratoryworkmicro.entities.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
}
