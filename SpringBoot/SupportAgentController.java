package com.example.UserRegistrationBoot;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
public class SupportAgentController {

	@Autowired
	SupportAgentService saserv;
    @Autowired
    SupportAgentRepository agentrepo;
    @Autowired
    ClientRepository gamerrepo;
    TreeMap<Integer,Integer> engagaed = new TreeMap<Integer,Integer>();
	
	class Helper extends TimerTask{
        
		@Override
		public void run() {
			
			Queue<SupportAgent> agentqueue = new LinkedList();
			ArrayList<SupportAgent> agentlist = saserv.findAllOrderByLogintime();
			Queue<Client> gamerqueue = new LinkedList();
			ArrayList<Client> gamerlist = (ArrayList<Client>) gamerrepo.findAll();
			for(SupportAgent s:agentlist) {
				if(s.getStatus().equalsIgnoreCase("online")) {
					agentqueue.add(s);
				}
			}
			for(Client s:gamerlist) {
				if(s.getStatus().equalsIgnoreCase("online")) {
					gamerqueue.add(s);
				}
			}
			for(SupportAgent s : agentqueue) {
				s.setStatus("enagaed");
				agentrepo.save(s);
				System.out.println(s);
				for(Client c : gamerqueue) {
					c.setStatus("engagaed");
					gamerrepo.save(c);
					System.out.println(c);
					engagaed.put(s.getAgent_id(), c.getId());
					gamerqueue.poll();
					break;
				}
	            agentqueue.poll();
	            break;
	        }
		}
		
	}
	
	@GetMapping("/list")
	public List<SupportAgent> getSupportAgents()
	{   
		return saserv.findAllOrderByLogintime();
	}
	
	@GetMapping("/getstring")
	public void getStrings()
	{
		Timer timer = new Timer();
        TimerTask task = new Helper();
        timer.schedule(task, 1000, 2000);
	}
	
	@GetMapping("/engagedList")
	public TreeMap<Integer,Integer> print(){
		return engagaed;
	}
	
	
	
}
