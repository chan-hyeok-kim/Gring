package com.cha.ing.image;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cha.ing.util.FileManage;

@Service
public class ImageService {

	@Autowired
	private ImageDAO imageDAO;
	
	@Autowired
	private FileManage fileManage;
	
	@Value("${app.upload}")
	private String path;
	
	public int insertImage(MultipartFile multipartFile)throws Exception{
		
	
		ImageVO imageVO=new ImageVO();
		imageVO.setImagePath(path);
		imageVO.setId("admin");
		String fileName=fileManage.fileSave(path, multipartFile);
		imageVO.setImageName(fileName);
		imageVO.setImageOriginalName(multipartFile.getOriginalFilename());
		
		int result=imageDAO.insertImage(imageVO);
	
		return result;
	}
	
	
}
