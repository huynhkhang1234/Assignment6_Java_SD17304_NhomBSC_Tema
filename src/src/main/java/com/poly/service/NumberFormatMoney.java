package com.poly.service;

import java.text.NumberFormat;
import java.util.Locale;
public class NumberFormatMoney {
	public static String formatMoney( float price) {	
		Locale locale = new Locale("vi", "VN");		
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return currencyFormatter.format(price);	
	}
	
}
