package com.trasteandospring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PutasController {
    @GetMapping(
            value = "/zorraDeMierda",
            produces = "application/json")
//    @ResponseBody
    public ResponseEntity<String> controllador_generico(){
        return ResponseEntity.ok("aaaaa");
    }
}

