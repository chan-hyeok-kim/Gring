package com.cha.ing.image;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/image/*")
@Slf4j
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@Value("${pixabay.api.key}")
	private String apiKey;
	
	@GetMapping("search")
	public Flux<Object> String()throws Exception{
        WebClient webClient=WebClient.create("https://pixabay.com/api/?key="+apiKey+"&q=yellow+flowers&image_type=photo&p=24");
		
		Flux<Object> response=webClient.get()
		                         .uri("")
		                         .retrieve()
		                         .bodyToFlux(Object.class);
		         
		log.warn("픽사이미지오나{}",response);
		
		ObjectMapper objectMapper=new ObjectMapper();
		String json=objectMapper.writeValueAsString(response);
		LinkedHashMap<String, Object> obj=objectMapper.readValue(json, LinkedHashMap.class);
		
		log.warn("픽사이미지파싱{}",obj);
		
		
		return response;
	}
	
	@GetMapping("upload")
	public void imageSave()throws Exception{
		
	}
	
	@PostMapping("upload")
    public void insertImage(MultipartFile multipartFile)throws Exception{
		imageService.insertImage(multipartFile);
	}
	
	
}
