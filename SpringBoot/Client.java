package com.example.UserRegistrationBoot;

import java.sql.Time;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="gamer")
public class Client {
 
    @Id

    @GeneratedValue(strategy=GenerationType.TABLE)


    @Column(name = "gamer_id")
    private int id;

    @Column(name = "status")
    private String status;

    public Client() {}
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Client [id=" + id + ", status=" + status + "]";
	}





}

