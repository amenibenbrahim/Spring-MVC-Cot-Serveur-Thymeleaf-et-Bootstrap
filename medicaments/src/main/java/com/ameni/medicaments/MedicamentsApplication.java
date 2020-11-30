package com.ameni.medicaments;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ameni.medicaments.entities.Medicament;
import com.ameni.medicaments.service.MedicamentService;

@SpringBootApplication
public class MedicamentsApplication implements CommandLineRunner {

	@Autowired
	MedicamentService medicamentService;
	
	public static void main(String[] args) {
		SpringApplication.run(MedicamentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		medicamentService.saveMedicament(new Medicament("Aspegic", 2.600, new Date()));
		medicamentService.saveMedicament(new Medicament("Analgan", 2.800, new Date()));
		medicamentService.saveMedicament(new Medicament("Panadole 1000", 3.900, new Date()));
		
	}

}
