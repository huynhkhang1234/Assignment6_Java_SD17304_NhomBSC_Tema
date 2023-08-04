package com.poly.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class XImage {
	
	// Lấy đường dẫn tới thư mục static
	private static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static";
	
	public static boolean addImageToPackage(MultipartFile file, String nameFolder) {
		
		File uploadRootDir = new File(UPLOAD_DIRECTORY + nameFolder);
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		
		try {
			String fileName = file.getOriginalFilename();
			File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(file.getBytes());
			stream.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
