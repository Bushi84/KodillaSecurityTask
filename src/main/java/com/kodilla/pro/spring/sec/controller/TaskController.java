package com.kodilla.pro.spring.sec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TaskController {

    @GetMapping(path = "/m1")
    public String m1() {
        return "Metoda m1!";
    }

    @GetMapping(path = "/m2")
    public String m2() {
        return "Metoda m2!";
    }

    @GetMapping(path = "/m3")
    public String m3() {
        return "Metoda m3!";
    }
}
