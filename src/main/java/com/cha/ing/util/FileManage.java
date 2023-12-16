package com.cha.ing.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManage {

	public String fileSave(String path, MultipartFile multipartFile)throws Exception{
		
		File file=new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String fileName=UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		file=new File(file,fileName);
		multipartFile.transferTo(file);
		//파일 객체생성
		//uuid바른거로 다시 생성
		//전송
		
		
		return fileName;
		
	}
}
