package com.bancolombia.certificacion.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.vivaair.com/co/")
public class ClsIndexPage extends PageObject {

	
	@FindBy(id="tab-flight")
	private WebElementFacade mnVuelos;
	
	@FindBy(id="tab-checkin")
	private WebElementFacade mnCheckIn;
	
	@FindBy(id="tab-booking")
	private WebElementFacade mnBooking;
	
	@FindBy(id="tab-hotel")
	private WebElementFacade mnHotel;
	
	@FindBy(id="tab-rentalcars")
	private WebElementFacade mnCar;

	
	public void FnvSeleccionarOpcionMenu(String strOpcionMenu) {
		
		System.out.println(strOpcionMenu);
		switch (strOpcionMenu) {
	        case "vuelos":   mnVuelos.click();   break;
	        case "checkIn":   mnCheckIn.click();  break;
	        case "reservas":   mnBooking.click();  break;
	        case "hotel":   mnHotel.click();  break;
	        case "carro":   mnCar.click();  break;
	        default: mnVuelos.click();   break;
	        }
		}
}
