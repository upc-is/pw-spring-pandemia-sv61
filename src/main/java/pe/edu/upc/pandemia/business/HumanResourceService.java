package pe.edu.upc.pandemia.business;

import pe.edu.upc.pandemia.model.entity.Employee;

public interface HumanResourceService {
	void moveUpEmployee(Employee employeeMoveUp) throws Exception;
}
