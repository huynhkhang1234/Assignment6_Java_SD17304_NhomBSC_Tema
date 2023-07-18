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

public class Orders_bean {
	
	private int id;	
	private String notes;
	private String status;
	private Float sum_money;
	private Date create_date;
	private Date update_date;
	private int money_received;

}
