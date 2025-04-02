package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    @Setter
    @Getter
    private String nombre;

    @Getter
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativa(Materia ... correlativas) {
        Collections.addAll(this.correlativas, correlativas);
    }
}
