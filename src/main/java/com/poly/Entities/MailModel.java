package com.poly.Entities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailModel {
	String from = "FPT Polytechnic <poly@fpt.edu.vn>";
	String to;
	
	String body;
	List<String> cc = new ArrayList<>();
	List<String> bcc = new ArrayList<>();
	List<File> files = new ArrayList<>();

	public MailModel(String to, String body) {
		super();
		this.to = to;
		
		this.body = body;
	}

}
