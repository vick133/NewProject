package com.example.UserRegistrationBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface SupportAgentIntr{
	
	public List<SupportAgent> findAllOrderByLogintime();
	
	
}
