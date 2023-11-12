package com.trasteandospring.controllers;

import com.trasteandospring.adapters.MiObjeto;
import com.trasteandospring.services.MiObjetoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@Slf4j
public class PutasController {

    private final MiObjetoService miObjetoService;

    @Autowired
    public PutasController(MiObjetoService miObjeto){
        this.miObjetoService = miObjeto;
    }
    @Autowired
    @PostMapping(value = "/zorraDeMierda")
    public String metodo(@RequestBody List<MiObjeto> objetoJson) {
        MiObjeto objeto = this.miObjetoService.crearMiObjeto("objeto nuevo");
        log.info(objeto.getTextoDelJson());
        return objetoJson.get(0).getTextoDelJson();
    }
}
