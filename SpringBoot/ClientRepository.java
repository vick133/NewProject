package com.example.UserRegistrationBoot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{
 
}

