package com.poly.Beans;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.poly.Entities.Roles;

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

public class AccountAdmin {
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
	private String images;
	@NotBlank(message = "Vui lòng nhập thông tin số điện thoại")
	private String phones;
	@NotBlank(message = "Vui lòng nhập thông tin địa chỉ")
	private String address;	
	private Date create_date;
	private Date update_date;	
	private Roles roles;  
}
