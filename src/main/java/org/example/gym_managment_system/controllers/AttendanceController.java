package org.example.gym_managment_system.controllers;


import org.example.gym_managment_system.dao.AttendanceDAO;
import org.example.gym_managment_system.dao.MemberDAO;
import org.example.gym_managment_system.model.Attendance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AttendanceController {

    AttendanceDAO attendanceDAO = new AttendanceDAO();

    MemberDAO memberDAO =
            new MemberDAO();

    @GetMapping("/at_view")
    public String loadPage(Model model){

        model.addAttribute(
                "attendanceList",
                attendanceDAO.getAllAttendance()
        );

        model.addAttribute(
                "memberList",
                memberDAO.getAllMembers()
        );

        model.addAttribute(
                "ea",
                new Attendance()
        );

        return "attendance";
    }

    @PostMapping("/saveAttendance")
    public String saveAttendance(
            Attendance attendance
    ){

        attendanceDAO.saveAttendance(attendance);

        return "redirect:/at_view";
    }

    @PostMapping("/deleteAttendance")
    public String deleteAttendance(
            @RequestParam("attendanceId") int id
    ){

        attendanceDAO.deleteAttendance(id);

        return "redirect:/at_view";
    }

    @GetMapping("/editAttendance")
    public String editAttendance(
            @RequestParam("id") int id,
            Model model
    ){

        Attendance attendance =
                attendanceDAO.findById(id);

        model.addAttribute(
                "ea",
                attendance
        );

        model.addAttribute(
                "attendanceList",
                attendanceDAO.getAllAttendance()
        );

        model.addAttribute(
                "memberList",
                memberDAO.getAllMembers()
        );

        return "attendance";
    }

    @PostMapping("/updateAttendance")
    public String updateAttendance(
            Attendance attendance
    ){

        attendanceDAO.updateAttendance(attendance);

        return "redirect:/at_view";
    }
}
