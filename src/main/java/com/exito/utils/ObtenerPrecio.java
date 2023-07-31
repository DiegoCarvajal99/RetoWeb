package com.exito.utils;

import com.exito.interactions.CantidadAleatoria;

import java.math.BigDecimal;

import static com.exito.interactions.ProductoAleatorio.precioProducto;

public class ObtenerPrecio {

    public static int total = 0;

    public static void producto(){
        String valorNumericoString = precioProducto.replaceAll("[^\\d.]", "");
        BigDecimal number = new BigDecimal(valorNumericoString.replace(".", ""));
        BigDecimal result = number.multiply(new BigDecimal(CantidadAleatoria.num));
        int suma = result.intValue();
        total += suma;
        try {
            Esperas.esperarPor(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
