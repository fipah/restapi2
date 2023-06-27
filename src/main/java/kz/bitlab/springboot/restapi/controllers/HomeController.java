package kz.bitlab.springboot.restapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/item")
public class HomeController {
    @GetMapping(value="/home")
    public String openHome(){
        return "home";
    }
    @GetMapping(value="/add-item")
    public String openAddItem(){
        return "add-item";
    }
    @GetMapping(value="/details/{id}")
    public String openDetails(@PathVariable("id") Long id, Model model){
        Long itemId = id;
        model.addAttribute("itemId", itemId);
        return "details";
    }
}
