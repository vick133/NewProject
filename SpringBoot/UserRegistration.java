package com.example.UserRegistrationBoot;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRegistration {
@Id	
@GeneratedValue(strategy=GenerationType.TABLE)
private int user_id;
@Column
private String user_role;
@Column
private String first_name;
@Column
private String last_name;
@Column
private Long contact_no;
@Column
private String status;
@Column
private String password;
@Column
private String user_name;
@Column
private LocalDateTime login_time;

public UserRegistration(int user_id, String user_role, String first_name, String last_name, Long contact_no,
		String status, String password, String user_name, LocalDateTime login_time) {
	super();
	this.user_id = user_id;
	this.user_role = user_role;
	this.first_name = first_name;
	this.last_name = last_name;
	this.contact_no = contact_no;
	this.status = status;
	this.password = password;
	this.user_name = user_name;
	this.login_time = login_time;
}
public LocalDateTime getLogin_time() {
	return login_time;
}
public void setLogin_time(LocalDateTime login_time) {
	this.login_time = login_time;
}
public UserRegistration() {
	
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_role() {
	return user_role;
}
public void setUser_role(String user_role) {
	this.user_role = user_role;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public Long getContact_no() {
	return contact_no;
}
public void setContact_no(Long contact_no) {
	this.contact_no = contact_no;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
@Override
public String toString() {
	return "UserRegistration [user_id=" + user_id + ", user_role=" + user_role + ", first_name=" + first_name
			+ ", last_name=" + last_name + ", contact_no=" + contact_no + ", status=" + status + ", password="
			+ password + ", user_name=" + user_name + ", login_time=" + login_time + "]";
}

}
