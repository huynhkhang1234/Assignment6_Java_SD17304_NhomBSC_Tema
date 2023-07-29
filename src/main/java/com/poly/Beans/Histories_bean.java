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


public class Histories_bean  {
	
	private int id;	
	private Date create_date;
	private Date update_date;
	private int is_active;
	
}
