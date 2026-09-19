package sample.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	// @RequestParam can read Query Parameter
	
	@RequestMapping("/")
	public String greet(@RequestParam(name="user", defaultValue = "GuestUser") String user, Model model) {
		System.out.println("UserController.greet()");
		
		model.addAttribute("user", user);
		
		return "welcome";

	}


}