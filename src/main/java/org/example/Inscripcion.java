package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Inscripcion {
    private List<Materia> materiasACursar;
    private Alumno alumno;

    public Inscripcion() {
        this.materiasACursar = new ArrayList<>();
    }

    public void inscribir(Materia ... materias) {
        Collections.addAll(this.materiasACursar, materias);
    }

    public boolean aprobada() {
        return this.materiasACursar.stream().allMatch(m -> this.alumno.puedeCursar(m));
    }
}

