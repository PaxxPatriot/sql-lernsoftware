package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.util.List;
import java.util.Optional;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ClassType;

public class EntityUtils {

	EntityStorage eStorage = new EntityStorage();
	LoadFromDatabase LFD = new LoadFromDatabase();
	
	public EntityUtils() {
		
	}
	
	
	public void save(ClassType type, Object o) {
		eStorage.save(type, o);
	}
	public Object getObject(ClassType type, long id) {
		return eStorage.getObject(type, id);
	}
	public List<Object> getAll(ClassType type) {
		return eStorage.getAll(type);
	}
	
}
