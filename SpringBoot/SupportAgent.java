package com.example.UserRegistrationBoot;


import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class SupportAgent {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int agent_id;

	@Column	
	private String status;

	@Column(name="login_time")
	private Time logintime;
	
	@Column
	private Time logout_time;

	public SupportAgent() {}
	
	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Time getLogintime() {
		return logintime;
	}

	public void setLogintime(Time logintime) {
		this.logintime = logintime;
	}

	public Time getLogout_time() {
		return logout_time;
	}

	public void setLogout_time(Time logout_time) {
		this.logout_time = logout_time;
	}

	@Override
	public String toString() {
		return "SupportAgent [agent_id=" + agent_id + ", status=" + status + ", logintime=" + logintime
				+ ", logout_time=" + logout_time + "]";
	}

	
	
}

