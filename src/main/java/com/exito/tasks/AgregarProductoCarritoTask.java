package com.exito.tasks;

import com.exito.interactions.*;
import com.exito.utils.DatosExcel;
import com.exito.utils.Esperas;
import com.exito.utils.ObtenerPrecio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import static com.exito.interactions.ProductoAleatorio.nombreProducto;
import static com.exito.userInterface.AgregarProductoCarritoPage.*;
import static com.exito.utils.ObtenerPrecio.total;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AgregarProductoCarritoTask implements Task {
    DatosExcel datos = new DatosExcel();
    public static String valorTotal;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_MENU, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_MENU),
                WaitUntil.the(BTN_HOGAR_MUEBLES, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_HOGAR_MUEBLES),
                WaitUntil.the(BTN_ESCRIOTORIOS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ESCRIOTORIOS),
                WaitUntil.the(LBL_HOGAR, isClickable()).forNoMoreThan(30).seconds(),
                Scroll.to(LBL_HOGAR)

        );
        try {
            for (int i = 0; i < 5; i++) {
                actor.attemptsTo(
                        WaitUntil.the(BTN_IMG_PRODUCTO, isClickable()).forNoMoreThan(30).seconds(),
                        ProductoAleatorio.on()
                );

                Esperas.esperarPor(5);

                while (!BTN_AGREGAR.resolveFor(actor).isVisible()) {
                    actor.attemptsTo(
                            WaitUntil.the(LBL_ESCRITORIO, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                            Click.on(LBL_ESCRITORIO),
                            WaitUntil.the(BTN_IMG_PRODUCTO, isClickable()).forNoMoreThan(30).seconds(),
                            ProductoAleatorio.on()
                    );
                }
                actor.attemptsTo(
                        WaitUntil.the(BTN_AGREGAR, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                        Click.on(BTN_AGREGAR),
                        CantidadAleatoria.on(10),
                        WaitUntil.the(LBL_CANTIDAD_PRODUCTOS, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                        AgregarAlCarrito.on()
                );
                ObtenerPrecio.producto();
                actor.attemptsTo(
                        WaitUntil.the(BTN_CARRITO, isClickable()).forNoMoreThan(60).seconds(),
                        JavaScriptClick.on(BTN_CARRITO)
                );
                if (i == 0) {
                    actor.attemptsTo(
                            WaitUntil.the(INP_EMAIL, isVisible()).forNoMoreThan(60).seconds(),
                            Enter.theValue(datos.leerDatoExcel("Datos", "Datos.xlsx", 1, 0)).into(INP_EMAIL),
                            JavaScriptClick.on(BTN_CONFIRMAR),
                            WaitUntil.the(LBL_NOMBRE_PRODUCTO_CARRITO, isVisible()).forNoMoreThan(60).seconds(),
                            ScrollDown.on()
                    );

                }

                Esperas.esperarPor(2);

                Target producto = Target.the("NOMBRE PRDUCTO").located((By.xpath("//span[contains(text(),'" + nombreProducto + "')]")));
                Target unidades = Target.the("UNIDADES PRDUCTO").located((By.xpath("//span[.='" + CantidadAleatoria.num + "')]")));

                Ensure.that(Text.of(producto).equals(datos.leerDatoExcel("Validaciones", "Datos.xlsx", 1, 0)));
                Ensure.that(Text.of(unidades).equals(datos.leerDatoExcel("Validaciones", "Datos.xlsx", 1, 1)));

                if (i < 4) {
                    actor.attemptsTo(
                            Click.on(IMG_PRODUCTO_CARRITO),
                            WaitUntil.the(LBL_ESCRITORIO, isVisible()).forNoMoreThan(60).seconds(),
                            Click.on(LBL_ESCRITORIO)
                    );

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        numberFormat.setGroupingUsed(true);
        valorTotal = "$ " + numberFormat.format(total);
        actor.attemptsTo(
                EscribirEnExcel.on("Datos.xlsx", "Validaciones", 1, 2, valorTotal)
        );
    }


    public static AgregarProductoCarritoTask on() {
        return Tasks.instrumented(AgregarProductoCarritoTask.class);
    }

}
