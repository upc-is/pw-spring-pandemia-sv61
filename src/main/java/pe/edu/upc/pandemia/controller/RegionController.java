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

import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.service.RegionService;

@Controller
@RequestMapping("/regions")	// GET y POST
@SessionAttributes("regionEdit")
public class RegionController {
	
	@Autowired
	private RegionService regionService; 
	
	@GetMapping		// GET: /region
	public String list(Model model) {
		try {
			List<Region> regions = regionService.getAll();
			model.addAttribute("regions", regions);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "regions/list";
	}
	
	@GetMapping("{id}")		// GET: /region/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Region> optional = regionService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("region", optional.get());
				return "regions/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/regions";
	}
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: /region/{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Region> optional = regionService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("regionEdit", optional.get());
				return "regions/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/regions";
	}

	@PostMapping("saveedit")	// POST: /region/saveedit
	public String saveEdit(Model model, @ModelAttribute("regionEdit") Region region) {		
		try {
			System.out.println(region.getId());
			System.out.println(region.getName());
			//regionService.update(region);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/regions";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /region/new
	public String newregion(Model model) {
		Region region = new Region();
		model.addAttribute("regionNew", region);
		return "regions/new";
	}
	@PostMapping("savenew")	// POST: /region/savenew
	public String saveNew(Model model, @ModelAttribute("regionNew") Region region) {		
		try {
			System.out.println(region.getId());
			System.out.println(region.getName());
			//regionService.create(region);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/regions";
	}	
	
}










