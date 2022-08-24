package ua.lvlv.lgs;

public class Movie {
	String title;
	public Time duration;

	public Movie(String title, Time duration) {
		this.title = title;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}
	
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", duration=" + duration + "]";
	}

}
