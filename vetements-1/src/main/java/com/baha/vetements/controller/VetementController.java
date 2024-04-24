package com.baha.vetements.controller;

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

import com.baha.vetements.entities.Vetement;
import com.baha.vetements.service.VetementService;



@Controller
public class VetementController {
	@Autowired
	VetementService vetementService;

	@RequestMapping("/listeVetements")
	public String listeVetements(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Page<Vetement> prods = vetementService.getAllVetementsParPage(page, size);
		modelMap.addAttribute("vetements", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeVetements";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createVetement";
	}

	@RequestMapping("/saveVetement")
	public String saveVetement(@ModelAttribute("vetement") Vetement vetement, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		{ // conversion de la date
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateCreation = dateformat.parse(String.valueOf(date));
			vetement.setDateCreation(dateCreation);
			Vetement saveVetement = vetementService.saveVetement(vetement);
			String msg = "vetement enregistré avec Id " + saveVetement.getIdVetement();
			modelMap.addAttribute("msg", msg);
			return "createVetement";
		}
	}

	@RequestMapping("/supprimerVetement")
	public String supprimerVetement(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		vetementService.deleteVetementById(id);
		Page<Vetement> prods = vetementService.getAllVetementsParPage(page, size);
		modelMap.addAttribute("vetements", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeVetements";
		}
	

	@RequestMapping("/modifierVetement")
	public String editerVetement(@RequestParam("id") Long id, ModelMap modelMap) {
		Vetement p = vetementService.getVetement(id);
		modelMap.addAttribute("vetement", p);
		return "editerVetement";
	}

	@RequestMapping("/updateVetement")
	public String updateVetement(@ModelAttribute("vetement") Vetement vetement, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
// conversion de la date 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		vetement.setDateCreation(dateCreation);
		vetementService.updateVetement(vetement);
		List<Vetement> prods = vetementService.getAllVetements();
		modelMap.addAttribute("vetements", prods);
		return "listeVetements";
	}
}