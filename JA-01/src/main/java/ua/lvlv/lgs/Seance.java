package ua.lvlv.lgs;

import java.util.Objects;

public class Seance implements Comparable<Seance> {
	Movie movie;
	Time startTime;
	Time endTime;

	public Seance(Movie movie, Time startTime) {
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = calculateEndTime();
	}

	public Time calculateEndTime() {
		return new Time(startTime.min + movie.duration.min, startTime.hour + movie.duration.hour);
	}

	@Override
	public int hashCode() {
		return Objects.hash(endTime, movie, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		return Objects.equals(endTime, other.endTime) && Objects.equals(movie, other.movie)
				&& Objects.equals(startTime, other.startTime);
	}

	public Movie getMovie() {
		return movie;
	}
	@Override
	public int compareTo(Seance o) {
		if (this.startTime.hour == o.startTime.hour) {
			return 0;
		} else if (this.startTime.hour < o.startTime.hour) {
			return -1;
		} else
			return 1;

	}

	@Override
	public String toString() {
		return "Seance [" + movie + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
