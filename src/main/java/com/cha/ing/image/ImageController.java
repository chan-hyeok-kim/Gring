package com.cha.ing.image;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.codec.http.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
	
	@GetMapping("create")
	public void createImage()throws Exception{
		
		
	}
	
	@PostMapping("create")
	@ResponseBody
	public Mono<Object> creatImage(String prompt)throws Exception{
		
		Map<String, Object> param=new HashMap<>();
		param.put("prompt", prompt);
		param.put("nsfw_checker", "true");
		param.put("return_type", "base64_string");
		
		WebClient webClient=WebClient.builder()
				                     .baseUrl("https://api.kakaobrain.com/v2/inference/karlo/t2i")
				                     .build();
		 
	    Mono<Object> imageInfo=webClient.post()
		                    .uri("")
		                    .header(prompt, "")
		                    .contentType(MediaType.APPLICATION_JSON)
		                    .body(BodyInserters.fromValue(param))
		                    .retrieve()
		                    .bodyToMono(Object.class);
		                   
	    
        return imageInfo;		 
	}
	
	
	
}
