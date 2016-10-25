/*
 * author @noahdominic
 */

import java.util.*;
import java.lang.*;

public class Date {
	private int year;
	private int month;
	private int day;

	Date(){
		this.year = 1000;
		this.month = 1;
		this.day = 1;
	}

	Date(int year, int month, int day){
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	public int getYear(){
		return year;
	}

	public int getMonth(){
		return month;
	}

	public int getDay(){
		return day;
	}

	public void setYear(int year){
		if(year < 1000 || year > 9999){
			throw new IllegalArgumentException("Invalid Year");
		}
		this.year = year;
	}

	public void setMonth(int month){
		if(month < 1 || month > 12){
			throw new IllegalArgumentException("Invalid Month");
		}
		this.month = month;
	}

	public void setDay(int day){
		if(day < 1){
			throw new IllegalArgumentException("Day < 1");
		} else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31){
			throw new IllegalArgumentException("This month only has 31 days.");
		} else if ((month == 4 || month == 6 || month ==9 || month == 11) && (day > 30)){
			throw new IllegalArgumentException("This month only has 30 days.");
		} else if (isLeapYr() && day > 29){
			throw new IllegalArgumentException("This month only has 29 days.");
		} else if (!isLeapYr() && day > 28){
			throw new IllegalArgumentException("This month only has 28 days.");
		}
		this.day = day;
	}
  
  	public boolean isLeapYr(){
		if(year%4 == 0 && year%100 > 0){
			return true;
		} else {
			return false;
		}
	}

	public String toString(){
		return String.format("%02d/%02d/%02d", day, month, year);
	}

	public void setDate(int year, int month, int day){
		setYear(year);
		setMonth(month);
		setDay(day);
	}
}
