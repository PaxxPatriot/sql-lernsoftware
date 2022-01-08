package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.util.HashMap;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ClassType;



public class EntityManagerList {
	
	private HashMap<ClassType,EntityManager> managers = new HashMap<ClassType,EntityManager>();
	
	public EntityManagerList() {
		init();
	}
	
	private void init() {		
			managers.put(ClassType.LEKTION,new LektionEntityManager());
	}
	public EntityManager get(ClassType cType) {
		return managers.get(cType);
	}
	
	
}
