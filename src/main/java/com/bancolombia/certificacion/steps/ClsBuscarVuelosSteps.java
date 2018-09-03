package com.bancolombia.certificacion.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebElement;

import com.bancolombia.certificacion.pages.ClsBusquedaVuelos;
import com.bancolombia.certificacion.pages.ClsFormularioIngresoVuelo;
import com.bancolombia.certificacion.pages.ClsFormularioPasajeros;
import com.bancolombia.certificacion.pages.ClsIndexPage;
import com.bancolombia.certificacion.pages.ClsResumenVuelo;
import com.bancolombia.certificacion.utils.UtilExcel;

import net.thucydides.core.annotations.Step;

public class ClsBuscarVuelosSteps {

	@Page
	private ClsIndexPage clsIndexPage;

	@Page
	private ClsFormularioIngresoVuelo clsFormIngresoVuelo;

	@Page
	private ClsBusquedaVuelos clsBusquedaVuelos;

	@Page
	private ClsFormularioPasajeros clsFormularioPasajeros;

	@Page
	private ClsResumenVuelo clsResumenVuelo;

	private int numAdultos, numNinos, numInfantes;

	private List<WebElement> listadoVuelos = new ArrayList<WebElement>();

	@Step
	public void FnvAbrirPaginaInicial(String strOpcionMenu) {
		clsIndexPage.open();
		clsIndexPage.FnvSeleccionarOpcionMenu(strOpcionMenu);
	}

	@Step
	public void FnvFormularioIngreso(String strOrigen, String strDestino, String strFechaPartida,
			String strFechaRegreso, String strMoneda, String strNumAdultos, String strNumNinos, String strNumInfantes) {
		// TODO Auto-generated method stub

		clsFormIngresoVuelo.FnvIngresarOrigen(strOrigen);
		clsFormIngresoVuelo.FnvIngresarDestino(strDestino);
		clsFormIngresoVuelo.FnvSeleccionarCalendario();
		clsFormIngresoVuelo.FnvSeleccionarFecha(strFechaPartida);
		clsFormIngresoVuelo.FnvSeleccionarFecha(strFechaRegreso);
		clsFormIngresoVuelo.FnvSeleccionarFechaExacta();
		clsFormIngresoVuelo.FnvSeleccionarMoneda(strMoneda);
		clsFormIngresoVuelo.FnvSeleccionarNumAdultos(strNumAdultos);
		numAdultos = Integer.parseInt(strNumAdultos);
		clsFormIngresoVuelo.FnvSeleccionarNumNinos(strNumNinos);
		numNinos = Integer.parseInt(strNumNinos);
		clsFormIngresoVuelo.FnvSeleccionarNumInfantes(strNumInfantes);
		numInfantes = Integer.parseInt(strNumInfantes);
		clsFormIngresoVuelo.FnvBuscarVuelos();

	}

	@Step
	public void FnvCapturarListadoVuelosBaratos() {
		clsBusquedaVuelos.FnvRecuperarVueloBarato();

	}

	@Step
	public void FnvCapturarListadoVuelosCostoso() {

		clsBusquedaVuelos.FnvRecuperarVueloCostoso();
		clsBusquedaVuelos.FnvAceptarCondiciones();

	}

	@Step
	public void FnvIngresarFormularioPasajeros(List<Map<String, String>> datosAdultos) {

		for (int i = 0; i < datosAdultos.size(); i++) {
			clsFormularioPasajeros.FnvIngresarDatosAdultos(i, datosAdultos.get(i).get("nombre"),
					datosAdultos.get(i).get("apellido"), datosAdultos.get(i).get("genero"),
					datosAdultos.get(i).get("numeroDoc"), datosAdultos.get(i).get("correo"),
					datosAdultos.get(i).get("celular"));

		}

	}

	@Step
	public void FnvIngresarFormularioPasajerosNinos(List<Map<String, String>> datosNinos) {

		int k = 0;
		for (int i = (numAdultos); i < (numAdultos + numNinos); i++) {
			clsFormularioPasajeros.FnvIngresarDatosNinos(i, datosNinos.get(k).get("nombre"),
					datosNinos.get(k).get("apellido"), datosNinos.get(k).get("fechaNacimiento"),
					datosNinos.get(k).get("numeroDoc"), datosNinos.get(k).get("genero"));
			k++;
		}

	}

	@Step
	public void FnvIngresarFormularioPasajerosInfantes(List<Map<String, String>> datosInfantes) {

		int k = 0;
		for (int i = numNinos + numAdultos; i < (numNinos + numAdultos + numInfantes); i++) {
			clsFormularioPasajeros.FnvIngresarDatosInfantes(i, datosInfantes.get(k).get("nombre"),
					datosInfantes.get(k).get("apellido"), datosInfantes.get(k).get("fechaNacimiento"),
					datosInfantes.get(k).get("Viajandocon"));
			k++;
		}

	}

	@Step
	public List<String> FnvObtenerResultados() {

		return clsResumenVuelo.FnvCapturarLosResultados();
	}

	@Step
	public void FnvExportarArchivoExcel() {

		UtilExcel.crearArchivoExcel("ResultadoBusqueda.xlsx", "ListaDeVuelos");

		UtilExcel.escribirCelda("Detalle del Vuelo", 0, 0);

		for (int i = 0; i < FnvObtenerResultados().size(); i++) {

			UtilExcel.escribirCelda(FnvObtenerResultados().get(i), i + 1, 0);

		}

		UtilExcel.exportarArchivo();

	}

}
