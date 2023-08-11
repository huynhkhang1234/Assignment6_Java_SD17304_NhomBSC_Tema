package com.poly.Beans;

import java.util.Date;

import javax.validation.constraints.NotBlank;
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

public class Products_bean {
	
	private int id;
	@NotBlank(message = "Vui lòng nhập thông tin tiêu đề")
	private String titles;
	private int price;
	@NotBlank(message = "Vui lòng chọn thông tin ảnh")
	private String images;	
	private String description;	
	private Date create_date;	
	private Date update_date;
	private int is_active;
	private int original_price;

}
