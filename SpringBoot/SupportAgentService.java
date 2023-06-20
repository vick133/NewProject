package com.example.UserRegistrationBoot;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SupportAgentService implements SupportAgentIntr{

	@Autowired
	SupportAgentRepository sarepo;
	
	@Override
	public ArrayList<SupportAgent> findAllOrderByLogintime()
	{
		
		return  sarepo.findAllOrderByLogintime();
	}
	
	
	
	

	
}
