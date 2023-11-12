package com.trasteandospring.services;

import com.trasteandospring.Adapters.MiObjeto;
import org.springframework.stereotype.Service;

@Service
public class MiObjetoServiceImpl implements MiObjetoService{

    @Override
    public MiObjeto crearMiObjeto(String texto) {
        return new MiObjeto(texto);
    }
}
