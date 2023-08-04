package com.poly.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.expression.ParseException;

public class XDate {

	 static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

	    public static Date toDate(String date, String... pattern) throws java.text.ParseException {
	        try {
	            if (pattern.length > 0) {

	                DATE_FORMATER.applyPattern(pattern[0]);

	            }
	            if (date == null) {
	                return XDate.now();
	            }
	            System.out.println(date);
	            return DATE_FORMATER.parse(date);
	        } catch (ParseException ex) {
	            throw new RuntimeException(ex);
	        }
	    }

	    public static String toString(Date date, String... pattern) {
	        if (pattern.length > 0) {
	            DATE_FORMATER.applyPattern(pattern[0]);
	        }
	        if (date == null) {
	            date = XDate.now();
	        }
	        return DATE_FORMATER.format(date);
	    }

	    public static Date now() {
	        return new Date();
	    }

	    public static Date addDays(Date date, int days) {
	        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
	        return date;
	    }

	    public static Date add(int days) {
	        Date now = XDate.now();
	        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
	        return now;
	    }
	    
	    public static Date getDateAfter(int days) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.set(Calendar.HOUR_OF_DAY, 0);
	        calendar.set(Calendar.MINUTE, 0);
	        calendar.set(Calendar.SECOND, 0);
	        calendar.set(Calendar.MILLISECOND, 0);
	        calendar.add(Calendar.DATE, +days);
	        return calendar.getTime();
	      }
	
}
