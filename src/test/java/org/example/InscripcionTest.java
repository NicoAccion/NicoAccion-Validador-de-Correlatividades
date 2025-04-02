package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class InscripcionTest {
    private Alumno juan;
    private Materia materia1;
    private Materia materia2;
    private Materia materia3;

    @BeforeEach
    public void init() {
        juan = new Alumno();
        juan.setNombre("Juan");
        juan.setApellido("Gomez");

        materia1 = new Materia("Materia1");
        materia2 = new Materia("Materia2");
        materia3 = new Materia("Materia3");

        materia2.agregarCorrelativa(materia1);
        materia3.agregarCorrelativa(materia1, materia2);
    }

    @Test
    @DisplayName("La inscripción está aceptada por cumplir con correlativas")
    public void inscripcionEstaAceptadaTest() {
        juan.agregarMateriasAprobadas(materia1);

        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setAlumno(juan);
        unaInscripcion.inscribir(materia2);

        Assertions.assertTrue(unaInscripcion.aprobada());
    }

    @Test
    @DisplayName("La inscripción no se acepta por no tener todas las correlativas")
    public void laInscripcionNoEstaAprobadaTest() {
        juan.agregarMateriasAprobadas(materia1);

        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setAlumno(juan);
        unaInscripcion.inscribir(materia3);

        Assertions.assertFalse(unaInscripcion.aprobada());
    }
}