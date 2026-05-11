package org.example.gym_managment_system.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.gym_managment_system.dao.AdminDAO;
import org.example.gym_managment_system.dao.DashbordDAO;
import org.example.gym_managment_system.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    AdminDAO adminDAO = new AdminDAO();

    @GetMapping("/login")
    public String loadLoginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String login(

            @RequestParam("email") String email,

            @RequestParam("password") String password,

            HttpSession session,

            Model model
    ){

        Admin admin = adminDAO.login(email, password);

        if(admin != null){
            session.setAttribute("loggedUser", admin);



            return "redirect:/dashboard";
        }

        model.addAttribute(
                "error",
                "Invalid Email or Password"
        );

        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){

        if(session.getAttribute("loggedUser") == null){

            return "redirect:/login";
        }
        DashbordDAO dashbordDAO = new DashbordDAO();
        dashbordDAO.getData(model);

        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){

        session.invalidate();

        return "redirect:/login";
    }
}
