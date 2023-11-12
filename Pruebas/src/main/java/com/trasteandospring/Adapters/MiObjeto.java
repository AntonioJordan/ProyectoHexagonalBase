package com.trasteandospring.Adapters;

import org.springframework.stereotype.Component;

@Component
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