package pe.edu.upc.pandemia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.JobHistory;
import pe.edu.upc.pandemia.model.entity.JobHistoryId;
import pe.edu.upc.pandemia.model.repository.JobHistoryRepository;
import pe.edu.upc.pandemia.service.JobHistoryService;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {

	@Autowired
	private JobHistoryRepository jobHistoryRepository;
	
	@Override
	public JpaRepository<JobHistory, JobHistoryId> getRepository() {
		return jobHistoryRepository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<JobHistory> findByEmployee(Employee employee) throws Exception {
		return jobHistoryRepository.findByEmployee(employee);
	}

}
