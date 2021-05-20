package net.itinajero.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.itinajero.model.Vacante;
import net.itinajero.repository.VacantesRepository;
import net.itinajero.service.IVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService serviceVacantes;

	

	@GetMapping("/")
	public String MostrarHome(Model modelo) {
		modelo.addAttribute("vacantes", serviceVacantes.buscarDestacadas());
		return "home";	
	}
	

	//Buscar mas informacion sobre este metodo
	// @ModelAttribute
	// public void setGenericos(Model modelo) {
	// 	modelo.addAttribute("vacantes", serviceVacantes.buscarDestacadas());	
	// }
	
	@GetMapping("/listado")
	public String mostrarListado(Model modelo) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ing. Sistemas");
		lista.add("Ausiliar de contabilidad");
		lista.add("Arquitecto");
		modelo.addAttribute("empleados", lista);
		return "listado";
	}
	
	@GetMapping("/tabla")
	public String MostrarTabla(Model modelo) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		modelo.addAttribute("vacantes", lista);
		return "tabla";		
	}
	

	
}
