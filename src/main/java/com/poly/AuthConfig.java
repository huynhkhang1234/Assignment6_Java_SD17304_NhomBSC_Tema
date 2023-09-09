package com.poly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poly.RestService.UserService;
@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Autowired
	UserService userService;
	
	/*--Mã hóa mật khẩu--*/
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*--Quản lý người dữ liệu người sử dụng--*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	/*--Phân quyền sử dụng và hình thức đăng nhập--*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF, CORS
		http.csrf().disable().cors().disable();
		
		// Phân quyền sử dụng
		http.authorizeRequests()
			.antMatchers("/user/cart","/user/cart/**").hasAnyRole("1", "2")
			.antMatchers("/admin/**").hasAnyRole("1")
			.antMatchers("/user/bill").hasAnyRole("1", "2")
			.anyRequest().permitAll(); ////tất cả các quyền còn lại.
		
		// Điều khiển lỗi truy cập không đúng vai trò
		http.exceptionHandling()
			.accessDeniedPage("/auth/access/denied"); // [/error]
		
		// Giao diện đăng nhập
		http.formLogin()
			.loginPage("/user/login")
			.loginProcessingUrl("/auth/login") // [/login]
			.defaultSuccessUrl("/auth/login/success", false)
			.failureUrl("/auth/login/error")
			.usernameParameter("email") // [username]// trùng với tên name trong input.
			.passwordParameter("pass_words"); // [password]		
		http.rememberMe()
			.rememberMeParameter("remember"); // [remember-me]
		
		
		// Đăng xuất
		http.logout()
			.logoutUrl("/auth/logoff") // [/logout]
			.logoutSuccessUrl("/auth/logoff/success")
			.invalidateHttpSession(true) // Hủy bỏ HttpSession sau khi đăng xuất
			.deleteCookies("JSESSIONID"); // Xóa cookie JSESSIONID sau khi đăng xuất
	}
	/*--Cho phép request đến REST API từ browser--*/
	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**"); }
	 */
}
