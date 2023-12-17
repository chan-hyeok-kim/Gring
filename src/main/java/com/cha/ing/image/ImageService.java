package com.cha.ing.image;

import java.io.File;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cha.ing.commons.FileManage;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImageService {

	@Autowired
	private ImageDAO imageDAO;
	
	@Autowired
	private FileManage fileManage;
	
	@Value("${app.upload}")
	private String path;
	
	public int insertImage(MultipartFile multipartFile)throws Exception{
		
		String fileName="";
		ImageVO imageVO=new ImageVO();
		imageVO.setImagePath(path);
		imageVO.setId("ADMIN");
		
		ResponseEntity<String> response=fileManage.upload(multipartFile);
		if(response.getStatusCode()==HttpStatus.OK) {
			fileName=response.getBody();
		}else {
			return 0;
		}
		
		
		
		imageVO.setImageName(fileName);
		imageVO.setImageOriginalName(multipartFile.getOriginalFilename());
		
		log.warn("파일오는지체크{}",imageVO);
		int result=imageDAO.insertImage(imageVO);
	
		return result;
	}
	
	
}
