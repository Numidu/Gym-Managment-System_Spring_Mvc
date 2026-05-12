
package org.example.gym_managment_system.controllers;
import org.example.gym_managment_system.dao.MemberDAO;
import org.example.gym_managment_system.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    MemberDAO memberDAO = new MemberDAO();

    @GetMapping("/m_view")
    public String loadPage(Model model){

        model.addAttribute(
                "memberList",
                memberDAO.getAllMembers()
        );
        model.addAttribute(
                "em",
                new Member()
        );
        model.addAttribute("page", "member.jsp");
        return "dashboard";
    }

    @PostMapping("/saveMember")
    public String saveMember(Member member){

        memberDAO.saveMember(member);

        return "redirect:/m_view";
    }

    @PostMapping("/deleteMember")
     public String deleteMember( @RequestParam("memberId") int id){
        System.out.println("Delete Member id" + id);
        memberDAO.deleteMember(id);

        return "redirect:/m_view";
    }


    @GetMapping("/editMember")
    public String editMember(

            @RequestParam("id")
            int id,

            Model model){

        Member member =
                memberDAO.findById(id);

        model.addAttribute(
                "em",
                member);

        model.addAttribute(
                "memberList",
                memberDAO.getAllMembers());

        model.addAttribute("page", "member.jsp");

        return "dashboard";
    }



    @PostMapping("/updateMember")
    public String updateMember(Member member){

        memberDAO.update(member);

        return "redirect:/m_view";
    }

}