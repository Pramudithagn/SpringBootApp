package com.pramu.SpringBootApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

//    @RequestMapping (value = "/check", method = RequestMethod.GET)

    @Value("${check.message}")
    private String checkMessage;

    @GetMapping("/check")
    public String check(){
        return checkMessage;
    }

}
