package com.example.UserRegistrationBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportAgentRepository extends JpaRepository<SupportAgent, Integer>{

	@Query("FROM SupportAgent ORDER BY logintime ASC")
	public ArrayList<SupportAgent> findAllOrderByLogintime();

	
}
