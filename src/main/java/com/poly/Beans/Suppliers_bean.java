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


public class Suppliers_bean {
	
	private int id;
	@NotBlank(message = "Vui lòng nhập thông tin họ và tên")
	private String user_names;
	@NotBlank(message = "Vui lòng nhập thông tin email")
	@Email
	private String emails;
	@NotBlank(message = "Vui lòng chọn thông tin ảnh")
	private String images;
	@NotBlank(message = "Vui lòng nhập thông tin số điện thoại")
	private String phones;
	@NotBlank(message = "Vui lòng nhập thông tin địa chỉ")
	private String address;
	private int status;
	private Date create_date;
	private Date update_date;
	private int is_active;

	

}
