package de.dhbw.studienarbeit.sqllernsoftware.backend.enums;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.*;


public enum ClassType {
	LEKTION("Lektion",Lektion.class);
	
	
	private String displayName;
	private Class<?> cls;
	
	ClassType(String displayName,Class<?> cls) {
		this.displayName = displayName;
		this.cls = cls;
	}
	public String getDisplayName() {
		return displayName;
	}
	public Class<?> getMgr() {
		return cls;
	}
}
