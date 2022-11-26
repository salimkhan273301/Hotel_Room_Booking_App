package com.revature.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Cab {
	private Integer cabNo;
	private LocalDate booking_date;
	private LocalTime booking_time;
	private Integer freeOrBooked;
	
	

	public Cab(Integer cabNo, LocalDate booking_date, LocalTime booking_time, Integer freeOrBooked) {
		super();
		this.cabNo = cabNo;
		this.booking_date = booking_date;
		this.booking_time = booking_time;
		this.freeOrBooked = freeOrBooked;
	}

	public Cab(Integer cnum) {
		this.cabNo = cnum;
		this.freeOrBooked = 0;
	}

	public Cab(Integer cnum, Integer fOB) {
		this.cabNo = cnum;
		this.freeOrBooked = fOB;
	}

	public Integer getCabNo() {
		return cabNo;
	}

	// public void setCabNo(Integer cabNo) {
	// this.cabNo = cabNo;
	// }
	

	

	public Integer getFreeOrBooked() {
		return freeOrBooked;
	}

	public void setFreeOrBooked(Integer freeOrBooked) {
		this.freeOrBooked = freeOrBooked;
	}
	
	

	public LocalDate getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}

	public LocalTime getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(LocalTime booking_time) {
		this.booking_time = booking_time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cabNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cab other = (Cab) obj;
		return Objects.equals(cabNo, other.cabNo);
	}

	@Override
	public String toString() {
		return "Cab [cabNo=" + cabNo + ", booking_date=" + booking_date + ", booking_time=" + booking_time
				+ ", freeOrBooked=" + freeOrBooked + "]";
	}

	
	

}

