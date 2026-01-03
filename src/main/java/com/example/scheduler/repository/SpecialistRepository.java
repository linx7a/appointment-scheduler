package com.example.scheduler.repository;

import com.example.scheduler.domain.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    Optional<Specialist> findByEmail(String email);

    boolean existsByEmail(String email);
}
