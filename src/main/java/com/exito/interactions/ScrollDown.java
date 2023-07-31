package com.exito.interactions;

import com.exito.utils.Esperas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollDown implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Esperas.esperarPor(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 400);");
        try {
            Esperas.esperarPor(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ScrollDown on() {
        return new ScrollDown();
    }
}
