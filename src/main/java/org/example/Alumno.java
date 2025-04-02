package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Alumno {
    @Setter
    private String nombre;

    @Setter
    private String apellido;

    @Setter
    private String legajo;

    private List<Materia> materiasAprobadas;

    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }

    public void agregarMateriasAprobadas(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }

    public boolean tieneAprobada(Materia materia) {
        return this.materiasAprobadas.contains(materia);
    }

    public boolean puedeCursar(Materia materia) {
        return materia.getCorrelativas().stream().allMatch(this::tieneAprobada);
    }
}