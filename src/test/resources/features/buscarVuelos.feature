#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.

@tag
Feature: Se requiere ingresar a la pagina de vuelos vivaColombia y buscar los vuelos mas baratos de Origen a Destino


  @tag1
  Scenario: Buscar el vuelo mas barato de ida y el mas costoso de regreso
Given que me encuentro en la pagina de los vuelos
When ingreso la informacion del Vuelo
|origen|medellin|
|destino|cartagena|
|fechaPartida|09/11/2018|
|fechaRegreso|30/12/2018|
|moneda|mxn|
|adultos|2|
|ninos|1|
|infantes|1|
Then selecciono la tarifa de partida mas economica
And selecciono la tarifa de regreso mas costosa
And ingreso la informacion de los pasajeros adultos

|nombre|apellido|genero|numeroDoc|correo|celular|
|Karen|lopez|Femenino|12312312|karen@gmil.com|3012223012|
|selene|lopez|Femenino|42312312|selenen@gmil.com|4012223012|

And ingreso la informacion de los pasajeros ninos
|nombre|apellido|FechaNacimiento|numeroDoc|Genero|
|Salome|garcia	|12/03/2012			|435435345|Femenino|

And ingreso la informacion de los pasajeros infantes
|nombre	|apellido|FechaNacimiento|Viajandocon|
|Sofia	|rendon	|	12/03/2018		|Adulto 1|

And exporto la lista a excel

