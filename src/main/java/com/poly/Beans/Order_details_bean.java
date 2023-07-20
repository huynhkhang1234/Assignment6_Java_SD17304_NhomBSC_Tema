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

public class Order_details_bean  {
	
	private int id;
	private int price;
	private int quanlity;
	private float sum_money;
	private Date create_date;
	private Date update_date;
	
}
