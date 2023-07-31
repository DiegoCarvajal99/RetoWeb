package com.exito.interactions;

import com.exito.utils.Esperas;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

import static com.exito.userInterface.AgregarProductoCarritoPage.*;

public class ProductoAleatorio implements Interaction {
    public static int numRandom;
    public static String nombreProducto;
    public static String precioProducto;

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Esperas.esperarPor(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Random random = new Random();
        List<WebElementFacade> listaProductos = BTN_IMG_PRODUCTO.resolveAllFor(actor);
        List<WebElementFacade> listaNombre = LBL_NOMBRE_PRODUCTO.resolveAllFor(actor);
        List<WebElementFacade> listaPrecio = LBL_PRECIO_PRODUCTO.resolveAllFor(actor);
        numRandom = random.nextInt(listaProductos.size());
        nombreProducto = listaNombre.get(numRandom).getText();
        precioProducto = listaPrecio.get(numRandom).getText();
        listaProductos.get(numRandom).click();
        System.out.println(nombreProducto+ "\n"+precioProducto);
        actor.attemptsTo(
                EscribirEnExcel.on("Datos.xlsx", "Validaciones", 1, 0, nombreProducto)
        );
    }
    public static Performable on(){
        return Instrumented.instanceOf(ProductoAleatorio.class).withProperties();
    }
}
