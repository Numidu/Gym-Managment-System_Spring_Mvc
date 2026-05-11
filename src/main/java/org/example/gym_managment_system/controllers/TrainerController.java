package org.example.gym_managment_system.controllers;

import org.example.gym_managment_system.dao.TrainerDAO;
import org.example.gym_managment_system.model.Trainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrainerController {

    TrainerDAO trainerDAO = new TrainerDAO();

    @GetMapping("/t_view")
    public String loadPage(Model model){

        model.addAttribute(
                "trainerList",
                trainerDAO.getAllTrainers()
        );

        model.addAttribute(
                "et",
                new Trainer()
        );

        return "trainer";
    }

    @PostMapping("/saveTrainer")
    public String saveTrainer(Trainer trainer){

        trainerDAO.saveTrainer(trainer);

        return "redirect:/t_view";
    }

    @PostMapping("/deleteTrainer")
    public String deleteTrainer(@RequestParam("trainerId") int id){

        System.out.println("Delete Trainer id " + id);

        trainerDAO.deleteTrainer(id);

        return "redirect:/t_view";
    }

    @GetMapping("/editTrainer")
    public String editTrainer(

            @RequestParam("id")
            int id,

            Model model
    ){

        Trainer trainer =
                trainerDAO.findById(id);

        model.addAttribute(
                "et",
                trainer
        );

        model.addAttribute(
                "trainerList",
                trainerDAO.getAllTrainers()
        );

        return "trainer";
    }

    @PostMapping("/updateTrainer")
    public String updateTrainer(Trainer trainer){

        trainerDAO.update(trainer);

        return "redirect:/t_view";
    }
}