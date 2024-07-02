package com.service;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	public void uploadProductImage(MultipartFile masterImage) {

		System.out.println(masterImage.getOriginalFilename());

		String path = "D:\\ROYAL TECHNOSOFT AI\\Spring\\workspace\\24-spring-web-mix-6\\src\\main\\webapp\\images\\products";
		// dao insert
		try {
			byte b[] = masterImage.getBytes();// copy | extract

			File file = new File(path, masterImage.getOriginalFilename());// path , name
			FileUtils.writeByteArrayToFile(file, b);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
