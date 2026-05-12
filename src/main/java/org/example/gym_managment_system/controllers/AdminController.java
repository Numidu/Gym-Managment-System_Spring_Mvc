package org.example.gym_managment_system.controllers;
import jakarta.servlet.http.HttpSession;
import org.example.gym_managment_system.dao.AdminDAO;
import org.example.gym_managment_system.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class AdminController {

    AdminDAO adminDAO = new AdminDAO();

    @GetMapping("/a_view")
    public String loadPage(Model model){

        model.addAttribute(
                "adminList",
                adminDAO.getAllAdmins()
        );

        model.addAttribute("ea", new Admin()
        );
        model.addAttribute("page", "admin.jsp");

        return "dashboard";
    }

    @PostMapping("/saveAdmin")
    public String saveAdmin(

            Admin admin,

            @RequestParam("imageFile")
            MultipartFile imageFile



    ){

        try{

            String fileName =
                    imageFile.getOriginalFilename();

            String uploadDir =
                    "D:/uploads/";

            File saveFile =
                    new File(uploadDir + fileName);

            imageFile.transferTo(saveFile);

            admin.setImage(fileName);

        }catch (Exception e){

            e.printStackTrace();
        }

        adminDAO.saveAdmin(admin);

        return "redirect:/a_view";
    }

    @PostMapping("/deleteAdmin")
    public String deleteAdmin(@RequestParam("adminId") int id){

        adminDAO.deleteAdmin(id);

        return "redirect:/a_view";
    }

    @GetMapping("/editAdmin")
    public String editAdmin(
            @RequestParam("id") int id, Model model , HttpSession session
            ){
        Admin adminData = (Admin) session.getAttribute("loggedUser");
        System.out.println(adminData.getId());
        if(adminData.getId() == id){

            Admin admin = adminDAO.findById(id);

            model.addAttribute("ea", admin
            );

            model.addAttribute("adminList", adminDAO.getAllAdmins()
            );
            System.out.println("edit"+id);
            System.out.println("edit"+admin);

            model.addAttribute("page", "admin.jsp");
            return "dashboard";

        }else{
            return "redirect:/a_view";
        }

    }

    @PostMapping("/updateAdmin")
    public String updateAdmin(

            Admin admin,

            @RequestParam("imageFile") MultipartFile imageFile,

            @RequestParam("oldImage") String oldImage



    ){

        try{

            if(!imageFile.isEmpty()){

                String fileName =
                        imageFile.getOriginalFilename();

                String uploadDir =
                        "D:/uploads/";

                File saveFile =
                        new File(uploadDir + fileName);

                imageFile.transferTo(saveFile);

                admin.setImage(fileName);
            }else{
                admin.setImage(oldImage);
            }

        }catch (Exception e){

            e.printStackTrace();
        }

        adminDAO.update(admin);

        return "redirect:/a_view";
    }
}
