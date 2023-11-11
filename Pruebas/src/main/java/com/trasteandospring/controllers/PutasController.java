package com.trasteandospring.controllers;

import com.trasteandospring.MiObjeto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class PutasController {

    @RequestMapping(
            value = "zorraDeMierda",
            method = RequestMethod.POST
    )
    public ResponseEntity<String> metodo(@RequestBody MiObjeto objetoJson){
        log.info(objetoJson.getTextoDelJson());
        return ResponseEntity.ok(objetoJson.getTextoDelJson());
    }
}
