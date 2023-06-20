package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.entity.User;
import com.login.service.RegistrationService;

@RestController
@CrossOrigin("http://localhost:4200")

//@RequestMapping("/app/v1")

public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String tempEmailId=user.getEmailid();
		if(tempEmailId!=null && !"".equals(tempEmailId))
		{
			User u=registrationService.fetchUserByEmailId(tempEmailId);
			
			if(u!=null)
			{
				throw new Exception("User with "+tempEmailId+" is already present" );
			}
		}
		
		User u=null;
		u=registrationService.registerUser(user);
		return u;
	}
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String tempEmailid=user.getEmailid();
		String tempPassword=user.getPassword();
		User u=null;
		if(tempEmailid!=null && tempPassword!=null)
		{
			u=registrationService.fetchUserByEmailIdAndPassword(tempEmailid, tempPassword);
		}
		if(u==null)
		{
			throw new Exception("Bad Credentials");
		}
		return u;
	}
}
