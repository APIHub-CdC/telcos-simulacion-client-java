package io.TelcosSimulacion.client.api;

import io.TelcosSimulacion.client.ApiClient;
import io.TelcosSimulacion.client.ApiException;
import io.TelcosSimulacion.client.model.PersonaPeticion;
import io.TelcosSimulacion.client.model.Peticion;
import io.TelcosSimulacion.client.model.Respuesta;
import io.TelcosSimulacion.client.model.CatalogoEstadoCivil;
import io.TelcosSimulacion.client.model.CatalogoEstados;
import io.TelcosSimulacion.client.model.CatalogoResidencia;
import io.TelcosSimulacion.client.model.CatalogoSexo;
import io.TelcosSimulacion.client.model.CatalogoTipoAsentamiento;
import io.TelcosSimulacion.client.model.CatalogoTipoDomicilio;
import io.TelcosSimulacion.client.model.DomicilioPeticion;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Before;

public class TelecosSimulacionApiTest {

	private Logger logger = LoggerFactory.getLogger(TelecosSimulacionApiTest.class.getName());
	private final TelecosSimulacionApi api = new TelecosSimulacionApi();
	private ApiClient apiClient = null;

	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
	}

	@Test
	public void getReporteTest() throws ApiException {

		String xApiKey = "your_api_key";
		Peticion peticion = new Peticion();

		DomicilioPeticion domicilio = new DomicilioPeticion();
		domicilio.setDireccion(null);
		domicilio.setColoniaPoblacion(null);
		domicilio.setDelegacionMunicipio(null);
		domicilio.setCiudad(null);
		domicilio.setEstado(CatalogoEstados.CDMX);
		domicilio.setCP(null);
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
		persona.setFechaNacimiento("1986-06-27");
		persona.setRFC(null);
		persona.setCURP(null);
		persona.setNacionalidad("");
		persona.setResidencia(CatalogoResidencia._1);
		persona.setEstadoCivil(CatalogoEstadoCivil.S);
		persona.setSexo(CatalogoSexo.M);
		persona.setClaveElectorIFE("");
		persona.setNumeroDependientes(0);
		persona.setFechaDefuncion("");
		persona.setDomicilio(domicilio);
		peticion.setFolioOtorgante("12421142");
		peticion.setPersona(persona);

		try {
			Respuesta response = api.getReporte(xApiKey, peticion);
			Assert.assertTrue(response != null);
			if (response != null) {
				logger.info(response.toString());
			}
		} catch (ApiException e) {
			logger.info(e.getResponseBody());
		}
	}
}
