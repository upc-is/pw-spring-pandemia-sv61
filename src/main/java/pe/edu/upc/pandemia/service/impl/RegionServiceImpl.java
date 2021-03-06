package pe.edu.upc.pandemia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.model.repository.RegionRepository;
import pe.edu.upc.pandemia.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	@Override
	public JpaRepository<Region, Integer> getRepository() {
		return regionRepository;
	}
}
