package br.com.fiap.sprint3.controller;

import br.com.fiap.sprint3.model.Feedback;
import br.com.fiap.sprint3.service.FeedbackServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/feedbacks")
@Controller
public class FeedbackController {

    @Autowired
    private @Setter FeedbackServiceImpl service;

    @GetMapping("/addNew")
    public String addNewFeedback( Model model ){
        Feedback fbk = new Feedback();
        model.addAttribute("feedback", fbk);
        return "newFeedback";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute("feedback") Feedback feedback ){
        this.service.save( feedback );
        return "redirect:/feedbacks";
    }

    @GetMapping("/deleteFeedback/{id}")
    public String deleteThroughId( @PathVariable("id") Long id){
        this.service.deleteById(id);
        return "redirect:/feedbacks";
    }

    @GetMapping
    public String viewHomePageAsList(Model model){
        List<Feedback> feedbackList = this.service.findAllFeedbacks();
        model.addAttribute("allFeedbackList", feedbackList);
        return "indexFeedback";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model){
        Optional<Feedback> feedback  = this.service.findById(id);
        if(feedback.isPresent())
            model.addAttribute("feedback", feedback.get());
        else
            System.out.println("Feedback não encontrado");
        return "updateFeedback";

    }

    @PostMapping("/update")
    public String update( @ModelAttribute("feedback") Feedback feedback ){
        this.service.save( feedback );
        return "redirect:/feedbacks";
    }

    @GetMapping("/show/{id}")
    public String showFeedback( @PathVariable("id") Long id, Model model){
        Optional<Feedback> feedback = this.service.findById(id);

        if( feedback.isPresent() )
            model.addAttribute("feedback", feedback.get());
        else
            System.out.println("Feedback não encontrado");
        return "showFeedback";
    }

}
