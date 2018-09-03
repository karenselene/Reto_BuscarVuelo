package com.bancolombia.certificacion.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ClsBusquedaVuelos extends PageObject {

	@FindBy(xpath = "//*[@id=\"NormalSearchWrapper\"]/input[@id='rbCalendarNormal']")
	private WebElementFacade btnContinuar;

	@FindBy(xpath = "//*[@id=\"fancyConfirm\"]/div[4]/a")
	private WebElementFacade btnAcepto;

	public void FnvAceptarConfirmacion() {

		waitABit(5000);
		btnContinuar.click();

	}

	public void FnvAceptarCondiciones() {

		waitABit(5000);
		btnAcepto.click();

	}

	public List<Float> FnvCapturarListadoVuelos(String strOrigen_destino) {

		String strTipoVuelo = "";
		switch (strOrigen_destino) {
		case "partida":
			strTipoVuelo = "divAvailabilityOut";
			break;
		case "llegada":
			strTipoVuelo = "divAvailabilityIn";
			break;
		}

		waitABit(3000);
		List<WebElement> rows = getDriver()
				.findElements(By.xpath("//*[@id=\"" + strTipoVuelo + "\"]//*[@class=\"totalPrice\"]"));
		List<Float> listOfIntegers = new ArrayList<>();
		// int i=0;
		System.out.println("Total selected rows are " + rows.size());
		Iterator<WebElement> iter = rows.iterator();

		while (iter.hasNext()) {

			// Iterate one by one
			WebElement item = iter.next();

			// get the text
			String label = item.getText();
			label = label.substring(4, label.length());
			label = label.replace(",", "");

			listOfIntegers.add(Float.parseFloat(label));

			// print the text
			System.out.println("Row label is " + label);

		}

		return listOfIntegers;
	}

	public void FnvRecuperarVueloBarato() {

		List<WebElement> rows = getDriver()
				.findElements(By.xpath("//*[@id=\"divAvailabilityOut\"]//*[@class=\"totalPrice\"]"));
		rows.get(FnvMinIndex(FnvCapturarListadoVuelos("partida"))).click();
		waitABit(2000);

	}

	public void FnvRecuperarVueloCostoso() {
		List<WebElement> rows = getDriver()
				.findElements(By.xpath("//*[@id=\"divAvailabilityIn\"]//*[@class=\"totalPrice\"]"));
		rows.get(FnvMaxIndex(FnvCapturarListadoVuelos("llegada"))).click();
	}

	public static int FnvMinIndex(List<Float> list) {
		return list.indexOf(Collections.min(list));

	}

	public static int FnvMaxIndex(List<Float> list) {
		return list.indexOf(Collections.max(list));
	}

}
