package com.ameni.medicaments.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ameni.medicaments.entities.Medicament;

public interface MedicamentService {
	
	Medicament saveMedicament(Medicament m);
	Medicament updateMedicament(Medicament m);
	void deleteMedicament(Medicament m);
	void deletMedicamentById(Long id);
	Medicament getMedicament(Long id);
	List<Medicament> getAllMedicaments();
	Page<Medicament> getAllMedicamentsParPage(int page, int size);

}
