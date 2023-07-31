package com.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirEnExcel implements Interaction {

    private String rutaArchivo;
    private String nombreHoja;
    private int fila;
    private int columna;
    private String valor;

    public EscribirEnExcel(String rutaArchivo, String nombreHoja, int fila, int columna, String valor) {

        this.rutaArchivo = rutaArchivo;
        this.nombreHoja = nombreHoja;
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            FileInputStream file = new FileInputStream(new File(rutaArchivo));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(nombreHoja);
            XSSFRow row = sheet.getRow(fila);
            if (row == null) {
                row = sheet.createRow(fila);
            }
            XSSFCell cell = row.getCell(columna);
            if (cell == null) {
                cell = row.createCell(columna);
            }
            cell.setCellValue(valor);
            FileOutputStream out = new FileOutputStream(new File(rutaArchivo));
            workbook.write(out);
            out.close();
            file.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EscribirEnExcel on(String rutaArchivo, String nombreHoja, int fila, int columna, String valor) {
        return Tasks.instrumented(EscribirEnExcel.class, rutaArchivo, nombreHoja, fila, columna, valor);
    }
}
