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

public class News_bean   {
	
	private int id;
	@NotBlank(message = "Vui lòng nhập thông tin tiêu đề")
	private String titles;
	@NotBlank(message = "Vui lòng nhập thông tin nội dung")
	private String contents;
	@NotBlank(message = "Vui lòng nhập thông tin video")
	private String video_href;
	@NotBlank(message = "Vui lòng nhập chọn thông tin ảnh ")
	private String images;
	private Date create_date;
	private Date update_date;
	private int is_active;

}
