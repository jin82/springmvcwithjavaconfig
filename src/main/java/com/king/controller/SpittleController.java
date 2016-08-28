package com.king.controller;

import com.king.model.Spittle;
import com.king.service.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by jin82 on 2016/06/10.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;
    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }

    @RequestMapping(method = RequestMethod.GET,value = "spittleList")
    @ResponseBody
    public List<Spittle> spittleList(){
        return spittleRepository.findSpittles(Long.MAX_VALUE,20);
    }
}
