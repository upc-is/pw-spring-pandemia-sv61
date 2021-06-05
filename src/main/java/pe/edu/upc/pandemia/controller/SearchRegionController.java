package pe.edu.upc.pandemia.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.model.entity.Region;

@RequestMapping("/searchregion")
public class SearchRegionController {

	@PostMapping		// POST: /searchregion
	public String search(@ModelAttribute("regionSearch") Region region) {
		return "";
	}
	
}
