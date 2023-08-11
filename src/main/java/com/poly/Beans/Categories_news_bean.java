package com.poly.Beans;

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

public class Categories_news_bean {
	
	private int id;
	@NotBlank(message = "Vui lòng nhập thông tin tiêu đề")
	private String titles;

}
