package com.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Random;

import static com.exito.userInterface.AgregarProductoCarritoPage.ICN_MAS;
import static com.exito.userInterface.AgregarProductoCarritoPage.LBL_CANTIDAD_PRODUCTOS;

public class AgregarAlCarrito implements Interaction {

    public static  int cantidad = 0 ;

    @Override
    public <T extends Actor> void performAs(T actor) {
        String cantidadTexto = LBL_CANTIDAD_PRODUCTOS.resolveFor(actor).getText();
        cantidad = Integer.parseInt(cantidadTexto);
        int sumatoria = cantidad + CantidadAleatoria.num;

        while (cantidad != sumatoria - 1) {
            actor.attemptsTo(
                    Click.on(ICN_MAS)
            );
            cantidad++;
        }

    }

    public static AgregarAlCarrito on() {

        return Tasks.instrumented(AgregarAlCarrito.class);
    }
}
