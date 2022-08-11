package com.haeun;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value="/test")
	public String test(Model model) {
		
		model.addAttribute("data", "타임리프");
		
		return "test";
	}
	
}
