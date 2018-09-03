package com.bancolombia.certificacion.buscar_vuelos;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/", glue="com.bancolombia.certificacion.definitions")


public class ClsRunner {

}