package com.ameni.medicaments.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ameni.medicaments.entities.Medicament;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

}
