package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.util.List;
import java.util.Optional;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ClassType;



public class EntityStorage {
	
	EntityManagerList emList = new EntityManagerList();
	
	public EntityStorage() {
		super();
		init();
	}
	
	private void init() {
		
	}
	
	public void save(ClassType type, Object o) {//Funktion um ein Objekt einer Klasse im Entity Manager zu speichern, wird typischerweise immer direkt von der Create methode aufgerufen
		emList.get(type).save(o);
	}

	public void update(ClassType type, long id, Object[] params) {//Funktion um die update methode eiunes Objekts aufzurufen
		emList.get(type).update(id, params);
	}

	public Object getObject(ClassType type, long id) {//holt ein objekt je nach class type und id
		Optional ret = emList.get(type).get(id);
		return ret.get();
	}

	public List<Object> getAll(ClassType type) {//gibt alle object eines class types zurück
		return emList.get(type).getAll();
	}

	public void delete(ClassType type, long id) {//löscht ein Objekt aus dem jeweiligen entity manager
		emList.get(type).delete(id);
	}

}
