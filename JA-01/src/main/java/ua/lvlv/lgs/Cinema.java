package ua.lvlv.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Cinema {
	public TreeMap<Days, Schedule> schedules = new TreeMap<>();
	public ArrayList<Movie> moviesLibrary = new ArrayList<>();

	
	// set time open and close
	Time open = new Time(0, 8);
	Time close = new Time(0, 21);

	@Override
	public String toString() {
		return "Cinema [schedules=" + schedules + ", moviesLibrary=" + moviesLibrary + ", open=" + open + ", close="
				+ close + "]";
	}

	public void addMovie(Movie m) {
		if (m.duration.hour > 24 || m.duration.min > 60) {
			System.err.println("Time Exception");
		} else
			moviesLibrary.add(m);
	}

	public void addSeance(Seance seance, Days day) {
		Schedule s = new Schedule();

		Iterator<Movie> iterator = moviesLibrary.iterator();

		while (iterator.hasNext()) {
			Movie movie2 = iterator.next();
			if (movie2.equals(seance.getMovie())) {
				s.addSeance(seance);
				schedules.put(day, s);
			} else if (seance.endTime.hour > close.hour) {
				System.err.println("You can't make a seance at that time");
			} else
				System.err.println(
						"Movies library doesn`t contain this movie, you have to add this movie to movies libray first");
		}

	}

	public void removeMovie(Movie m) {
		Iterator<Movie> iterator = moviesLibrary.iterator();
		while (iterator.hasNext()) {
			Movie next = iterator.next();
			if (next.title.equals(m.title)) {
				iterator.remove();
			}
		}

	}

	public void removeSeance(Seance s, String day) {
		Set<Entry<Days, Schedule>> entry = schedules.entrySet();
		Iterator<Entry<Days, Schedule>> iterator = entry.iterator();
		String dayUpperCase = day.toUpperCase();
		while (iterator.hasNext()) {
			Entry<Days, Schedule> next = iterator.next();
			if (next.getKey().toString().equals(dayUpperCase)) {
				next.getValue().removeSeance(s);
			}
		}
	}

}
