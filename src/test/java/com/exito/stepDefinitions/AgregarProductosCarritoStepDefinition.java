package com.exito.stepDefinitions;

import com.exito.tasks.AgregarProductoCarritoTask;
import com.exito.utils.DatosExcel;
import com.exito.utils.WebDriverFactory;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import java.io.IOException;

import static com.exito.userInterface.AgregarProductoCarritoPage.LBL_PRECIO_PRODUCTO_TOTAL;

public class AgregarProductosCarritoStepDefinition {

    DatosExcel datos = new DatosExcel();

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @Dado("^que el usuario se encuentre en la pagina principal de exito$")
    public void queElUsuarioSeEncuentreEnLaPaginaPrincipalDeExito() throws IOException {
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(WebDriverFactory.goToWeb(datos.leerDatoExcel("Dominios", "Datos.xlsx", 1, 0)))));

    }


    @Cuando("^el usuario selecciona los productos$")
    public void elUsuarioSeleccionaLosProductos() {
        OnStage.theActor("actor").attemptsTo(AgregarProductoCarritoTask.on());
    }

    @Entonces("^se valida que los valores de los productos correspondan a los que estan en el carrito$")
    public void seValidaQueLosValoresDeLosProductosCorrespondanALosQueEstanEnElCarrito() throws IOException {
        Ensure.that(Text.of(LBL_PRECIO_PRODUCTO_TOTAL).equals(datos.leerDatoExcel("Validaciones","Datos.xlsx",1,2)));
    }
}
