package com.bancolombia.certificacion.definitions;

import java.util.List;
import java.util.Map;

import com.bancolombia.certificacion.steps.ClsBuscarVuelosSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ClsBuscarVuelosDefinition {
	
	
	private int numAdultos;
	private int numNinos;
	private int numInfantes;

	@Steps
	private ClsBuscarVuelosSteps clsBuscarVuelosSteps;
	
	
	@Given("^que me encuentro en la pagina de los (.*)")
	public void queMeEncuentroEnLaPaginaDeLosVuelos(String strOpcionMenu) throws Exception {
		clsBuscarVuelosSteps.FnvAbrirPaginaInicial(strOpcionMenu);

	}

	@When("^ingreso la informacion del Vuelo$")
	public void ingresoLaInformacionDelVuelo(Map<String, String> mpDatosBusqueda) throws Exception {
		clsBuscarVuelosSteps.FnvFormularioIngreso(
				mpDatosBusqueda.get("origen"), 
				mpDatosBusqueda.get("destino"),
				mpDatosBusqueda.get("fechaPartida"), 
				mpDatosBusqueda.get("fechaRegreso"),  
				mpDatosBusqueda.get("moneda"),
				mpDatosBusqueda.get("adultos"),  
				mpDatosBusqueda.get("ninos"),  
				mpDatosBusqueda.get("infantes"));
		
		numAdultos= Integer.parseInt(mpDatosBusqueda.get("adultos"));
		numNinos= Integer.parseInt(mpDatosBusqueda.get("ninos"));
		numInfantes= Integer.parseInt(mpDatosBusqueda.get("infantes"));
		
	}
	
	@Then("^selecciono la tarifa de partida mas economica$")
	public void selecciono_la_tarifa_de_partida_mas_economica() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		clsBuscarVuelosSteps.FnvCapturarListadoVuelosBaratos();
	}

	@Then("^selecciono la tarifa de regreso mas costosa$")
	public void selecciono_la_tarifa_de_regreso_mas_costosa() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		clsBuscarVuelosSteps.FnvCapturarListadoVuelosCostoso();
	   
	}
	
	
	@Then("^ingreso la informacion de los pasajeros adultos$")
	public void ingreso_la_informacion_de_los_pasajeros_adultos(List<Map<String,String>> datosAdultos) throws Exception {
		clsBuscarVuelosSteps.FnvIngresarFormularioPasajeros(datosAdultos);

	}

	@Then("^ingreso la informacion de los pasajeros ninos$")
	public void ingreso_la_informacion_de_los_pasajeros_ninos(List<Map<String,String>> datosNinos) throws Exception {
		clsBuscarVuelosSteps.FnvIngresarFormularioPasajerosNinos(datosNinos);
	}

	@Then("^ingreso la informacion de los pasajeros infantes$")
	public void ingreso_la_informacion_de_los_pasajeros_infantes(List<Map<String,String>> datosInfantes) throws Exception {
	
		clsBuscarVuelosSteps.FnvIngresarFormularioPasajerosInfantes(datosInfantes);
	}
	

	@Then("^exporto la lista a excel$")
	public void exporto_la_lista_a_excel() throws Exception {
	    // Write code here that turns the phrase above into concrete actions

		clsBuscarVuelosSteps.FnvObtenerResultados();
		clsBuscarVuelosSteps.FnvExportarArchivoExcel();
	}
	
	


	

}
