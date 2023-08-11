package com.poly.Beans;

import java.util.Date;

import javax.validation.constraints.Email;
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


public class Users_bean {

	private int id;
	@NotBlank(message = "Vui lòng nhập thông tin tiêu đề")
	private String user_names;
	@NotBlank(message = "Vui lòng nhập thông tin họ")
	private String first_names;
	@NotBlank(message = "Vui lòng nhập thông tin tên")
	private String last_names;
	@NotBlank(message = "Vui lòng nhập thông tin email")
	@Email(message = "Vui lòng nhập đúng thông tin email")
	private String email;
	@NotBlank(message = "Vui lòng nhập thông tin mật khẩu")
	private String pass_words;	
	@NotBlank(message = "Vui lòng nhập lại thông tin mật khẩu")
	private String pass_words2;
	private String images;	
	private String phones;	
	private String address;	
	private Date create_date;
	private Date update_date;
	private int is_active;

		
	
	
}	
