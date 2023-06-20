package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.login.entity.User;
import com.login.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepo;
	
	public User registerUser(User user)
	{
		return registrationRepo.save(user);
	}
	
	public User fetchUserByEmailId(String emailid)
	{
		return registrationRepo.findByEmailid(emailid);
	}
	
	public User fetchUserByEmailIdAndPassword(String emailid,String password)
	{
		return registrationRepo.findByEmailidAndPassword(emailid,password);
	}
}
