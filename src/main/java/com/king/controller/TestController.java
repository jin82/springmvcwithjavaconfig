package com.king.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/26
 * \* Time: 0:15
 * \* Description:
 * \
 */
@Controller
@RequestMapping(value = "/2")
public class TestController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "yes";
    }

}
