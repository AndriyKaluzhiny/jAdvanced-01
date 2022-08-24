package ua.lvlv.lgs;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {
	private Set<Seance> seances = new TreeSet<>();

	public void addSeance(Seance s) {
		seances.add(s);
	}

	public void removeSeance(Seance s) {
		Iterator<Seance> iterator = seances.iterator();

		while (iterator.hasNext()) {
			Seance seance = iterator.next();
			if (seance.movie.equals(s.movie) && seance.startTime.equals(s.startTime)) {
				iterator.remove();
			}
		}
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	@Override
	public String toString() {
		return "Schedule [seances=" + seances + "]";
	}
	
	
}
