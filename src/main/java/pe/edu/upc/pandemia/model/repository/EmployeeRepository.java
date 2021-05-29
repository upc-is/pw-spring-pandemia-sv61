package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByLastNameAndFirstName(String lastName, String firstName);
	
	//@Query("select e from Employee e where e.lastName like CONCAT(:lastName,'%') and e.firstName like CONCAT(:firstName, '%')")
	@Query("select e from Employee e where e.lastName like ?1% and e.firstName like ?2%")
	List<Employee> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName);
}
