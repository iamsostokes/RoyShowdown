package com.detroitlabs.royshowdown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlayerController {

    @ResponseBody
    @RequestMapping("/")
    public String displayHomePage() {
        return "Hello World";
    }

}
