package org.example.gym_managment_system.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.example.gym_managment_system.dao.MemberDAO;
import org.example.gym_managment_system.dao.PaymentDAO;
import org.example.gym_managment_system.model.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    PaymentDAO paymentDAO = new PaymentDAO();

    MemberDAO memberDAO = new MemberDAO();

    @GetMapping("/p_view")
    public String loadPage(Model model){

        model.addAttribute(
                "paymentList",
                paymentDAO.getAllPayment()
        );

        model.addAttribute(
                "memberList",
                memberDAO.getAllMembers()
        );

        model.addAttribute(
                "ep",
                new Payment()
        );
        model.addAttribute("page", "payment.jsp");
        return "dashboard";
    }

    @PostMapping("/savePayment")
    public String savePayment(Payment payment){

        paymentDAO.insertPayment(payment);

        return "redirect:/p_view";
    }

    @PostMapping("/deletePayment")
    public String deletePayment(
            @RequestParam("paymentId") int id
    ){

        paymentDAO.deletePayment(id);

        return "redirect:/p_view";
    }

    @GetMapping("/editPayment")
    public String editPayment(
            @RequestParam("id") int id,
            Model model
    ){

        Payment payment =
                paymentDAO.findById(id);

        model.addAttribute(
                "ep",
                payment
        );

        model.addAttribute(
                "paymentList",
                paymentDAO.getAllPayment()
        );

        model.addAttribute(
                "memberList",
                memberDAO.getAllMembers()
        );

        model.addAttribute("page", "payment.jsp");
        return "dashboard";
    }

    @PostMapping("/updatePayment")
    public String updatePayment(Payment payment){

        paymentDAO.updatePayment(payment);

        return "redirect:/p_view";
    }
}
