package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;

public class LektionEntityManager implements EntityManager<Lektion> {

	private HashMap<Long,Lektion> search = new HashMap<Long,Lektion>();
	
	@Override
	public Optional<Lektion> get(Long id) {
		return Optional.of(search.get(id));
	}

	@Override
	public void delete(Long id) {
		
	}

	@Override
	public void save(Lektion e) {
		search.put(e.getId(), e);
	}

	@Override
	public void update(Long id, Object[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Lektion> getAll() {
		List<Lektion> ret = new ArrayList<Lektion>();
		for(Map.Entry<Long, Lektion> entry : search.entrySet()) {
			ret.add(entry.getValue());
		}
	return ret;
	}

}
