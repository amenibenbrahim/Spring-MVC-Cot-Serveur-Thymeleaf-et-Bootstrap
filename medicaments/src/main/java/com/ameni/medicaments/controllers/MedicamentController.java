package com.ameni.medicaments.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ameni.medicaments.entities.Medicament;
import com.ameni.medicaments.service.MedicamentService;

@Controller
public class MedicamentController {
	
	@Autowired
	MedicamentService medicamentService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createMedicament";
	}
	
	@RequestMapping("/saveMedicament")
	public String saveMedicament(@ModelAttribute("medicament") Medicament medicament,
	@RequestParam("date") String date,
	ModelMap modelMap) throws
	ParseException
	{
	//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateVente = dateformat.parse(String.valueOf(date));
		medicament.setDateVente(dateVente);
		Medicament saveMedicament = medicamentService.saveMedicament(medicament);
	String msg ="Medicament enregistré avec Id "+saveMedicament.getIdMedicament();
	modelMap.addAttribute("msg", msg);
	return "createMedicament";
	}

	@RequestMapping("/ListeMedicaments")
	public String listeMedicaments(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Medicament> medcs = medicamentService.getAllMedicamentsParPage(page, size);
		modelMap.addAttribute("medicaments", medcs);
		modelMap.addAttribute("pages", new int[medcs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeMedicaments";
	}
	
	@RequestMapping("/supprimerMedicament")
	public String supprimerMedicament(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
		medicamentService.deletMedicamentById(id);
		Page<Medicament> medcs = medicamentService.getAllMedicamentsParPage(page,size);
		modelMap.addAttribute("medicaments", medcs);
		modelMap.addAttribute("pages", new int[medcs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeMedicaments";
	}
	
	@RequestMapping("/modifierMedicament")
	public String editerMedicament(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Medicament m= medicamentService.getMedicament(id);
		modelMap.addAttribute("medicament", m);
		return "editerMedicament";
	}
	@RequestMapping("/updateMedicament")
	public String updateMedicament(@ModelAttribute("medicament") Medicament medicament,
	@RequestParam("date") String date, ModelMap modelMap) throws ParseException
	{
		//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateVente = dateformat.parse(String.valueOf(date));
		medicament.setDateVente(dateVente);
		medicamentService.updateMedicament(medicament);
		List<Medicament> medcs = medicamentService.getAllMedicaments();
		modelMap.addAttribute("medicaments", medcs);
		return "listeMedicaments";
		}
	
	
}
