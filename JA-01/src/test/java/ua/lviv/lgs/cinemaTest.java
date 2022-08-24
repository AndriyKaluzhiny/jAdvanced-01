package ua.lviv.lgs;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Map;

import org.junit.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import ua.lvlv.lgs.*;

public class cinemaTest {

	static Cinema cinema;
	public Movie m = new Movie("qwerty", new Time(1, 1));

	@Rule
	public TestWatcher tw = new TestWatcher() {
		@Override
		protected void failed(Throwable e, Description description) {
			System.out.println("FAILED --> " + description.getMethodName());
		}

		protected void succeeded(Description description) {
			System.out.println("SUCCEEDED --> " + description.getMethodName());
		};
	};

	@BeforeClass
	public static void before() {
		cinema = new Cinema();
	}

	@AfterClass
	public static void afterTest() {
		cinema = null;
	}

	@Test
	public void addMovieTest() {

		cinema.moviesLibrary.add(m);
		assertTrue(cinema.moviesLibrary.contains(m));
	}

	@Test
	public void removeMovieTest() {

		cinema.moviesLibrary.add(m);
		cinema.moviesLibrary.remove(m);
		Assert.assertFalse(cinema.moviesLibrary.contains(m));
	}

	@Test
	public void addSeanceTest() {
		Schedule s = new Schedule();
		Seance seance = new Seance(m, new Time(1, 1));
		Days d = Days.SUNDAY;
		s.addSeance(seance);
		cinema.schedules.put(d, s);

		assertTrue(cinema.schedules.containsKey(d) && cinema.schedules.containsValue(s));
	}

	@Test
	public void removeSeanceTest() {
		Schedule s = new Schedule();
		Seance seance = new Seance(m, new Time(1, 1));
		Days d = Days.SUNDAY;
		s.addSeance(seance);
		cinema.schedules.put(d, s);
		s.removeSeance(seance);
		cinema.schedules.remove(d, s);

		Assert.assertFalse(cinema.schedules.containsKey(d) && cinema.schedules.containsValue(s));
	}
}
