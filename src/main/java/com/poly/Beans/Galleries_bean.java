package com.poly.Beans;

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


public class Galleries_bean  {
		
	private int id;
	@NotBlank(message = "Vui lòng chọn ảnh")
	private String images;	
	
	Products_bean products;
	
}
