package com.poly.Beans;



import jakarta.validation.constraints.Email;
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

public class LoginBean {
	@NotBlank(message = "Vui lòng nhập thông tin email")
	@Email(message = "Vui lòng nhập đúng thông tin email")
	private String email;
	@NotBlank(message = "Vui lòng nhập thông tin mật khẩu")
	private String pass_words;
	
	private boolean rememberme;
}
