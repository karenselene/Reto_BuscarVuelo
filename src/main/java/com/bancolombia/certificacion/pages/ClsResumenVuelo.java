package com.bancolombia.certificacion.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ClsResumenVuelo extends PageObject {

	@FindBy(xpath = "//*[@class='basketFlight']/")
	private WebElementFacade Resultado;

	@FindBy(xpath = "//*[@class='basketFlight']/div[@class='outbound']")
	private WebElementFacade llegada;

	private List<String> lstListadoVuelos;
	private List<String> lstOpciones = Arrays.asList("basketFlight", "basketPayment", "basketTotal");

	// basketFlight

	public List<String> FnvCapturarLosResultados() {

		lstListadoVuelos = new ArrayList<String>();

		for (String string : lstOpciones) {
			List<WebElement> rows = getDriver().findElements(By.xpath("//*[@class='" + string + "']"));

			for (WebElement webElement : rows) {
				lstListadoVuelos.add(webElement.getText());
			}

		}

		return lstListadoVuelos;

	}

}
