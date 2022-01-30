package com.example.ZuulServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Praveenkumar on 1/28/2022.
 */
@RestController
public class ZuulHealthController {

    @GetMapping("/health")
    public String health(){
        return " Zuul Server is running, heathy !!! ";
    }

}
