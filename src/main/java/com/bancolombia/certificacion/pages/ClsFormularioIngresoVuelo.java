package com.bancolombia.certificacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ClsFormularioIngresoVuelo extends PageObject {

	@FindBy(id = "fromAirportWrapper")
	private WebElementFacade btnOrigen;

	@FindBy(id = "s2id_autogen20_search")
	private WebElementFacade txtOrigen;

	@FindBy(id = "select2-chosen-21")
	private WebElementFacade btnDestino;

	@FindBy(id = "s2id_autogen21_search")
	private WebElementFacade txtDestino;

	@FindBy(xpath = "//*[@id=\"box-flight-form\"]/div[6]/div/div[1]/fieldset/div[1]")
	private WebElementFacade btnFechaExacta;

	@FindBy(id = "DepartureDateForDisplay")
	private WebElementFacade pckCalendarioSalida;

	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")
	private WebElementFacade btnNextMonth;

	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[@class='ui-datepicker-month']")
	private WebElementFacade lbMesActivo;

	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[@class='ui-datepicker-year']")
	private WebElementFacade lbAnnoActivo;

	@FindBy(id = "select2-chosen-15")
	private WebElementFacade btnMoneda;

	@FindBy(id = "s2id_autogen15_search")
	private WebElementFacade txtMoneda;

	@FindBy(id = "select2-chosen-22")
	private WebElementFacade btnAdultos;

	@FindBy(id = "s2id_autogen22_search")
	private WebElementFacade txtAdultos;

	@FindBy(id = "select2-chosen-23")
	private WebElementFacade btnNinos;

	@FindBy(id = "s2id_autogen23_search")
	private WebElementFacade txtNinos;

	@FindBy(id = "select2-chosen-25")
	private WebElementFacade btnInfantes;

	@FindBy(id = "s2id_autogen25_search")
	private WebElementFacade txtInfantes;

	@FindBy(id = "continueLink")
	private WebElementFacade btnReservar;

	public void FnvIngresarOrigen(String strOrigen) {
		btnOrigen.click();
		txtOrigen.clear();
		txtOrigen.sendKeys(strOrigen);
		waitABit(2000);
		txtOrigen.sendKeys(Keys.ENTER);
	}

	public void FnvIngresarDestino(String strDestino) {
		btnDestino.click();
		txtDestino.clear();
		txtDestino.sendKeys(strDestino);
		waitABit(2000);
		txtDestino.sendKeys(Keys.ENTER);

	}

	public void FnvSeleccionarCalendario() {
		pckCalendarioSalida.click();
	}

	public void FnvSeleccionarFecha(String strFechaOrigen) {
		String strDia = strFechaOrigen.substring(0, 2);
		String strMesNum = strFechaOrigen.substring(3, 5);
		String strAnno = strFechaOrigen.substring(6, 10);

		if (strDia.substring(0, 1).equals("0")) {
			strDia = strDia.replace("0", "");
		}

		String strMes = "";
		switch (strMesNum) {
		case "01":
			strMes = "Enero";
			break;
		case "02":
			strMes = "Febrero";
			break;
		case "03":
			strMes = "Marzo";
			break;
		case "04":
			strMes = "Abril";
			break;
		case "05":
			strMes = "Mayo";
			break;
		case "06":
			strMes = "Junio";
			break;
		case "07":
			strMes = "Julio";
			break;
		case "08":
			strMes = "Agosto";
			break;
		case "09":
			strMes = "Septiembre";
			break;
		case "10":
			strMes = "Octubre";
			break;
		case "11":
			strMes = "Noviembre";
			break;
		case "12":
			strMes = "Diciembre";
			break;
		}

		int intmesNum = Integer.parseInt(strMesNum) - 1;

		do {

			if (btnNextMonth.getAttribute("data-event").equals("click")) {

				btnNextMonth.click();

			} else
				break;

		} while (!lbMesActivo.getText().equalsIgnoreCase(strMes) || !lbAnnoActivo.getText().equals(strAnno));

		getDriver().findElement(By.xpath(
				"//*[@data-month='" + intmesNum + "']/a[@class='ui-state-default' and text()='" + strDia + "' ]"))
				.click();

		waitABit(2000);
	}

	public void FnvSeleccionarMoneda(String strMoneda) {

		btnMoneda.click();
		txtMoneda.clear();
		txtMoneda.sendKeys(strMoneda);
		waitABit(2000);
		txtMoneda.sendKeys(Keys.ENTER);
	}

	public void FnvSeleccionarNumAdultos(String strNumAdultos) {

		btnAdultos.click();
		txtAdultos.clear();
		txtAdultos.sendKeys(strNumAdultos);
		waitABit(2000);
		txtAdultos.sendKeys(Keys.ENTER);
	}

	public void FnvSeleccionarNumNinos(String strNumNinos) {

		btnNinos.click();
		txtNinos.clear();
		txtNinos.sendKeys(strNumNinos);
		waitABit(2000);
		txtNinos.sendKeys(Keys.ENTER);
	}

	public void FnvSeleccionarNumInfantes(String strNumNinos) {

		btnInfantes.click();
		txtInfantes.clear();
		txtInfantes.sendKeys(strNumNinos);
		waitABit(2000);
		txtInfantes.sendKeys(Keys.ENTER);
	}

	public void FnvSeleccionarFechaExacta() {

		btnFechaExacta.click();
	}

	public void FnvBuscarVuelos() {

		btnReservar.click();

	}

}