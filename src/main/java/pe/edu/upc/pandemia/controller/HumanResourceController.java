package pe.edu.upc.pandemia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pandemia.business.HumanResourceService;
import pe.edu.upc.pandemia.model.entity.Department;
import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.Job;
import pe.edu.upc.pandemia.service.DepartmentService;
import pe.edu.upc.pandemia.service.EmployeeService;
import pe.edu.upc.pandemia.service.JobService;

@Controller
@RequestMapping("/human-resource")
@SessionAttributes("employeeMoveUp")
public class HumanResourceController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private HumanResourceService humanResourceService;
	
	@GetMapping("moveup/{id}")
	public String moveUpEmployeeGet(Model model, 
			@ModelAttribute("employeeSearch") Employee employeeSearch, 
			@PathVariable("id") Integer id) {
		try {
			Optional<Employee> optional = employeeService.findById(id);
			List<Department> departments = departmentService.getAll(); 
			List<Job> jobs = jobService.getAll();
			
			if(optional.isPresent()) {
				model.addAttribute("employeeMoveUp", optional.get());
				model.addAttribute("employeeSearch", employeeSearch);
				model.addAttribute("departments", departments);
				model.addAttribute("jobs", jobs);
				return "hr/employee-moveup";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/";
	}
	
	@PostMapping("save-moveup")
	public String saveMoveUpEmployeePost(Model model, 
			@ModelAttribute("employeeSearch") Employee employeeSearch,
			@ModelAttribute("employeeMoveUp") Employee employeeMoveUp) {
		
		try {
			humanResourceService.moveUpEmployee(employeeMoveUp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/info/employee/" + employeeMoveUp.getId();
	}
	
	
	
	
	
	
}
