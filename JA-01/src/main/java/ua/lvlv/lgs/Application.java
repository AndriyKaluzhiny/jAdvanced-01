package ua.lvlv.lgs;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Application {
	
	public static void menu() {
		System.out.println("Enter 1 to add new movie");
		System.out.println("Enter 2 to add new seance");
		System.out.println("Enter 3 to remove movie");
		System.out.println("Enter 4 to remove seance");
		System.out.println("Enter 5 to show movies library");
		System.out.println("Enter 6 to show seances of choosen weekDay");
	}
	
	public static void main(String[] args) {
		Cinema c = new Cinema();

		while (true) {
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			switch (input) {

			case 1: {
				
				System.out.println("Enter movie title: ");
				Scanner scanner = new Scanner(System.in);
				String title = scanner.next();
				
				System.out.println("Enter movie duration(hour): ");
				Scanner scTimeH = new Scanner(System.in);
				int hour = scTimeH.nextInt();
				
				System.out.println("Enter movie duration(hour): ");
				Scanner scTimeM = new Scanner(System.in);
				int minutes = scTimeM.nextInt();
			
				Time duration = new Time(minutes, hour);
				c.addMovie(new Movie(title, duration));
				break;
			}
			case 2: {
				System.out.println("Enter movie title: ");
				Scanner sc2 = new Scanner(System.in);
				String title = sc2.next();
				System.out.println("Enter movie duration(hour): ");
				Scanner sc3 = new Scanner(System.in);
				int hour = sc3.nextInt();
				System.out.println("Enter movie duration(minute): ");
				Scanner sc4 = new Scanner(System.in);
				int minute = sc4.nextInt();

				if (hour > 24 && minute > 60) {
					System.err.println("Time Exception");
				}

				System.out.println("Enter seance time(minute): ");
				Scanner sc5 = new Scanner(System.in);
				int minute1 = sc5.nextInt();

				System.out.println("Enter seance time(Hour): ");
				Scanner sc6 = new Scanner(System.in);
				int hour1 = sc6.nextInt();
				Time seanceTime = new Time(minute1, hour1);
				Time t = new Time(minute, hour);
				Movie m = new Movie(title, t);

				Seance seance = new Seance(m, seanceTime);

				System.out.println("Enter weekDay: ");
				Scanner weekdaySc = new Scanner(System.in);
				String weekDay = weekdaySc.next().toUpperCase();

				if (seance.startTime.hour > 24 || seance.startTime.min > 60) {
					System.err.println("Time Exception");
				} else
					c.addSeance(seance, Days.valueOf(weekDay));

				break;
			}

			case 3: {
				System.out.println("Enter movie title: ");
				Scanner sc2 = new Scanner(System.in);
				String title = sc2.next();
				Movie m = new Movie(title, null);
				c.removeMovie(m);
				break;
			}

			case 4: {
				System.out.println("Enter movie title: ");
				Scanner sc1 = new Scanner(System.in);
				String title = sc1.next();

				System.out.println("Enter movie duration(Hours): ");
				Scanner sc2 = new Scanner(System.in);
				int hour = sc2.nextInt();

				System.out.println("Enter movie duration(minutes): ");
				Scanner sc3 = new Scanner(System.in);
				int min = sc3.nextInt();

				Scanner sc4 = new Scanner(System.in);
				String weekday = sc4.next();

				c.removeSeance(new Seance(new Movie(title, new Time(min, hour)), null), weekday);

				break;
			}

			case 5: {
				Iterator<Movie> iterator = c.moviesLibrary.iterator();

				while (iterator.hasNext()) {
					Movie next = iterator.next();
					System.out.println(next.toString());
				}
				break;
			}

			case 6: {
				System.out.println("Enter weekDay: ");
				Scanner sc1= new Scanner(System.in);
				String weekDay = sc1.next().toUpperCase();
				
				Iterator<Entry<Days, Schedule>> iterator = c.schedules.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<Days, Schedule> entry = iterator.next();
					if (entry.getKey() == Days.valueOf(weekDay)) {
						System.out.println(entry);
					}
				}
				break;
			}
			case 0: {
				System.exit(1);
			}
			}
		}
	}
}
