package ua.lvlv.lgs;

import java.util.Objects;

public class Time {
	public int min;
	public int hour;

	public Time(int min, int hour) {
		this.hour = hour;
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hour, min);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hour == other.hour && min == other.min;
	}

	@Override
	public String toString() {
		return "[minutes= " + min + ", hours= " + hour + "]";
	}

}
