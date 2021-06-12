package pe.edu.upc.pandemia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.service.EmployeeService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("employees")		// POST: /search/employees
	public String searchEmployees(Model model , @ModelAttribute("employeeSearch") Employee employeeSearch) {
		System.out.println("LLEGO");
		List<Employee> employees = null;
		try {
			employees = employeeService
					.findByLastNameStartingWithAndFirstNameStartingWith(employeeSearch.getLastName(), "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("employees", employees);
		model.addAttribute("employeeSearch", employeeSearch);
		return "search/employees";
	}
	
}
