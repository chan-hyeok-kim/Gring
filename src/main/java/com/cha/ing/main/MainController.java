package com.cha.ing.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Controller
@Slf4j
public class MainController {

	@RequestMapping("/")
	private String goHome() throws Exception{
		
		
		
		return "index";
	}
}
