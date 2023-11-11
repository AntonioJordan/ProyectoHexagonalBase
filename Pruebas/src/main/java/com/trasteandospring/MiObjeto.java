package com.trasteandospring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
public class MiObjeto {
    private String textoDelJson;

    public MiObjeto(String textoDelJson) {
        this.textoDelJson = textoDelJson;
    }
    public MiObjeto() {
    }

    public String getTextoDelJson() {
        return textoDelJson;
    }

    public void setTextoDelJson(String textoDelJson) {
        this.textoDelJson = textoDelJson;
    }
}
