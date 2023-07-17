package com.poly.Beans;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
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


public class Discounts_bean {
	
	private int id;
	@NotBlank(message = "Vui lòng nhập thông tin tiêu đề")
	private String titles;
	@NotBlank(message = "Vui lòng nhập thông tin mô tả")
	private String descriptions;	
	private int price_discounts;
	
	private Date start_day;
	private Date end_day;
	
}
