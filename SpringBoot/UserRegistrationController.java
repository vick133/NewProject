package com.example.UserRegistrationBoot;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserRegistrationBoot.SupportAgentController.Helper;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins="http://localhost:6969/")
public class UserRegistrationController {
	
@Autowired
UserRegistrationService userserv;
@Autowired
UserRegistrationRepository userrepo;
TreeMap<Integer,Integer> engagaed = new TreeMap<Integer,Integer>();
int check=-1;

	class Helper extends TimerTask{
       
		@Override
		public void run() {
			
			ArrayList<UserRegistration> agent =userserv.findagent();
			ArrayList<UserRegistration> gamer =userserv.findgamer();
			Queue<UserRegistration> agentqueue = new LinkedList();
			Queue<UserRegistration> gamerqueue = new LinkedList();
			for(UserRegistration i :agent) {
				agentqueue.add(i);
			}
			for(UserRegistration i :gamer) {
				gamerqueue.add(i);
			}
			for(UserRegistration s : agentqueue) {
				if(gamerqueue.size()==0) {
					break;
				}
				s.setStatus("enagaed");
				userrepo.save(s);
				System.out.println(s);
				for(UserRegistration c : gamerqueue) {
					c.setStatus("engagaed");
					userrepo.save(c);
					System.out.println(c);
					engagaed.put(s.getUser_id(), c.getUser_id());
					gamerqueue.poll();
					break;
				}
	            agentqueue.poll();
	            break;
	        }
		}
	}
	
	@GetMapping("/user")
	public void getuser()
	{   
		Timer timer = new Timer();
		TimerTask task = new Helper();
		timer.schedule(task, 1000, 5000);
	}

	@GetMapping("/id/{name}/{password}/{userstatus}")
	public int getuserbyid(@PathVariable String name, @PathVariable String password,@PathVariable String userstatus)
	{   
		if(userstatus.equals("login"))
		{
		UserRegistration user =userserv.print(name, password);
		user.setStatus("online");
		user.setLogin_time(LocalDateTime.now());
		userserv.setOnline(user);
		if(user.getUser_role().equalsIgnoreCase("gamer")) {
		 check=0;
		}
		else if(user.getUser_role().equalsIgnoreCase("support agent")) {
		 check=1;
		}
		else {
		 check=2;
		}
		}
		else if(userstatus.equals("logout"))
		{
			UserRegistration user =userserv.print(name, password);
			user.setStatus("offline");
			userserv.setOffline(user);
			check=3;
		}
		return check;
	}

	@GetMapping("/engagedList")
	public TreeMap<Integer,Integer> print(){
	return engagaed;
	}
	
//	@GetMapping("/id/{name}/{password}")
//	public void setLogout(@PathVariable String name, @PathVariable String password)
//	{   
//		
//	}
//
//	@PostMapping("/logout/{username}")
//	public void setLogout(@PathVariable String username)
//	{
//		UserRegistration user=userserv.SetLogout(username);
//		user.setStatus("offline");
//		userserv.setOffline(user);
//	}

}
