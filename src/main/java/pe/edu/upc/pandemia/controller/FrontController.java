package pe.edu.upc.pandemia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.service.RegionService;

@Controller
@RequestMapping("/saludo")
public class FrontController {
	
	@Autowired
	private RegionService regionService;
	
	// GET y POST
	
	@GetMapping
	public String saludar() {
		try {
			Region region = regionService.create(new Region());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pagina";
	}
	
}
