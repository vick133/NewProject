package com.example.UserRegistrationBoot;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SessionController {
int i=0;
    @GetMapping("/createsession")
    public String createSession(HttpServletRequest request) {
        // Create a new session
        HttpSession session = request.getSession();
        session.setAttribute("session_id", 1+""+2);
        return "Session created";
    }

    @GetMapping("/getsession")
    public String getSession(HttpServletRequest request) {
        // Retrieve the existing session
        HttpSession session = request.getSession();
        String username1 = (String) session.getAttribute("session_id");
       

        
        return "Username from session: " + username1;
    }
}




