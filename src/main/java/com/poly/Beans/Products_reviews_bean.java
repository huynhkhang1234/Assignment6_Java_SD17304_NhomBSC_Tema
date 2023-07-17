package com.poly.Beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Products_reviews_bean   {

	private int id;
	private int stars_number;
	private String content;
	private Date create_date;
}
