package com.bancolombia.certificacion.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilExcel {
	private static String strStaticRutaArchivo;
	private static XSSFWorkbook libroExcel;
	private static XSSFSheet hojaLibro;

	public static void abrirArchivoCreado(String strRutaArchivo, String strHoja) {
		strStaticRutaArchivo = strRutaArchivo;
		try {
			FileInputStream inputStream = new FileInputStream(new File(strRutaArchivo));
			libroExcel = new XSSFWorkbook(inputStream);
			cambiarHoja(strHoja);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static int obtenerUltimaFila() {
		return hojaLibro.getLastRowNum();
	}
	public static int obtenerUltimaCelda(int intFila) {
		XSSFRow fila = hojaLibro.getRow(intFila);
		if (fila == null) {
			return 0;
		}else
		{
			return fila.getLastCellNum();
		}
		
	}

	public static void crearArchivoExcel(String strRutaArchivo, String strHoja) {
		strStaticRutaArchivo = strRutaArchivo;
		libroExcel = new XSSFWorkbook();
		hojaLibro = libroExcel.createSheet(strHoja);
	}

	public static Object leerDato(int intFila, int intColumna) {
		XSSFRow fila = hojaLibro.getRow(intFila);
		if (fila != null) {
			XSSFCell celda = fila.getCell(intColumna);
			if (celda != null) {
				if (celda.getCellTypeEnum() == CellType.STRING) {
					return celda.getStringCellValue();
				} else {
					return celda.getNumericCellValue();
				}
			}
		}
		return "";
	}

	public static void escribirCelda(String strValor, int intFila, int intColumna) {
		XSSFRow fila = hojaLibro.getRow(intFila);
		if (fila == null) {
			fila = hojaLibro.createRow(intFila);
		}
		XSSFCell celda = fila.getCell(intColumna);
		if (celda == null) {
			celda = fila.createCell(intColumna);
		}
		celda.setCellValue(strValor);
	}

	public static void setearColorCelda(int intFila, int intColumna, String strColor) {
		XSSFCellStyle styleCeldas = libroExcel.createCellStyle();

		if (strColor.equalsIgnoreCase("amarillo")) {
			styleCeldas.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		} else if (strColor.equalsIgnoreCase("rojo")) {
			styleCeldas.setFillForegroundColor(IndexedColors.RED.getIndex());
		} else if (strColor.equalsIgnoreCase("verde")) {
			styleCeldas.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		} else {
			styleCeldas.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		}
		styleCeldas.setFillPattern(CellStyle.SOLID_FOREGROUND);
		XSSFRow fila = hojaLibro.getRow(intFila);
		if (fila == null) {
			fila = hojaLibro.createRow(intFila);
		}
		XSSFCell celda = fila.getCell(intColumna);
		if (celda == null) {
			celda = fila.createCell(intColumna);
		}
		celda.setCellStyle(styleCeldas);
	}
	public static void cambiarHoja(String strHoja) {
		hojaLibro = libroExcel.getSheet(strHoja);
		if (hojaLibro == null ) {
			hojaLibro = libroExcel.createSheet(strHoja);          
		}
	}
	public static void exportarArchivo() {
		try {
			FileOutputStream outputStream = new FileOutputStream(new File(strStaticRutaArchivo));
			libroExcel.write(outputStream);
			libroExcel.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
