package com.example.scheduler.service;

import com.example.scheduler.domain.Specialist;
import com.example.scheduler.repository.SpecialistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialistService {

    private final SpecialistRepository specialistRepository;

    @Transactional
    public Specialist createSpecialist(String name, String specialization, String email) {

        if (specialistRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Specialist with email " + email + " already exists");
        }

        Specialist specialist = Specialist.builder()
                .name(name)
                .specialization(specialization)
                .email(email)
                .build();

        return specialistRepository.save(specialist);
    }

    @Transactional(readOnly = true)
    public Specialist getSpecialistById(Long id) {
        return specialistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Specialist with id " + id + " not found"));
    }

    @Transactional(readOnly = true)
    public List<Specialist> getAllSpecialists() {
        return specialistRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Specialist getSpecialistByEmail(String email) {
        return specialistRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Specialist with email " + email + " not found"));
    }

    @Transactional
    public void deleteSpecialist(Long id) {
        if (!specialistRepository.existsById(id)) {
            throw new IllegalArgumentException("Specialist with id " + id + " not found");
        }
        specialistRepository.deleteById(id);
    }
}