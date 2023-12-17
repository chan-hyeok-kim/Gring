package com.cha.ing.image;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/image/*")
@Slf4j
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@GetMapping("upload")
	public void insertImage()throws Exception{
		
	}
	
	@PostMapping("upload")
    public String insertImage(MultipartFile photo)throws Exception{
		imageService.insertImage(photo);
		
		return "redirect:/";
	}
	
	
}
