package com.cha.ing.main;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Controller
@Slf4j
public class MainController {

	@Value("${pixabay.api.key}")
	private String apiKey;
	
	@RequestMapping("/")
	private String goHome(Model model) throws Exception{
		
		 WebClient webClient=WebClient.create("https://pixabay.com/api/?key="+apiKey+"&q=yellow+flowers&image_type=photo");
			
			Flux<Object> response=webClient.get()
			                         .uri("")
			                         .retrieve()
			                         .bodyToFlux(Object.class);
			         
			log.warn("픽사이미지오나{}",response);
			
			ObjectMapper objectMapper=new ObjectMapper();
			String json=objectMapper.writeValueAsString(response);
			LinkedHashMap<String, Object> obj=objectMapper.readValue(json, LinkedHashMap.class);
			
			log.warn("픽사이미지파싱{}",obj);
			
			model.addAttribute("images",response);
			
		
		return "index";
	}
}
