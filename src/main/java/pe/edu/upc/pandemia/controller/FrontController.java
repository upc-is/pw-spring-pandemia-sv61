package pe.edu.upc.pandemia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.service.RegionService;

@Controller
@RequestMapping("/")
public class FrontController {
	
	@Autowired
	private RegionService regionService;
	
	// GET y POST
	@GetMapping
	public String index(Model model) {
		Employee employeeSearch = new Employee();
		model.addAttribute("employeeSearch", employeeSearch);
		return "index";
	}
	
	
	@GetMapping("saludar")
	public String saludar() {
		try {
			Region region = regionService.create(new Region());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pagina";
	}
	@GetMapping("layout")
	public String layout() {
		return "layout/layout";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
}
