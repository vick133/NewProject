package com.example.UserRegistrationBoot;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserRegistrationService implements UserRegistrationIntr {
	
	@Autowired
	UserRegistrationRepository userrepo;
	
	public ArrayList<UserRegistration> findAll()
	{
		return  (ArrayList<UserRegistration>) userrepo.findAll();
	}
	
	public UserRegistration print(String username,String password) {
		return userrepo.findByCred(username,password);
	}
	
	public void setOnline(UserRegistration user) {
		userrepo.save(user);
	}
	
	public ArrayList<UserRegistration> findagent()
	{
		return  userrepo.findSupportAgent();
	}
	
	public ArrayList<UserRegistration> findgamer()
	{
		return  userrepo.findGamer();
	}
	
//	public UserRegistration SetLogout(String username)
//	{
//		return userrepo.findByName(username);
//	}
	
	public void setOffline(UserRegistration user)
	{
		userrepo.save(user);
	}
}
