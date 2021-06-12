package pe.edu.upc.pandemia.init;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.User;
import pe.edu.upc.pandemia.model.repository.EmployeeRepository;
import pe.edu.upc.pandemia.model.repository.UserRepository;

@Service
public class InitDB implements CommandLineRunner{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// SOLO DESBLOQUEAR CUANDO SE CREEN USUARIOS DE FORMA MANUAL
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		/*
		Optional<Employee> optional = employeeRepository.findById(131);
		if(optional.isPresent()) {
			Employee james = optional.get();
			User jmarlow = new User("jmarlow", bcpe.encode("marlow"), james);
			// ROLE -> Segmento Objetivo
			jmarlow.addAuthority("ROLE_EMPLOYEE");
			// ACCESS -> 
			jmarlow.addAuthority("ACCESS_VIEW_EMPLOYEE");
			jmarlow.addAuthority("ACCESS_APPLY_JOB");
			userRepository.save(jmarlow);
		}
		
		Optional<Employee> optional2 = employeeRepository.findById(117);
		if(optional2.isPresent()) {
			Employee sigal = optional2.get();
			User stobias = new User("stobias", bcpe.encode("tobias"), sigal);
			// ROLE -> Segmento Objetivo
			stobias.addAuthority("ROLE_MANAGER");
			// ACCESS -> 
			stobias.addAuthority("ACCESS_EDIT_EMPLOYEE");
			stobias.addAuthority("ACCESS_CREATE_EMPLOYEE");
			userRepository.save(stobias);
		}
		*/
	}

}
