package pe.edu.upc.pandemia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.service.EmployeeService;

@Controller
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("employee/{id}")
	public String viewEmployeeGet(Model model, @ModelAttribute("employeeSearch") Employee employeeSearch, 
			@PathVariable("id") Integer id ) {
		try {
			Optional<Employee> optional = employeeService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("employee", optional.get());
				model.addAttribute("employeeSearch", employeeSearch);
				return "info/employee";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/";
	}
	
}
