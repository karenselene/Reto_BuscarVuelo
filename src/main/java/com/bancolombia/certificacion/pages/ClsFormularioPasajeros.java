package com.bancolombia.certificacion.pages;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class ClsFormularioPasajeros extends PageObject {

	public void FnvIngresarDatosAdultos(int iterador, String strNombre, String strApellido, String strGenero,
			String strNumDoc, String strCorreo, String strCel) {

		getDriver().findElement(By.xpath("//*[@id=\"Adults[" + iterador + "].FirstName\"]")).sendKeys(strNombre);
		getDriver().findElement(By.xpath("//*[@id=\"Adults[" + iterador + "].LastName\"]")).sendKeys(strApellido);
		getDriver().findElement(By.xpath("//*[@id=\"Adults[" + iterador + "].IdentificationNumber\"]"))
				.sendKeys(strNumDoc);

		waitABit(1000);

		if (iterador == 0) {

			getDriver().findElement(By.xpath("//*[@id=\"Passengers[" + 0 + "].email\"]")).sendKeys(strCorreo);
			getDriver().findElement(By.xpath("//*[@id=\"Passengers[" + 0 + "].repeatemail\"]")).sendKeys(strCorreo);
			getDriver().findElement(By.xpath("//*[@id=\"Passengers0_mobile\"]")).sendKeys(strCel);

		}

	}

	public void FnvIngresarDatosNinos(int iterador, String strNombre, String strApellido, String strFechaNac,
			String strNumDoc, String strGenero) {

		getDriver().findElement(By.xpath("//*[@id=\"Children[" + iterador + "].FirstName\"]")).sendKeys(strNombre);
		getDriver().findElement(By.xpath("//*[@id=\"Children[" + iterador + "].LastName\"]")).sendKeys(strApellido);
		getDriver().findElement(By.xpath("//*[@id='Passengers_" + iterador + "__NativeDateOfBirth']"))
				.sendKeys("12/03/2012");
		getDriver().findElement(By.xpath("//*[@id=\"Children[" + iterador + "].IdentificationNumber\"]"))
				.sendKeys(strNumDoc);

	}

	public void FnvIngresarDatosInfantes(int iterador, String strNombre, String strApellido, String strFechaNac,
			String Viajandocon) {

		getDriver().findElement(By.xpath("//*[@id=\"Infants[" + iterador + "].FirstName\"]")).sendKeys(strNombre);
		getDriver().findElement(By.xpath("//*[@id=\"Infants[" + iterador + "].LastName\"]")).sendKeys(strApellido);
		getDriver().findElement(By.xpath("//*[@id='Passengers_" + iterador + "__NativeDateOfBirth']"))
				.sendKeys("12/03/2018");
		waitABit(3000);
	}

}
