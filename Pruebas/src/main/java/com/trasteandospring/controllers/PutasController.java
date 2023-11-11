package com.trasteandospring.controllers;

import com.trasteandospring.MiObjeto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@Slf4j
public class PutasController {

    @PostMapping(value = "zorraDeMierda")
    public String metodo(@RequestBody List<MiObjeto> objetoJson) {
        log.info(objetoJson.get(0).getTextoDelJson());
        log.info(objetoJson.get(1).getTextoDelJson());
        log.info(objetoJson.get(2).getTextoDelJson());
        return objetoJson.get(0).getTextoDelJson().concat(" - ").concat(objetoJson.get(1).getTextoDelJson().concat(" - ")).concat(objetoJson.get(2).getTextoDelJson());
    }
}
