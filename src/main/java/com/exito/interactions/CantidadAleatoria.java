package com.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.Random;

public class CantidadAleatoria implements Interaction {

    public static int num;
    private int limite;

    public CantidadAleatoria(int limite) {
        this.limite = limite;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Random random = new Random();

        num = random.nextInt(limite) + 1;

        System.out.println("La cantidad aleatoria es: " + num);

        actor.attemptsTo(
                EscribirEnExcel.on("Datos.xlsx", "Validaciones", 1, 1, num + "")
        );
    }

    public static CantidadAleatoria on(int limite) {

        return Tasks.instrumented(CantidadAleatoria.class, limite);
    }
}
