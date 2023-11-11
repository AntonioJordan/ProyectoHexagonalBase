package com.trasteandospring;

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
