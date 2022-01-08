package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;
import java.util.List;
import java.util.Optional;

public interface EntityManager<E> {
	
	public Optional<E> get(long id);
	
	public void delete(long id);
	
	public void save(E e);
	
	public void update(long id, Object[] params);
	
	List<E> getAll();
}
