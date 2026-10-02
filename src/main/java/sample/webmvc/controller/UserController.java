package sample.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.webmvc.entity.User;
import sample.webmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	 UserService userService;
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@GetMapping("/")
	public String greet() {
		System.out.println("UserController.greet : ");
		
		return "welcome";

	}
	

	
	@GetMapping("/{id}")
	@ResponseBody
	public User pathVariablle(@PathVariable(name = "id") int id) {
		System.out.println("UserController.pathVariablle : "+id);
		return userService.getUserById(id);
	}
	
//   @PostMapping("/save-user")
	@PostMapping
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		System.out.println("UserController.saveUser : ");
		System.out.println(user);
		
		return userService.saveUser(user);

	}
	

}