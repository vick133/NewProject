package com.example.UserRegistrationBoot;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Queue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {
	@Query("Select u from UserRegistration u WHERE u.user_name=:username AND u.password=:password")
    UserRegistration findByCred(String username,String password);
	
	@Query("from UserRegistration where user_role='Gamer' AND status='online' ORDER BY login_time ASC")
	public ArrayList<UserRegistration> findGamer();
	
	@Query("from UserRegistration where user_role='Support agent' AND status='online' ORDER BY login_time ASC")
	public ArrayList<UserRegistration> findSupportAgent();
	
//	@Query("select u from UserRegistration u where u.user_name:=username")
//	public UserRegistration findByName(String username);
}
