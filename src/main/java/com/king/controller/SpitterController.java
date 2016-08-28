package com.king.controller;

import com.king.model.Spitter;
import com.king.service.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by jin82 on 2016/06/19.
 */
//@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpittleRepository spittleRepository;
    private Spitter spitter = null;

    @Autowired
    public SpitterController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String showRegisterForm(){
        return "registerForm";
    }

    @RequestMapping(value = "register2",method = RequestMethod.POST)
    public String processRegistration(Spitter spitter,BindingResult bindingResult){
        System.out.println(spitter);
        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                System.out.println(error.toString());
            }
        }
        this.spitter = spitter;
        return "redirect:/spitter/"+spitter.getUsername();
    }

    @RequestMapping(value = "{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username,Model model){
        System.out.println(username);
        Spitter spitter = this.spitter;
        model.addAttribute(spitter);
        return "profile";
    }
}
