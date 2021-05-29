package pe.edu.upc.pandemia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

// Interface base para los Service tipo CRUD
public interface CrudService<T, ID> {
		
	JpaRepository<T, ID> getRepository(); 
	
	@Transactional(readOnly = true)
	default List<T> getAll() throws Exception {
		return getRepository().findAll();
	}
	
	@Transactional(readOnly = true)
	default Optional<T> findById(ID id) throws Exception{
		return getRepository().findById(id);
	}
	
	@Transactional
	default T create(T entity) throws Exception {
		return getRepository().save(entity);
	}
	
	@Transactional
	default T update(T entity) throws Exception {
		return getRepository().save(entity);
	}
	
	@Transactional
	default void deleteById(ID id) throws Exception {
		getRepository().deleteById(id);
	}
}
