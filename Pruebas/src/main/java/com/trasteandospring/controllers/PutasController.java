package com.trasteandospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PutasController {
    @GetMapping("/zorraDeMierda")
    @ResponseBody
    public String controllador_generico(){
        int a = 2;
        a += 7;
        int b = a;
        int c= b + a;
        return "aaaa - " + c;
    }
}

