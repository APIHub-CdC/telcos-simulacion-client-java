# telcos-simulacion-client-java

Presenta los creditos de la persona con servicios con domicilio asociado de: telefonía celular; televisión de paga; y, telefonía local y de larga distancia (entorno de simulación).

## Requisitos

1. Java >= 1.7
2. Maven >= 3.3

## Instalación

Para la instalación de las dependencias se deberá ejecutar el siguiente comando:

```shell
mvn install -Dmaven.test.skip=true
```

> **NOTA:** Este fragmento del comando *-Dmaven.test.skip=true* evitará que se lance la prueba unitaria.


## Guía de inicio

### Paso 1. Agregar el producto a la aplicación

Al iniciar sesión seguir os siguientes pasos:

 1. Dar clic en la sección "**Mis aplicaciones**".
 2. Seleccionar la aplicación.
 3. Ir a la pestaña de "**Editar '@tuApp**' ".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/edit_applications.jpg" width="900">
    </p>
 4. Al abrirse la ventana emergente, seleccionar el producto.
 5. Dar clic en el botón "**Guardar App**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/selected_product.jpg" width="400">
    </p>

### Paso 2. Capturar los datos de la petición

Los siguientes datos a modificar se encuentran en ***src/test/java/io/TelcosSimulacion/client/api/TelecosSimulacionApiTest.java***

Es importante contar con el setUp() que se encargará de inicializar la url. Modificar la URL ***('the_url')***, como se muestra en el siguiente fragmento de código:

```java
private Logger logger = LoggerFactory.getLogger(TelecosSimulacionApiTest.class.getName());
private final TelecosSimulacionApi api = new TelecosSimulacionApi(); 
private ApiClient apiClient = null;

@Before()
public void setUp() {
	this.apiClient = api.getApiClient();
	this.apiClient.setBasePath("the_url");
	OkHttpClient insecureClient = ApiClient.getClientNoSSLVerification();
	OkHttpClient okHttpClient = insecureClient.newBuilder()
			.readTimeout(60, TimeUnit.SECONDS)
			.build();
	apiClient.setHttpClient(okHttpClient);	
} 
```

En el archivo **TelecosSimulacionApiTest**, que se encuentra en ***src/test/java/io/TelcosSimulacion/client/api*** se deberá modificar el siguiente fragmento de código con los datos correspondientes:

```java
@Test
public void getReporteTest() throws ApiException {
	
	String xApiKey = "your_api_key";

    DomicilioPeticion domicilio = new DomicilioPeticion();
    domicilio.setDireccion(null);
    domicilio.setColonia(null);
    domicilio.setMunicipio(null);
    domicilio.setCiudad(null);
    domicilio.setEstado(CatalogoEstados.CDMX);
    domicilio.setCodigoPostal(null);
    domicilio.setFechaResidencia(null);
    domicilio.setNumeroTelefono(null);
    domicilio.setTipoDomicilio(CatalogoTipoDomicilio.C);
    domicilio.setTipoAsentamiento(CatalogoTipoAsentamiento._1);
    
    PersonaPeticion persona = new PersonaPeticion();
    persona.setPrimerNombre("NOMBRE");
    persona.setSegundoNombre(null);
    persona.setApellidoPaterno("PATERNO");
    persona.setApellidoMaterno("MATERNO");
    persona.setApellidoAdicional(null);
    persona.setFechaNacimiento("27-06-1986");
    persona.setRfc(null);
    persona.setCurp(null);
    persona.setNumeroSeguridadSocial(null);
    persona.setNacionalidad("");
    persona.setResidencia(CatalogoResidencia._1);
    persona.setEstadoCivil(CatalogoEstadoCivil.S);
    persona.setSexo(CatalogoSexo.M);
    persona.setClaveElector("");
    persona.setNumeroDependientes("");
    persona.setFechaDefuncion("");
    persona.setDomicilio(domicilio);
    
	try {
        Respuesta response = api.getReporte(xApiKey, persona);
        Assert.assertTrue(response != null);
        if(response != null) {
        	logger.info(response.toString());
        }
	} catch (ApiException e) {
		logger.info(e.getResponseBody());
	}

}
```

### Paso 3. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:

```shell
mvn test -Dmaven.install.skip=true
```
