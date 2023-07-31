package com.exito.userInterface;

import com.exito.utils.DatosExcel;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.exito.interactions.ProductoAleatorio.nombreProducto;

public class AgregarProductoCarritoPage {
    static DatosExcel datos = new DatosExcel();
    public static final Target BTN_MENU = Target.the("BOTON QUE DESPLIEGA EL MENU").located(By.id("category-menu"));
    public static final Target BTN_HOGAR_MUEBLES = Target.the("BOTON DE LA CATEGORIA").located(By.id("undefined-nivel2-Hogar y muebles"));
    public static final Target BTN_ESCRIOTORIOS = Target.the("BOTON DE LA SUBCATEGOTIA").located(By.xpath("(//a[@id='Categorías-nivel3-Escritorios'])[1]"));
    public static final Target LBL_HOGAR = Target.the("TEXTO HOGAR").located(By.xpath("//span[@class='vtex-breadcrumb-1-x-arrow vtex-breadcrumb-1-x-arrow--1 ph2 c-muted-2']"));
    public static final Target BTN_IMG_PRODUCTO = Target.the("IMAGEN DEL PRODUCTO").located(By.xpath("//img[@class='vtex-product-summary-2-x-imageNormal vtex-product-summary-2-x-image vtex-product-summary-2-x-mainImageHovered']"));
    public static final Target LBL_NOMBRE_PRODUCTO = Target.the("NOMBRE DEL PRODUCTO").located(By.xpath("//span[@class='vtex-store-components-3-x-productBrand ']"));
    public static final Target LBL_PRECIO_PRODUCTO = Target.the("PRECIO DEL PRODUCTO").located(By.xpath("//div[@class='exito-vtex-components-4-x-PricePDP']/span"));
    public static final Target BTN_AGREGAR = Target.the("BOTON AGREGAR").located((By.xpath("//span[contains(text(),'Agregar')]")));
    public static final Target LBL_ESCRITORIO = Target.the("TEXTO ESCRITORIOR").located(By.xpath("//a[.='Escritorios']"));
    public static final Target LBL_CANTIDAD_PRODUCTOS = Target.the("CANTIDAD PRODUCTOS").located((By.xpath("//div[@class='exito-header-3-x-minicartQuantity']")));

    public static final Target ICN_MAS = Target.the("ICONO MAS").located((By.xpath("//span[@class='product-details-exito-vtex-components-buy-button-manager-more']")));
    public static final Target BTN_CARRITO = Target.the("BOTON CARRITO").located((By.xpath("//a[@class='exito-header-3-x-minicartLink']")));
    public static final Target INP_EMAIL = Target.the("EMAIL").located((By.xpath("//div[@class='exito-checkout-io-0-x-preLoginContainer']/div/div[4]//input[@type='email']")));
    public static final Target BTN_CONFIRMAR = Target.the("BOTON CONFIRMAR").located((By.xpath("//button[contains(text(),'Confirmar')]")));
    public static final Target IMG_PRODUCTO_CARRITO = Target.the("IMAGEN PRODUCTO").located((By.xpath("(//img)[1]")));
    public static final Target TXT_NOMBRE_PRODUCTO = Target.the("NOMBRE PRODUCTO").located((By.xpath("//span[@class='vtex-store-components-3-x-productBrand ']")));
    public static final Target LBL_PRECIO_PRODUCTO_TOTAL = Target.the("PRECIO PRODUCTO").located((By.xpath("//div[@class='exito-checkout-io-0-x-summaryTotal']/div/span[2]")));
    public static final Target BTN_SEGUIR_COMPRANDO = Target.the("BOTON SEGUIR COMPRANDO").located((By.xpath("//a[contains(text(),'Seguir comprando')]")));
    public static final Target LBL_NOMBRE_PRODUCTO_CARRITO= Target.the("NOMBRE PRODUCTO").located((By.xpath("//div[2]/div/div/div[4]/span")));
//    public static final Target LBL_CANTIDAD_PRODUCTOS = Target.the("CANTIDAD PRODUCTOS").located((By.xpath("//div[@class='exito-checkout-io-0-x-totalItemsSeller']")));


    }

