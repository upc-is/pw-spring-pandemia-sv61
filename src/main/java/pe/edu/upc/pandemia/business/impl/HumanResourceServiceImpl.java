package pe.edu.upc.pandemia.business.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.pandemia.business.HumanResourceService;
import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.JobHistory;
import pe.edu.upc.pandemia.model.repository.EmployeeRepository;
import pe.edu.upc.pandemia.model.repository.JobHistoryRepository;
import pe.edu.upc.pandemia.service.EmployeeService;

@Service
public class HumanResourceServiceImpl implements HumanResourceService {

	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Autowired
	private JobHistoryRepository jobHistoryRepository;
	
	@Transactional
	@Override
	public void moveUpEmployee(Employee employeeMoveUp) throws Exception {		
		
		Optional<Employee> optional = employeeRepository.findById(employeeMoveUp.getId());
		if (optional.isPresent()) {
			Employee employee = optional.get();
			JobHistory jobHistory = new JobHistory();
			
			jobHistory.setEmployee(employee);
			jobHistory.setStartDate(employee.getHireDate());
			jobHistory.setEndDate(new Date());
			jobHistory.setJob(employee.getJob());
			jobHistory.setDepartment(employee.getDepartment());
			
			jobHistoryRepository.save(jobHistory); // error
			
			employee.setJob(employeeMoveUp.getJob());
			employee.setDepartment(employeeMoveUp.getDepartment());
			employee.setSalary(employeeMoveUp.getSalary());
			employee.setHireDate(new Date());
			
			employeeRepository.save(employee);	// error
								
		}
	}

}
