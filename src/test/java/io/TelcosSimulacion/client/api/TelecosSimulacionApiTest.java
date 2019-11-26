package io.TelcosSimulacion.client.api;


import io.TelcosSimulacion.client.ApiClient;
import io.TelcosSimulacion.client.ApiException;
import io.TelcosSimulacion.client.model.PersonaPeticion;
import io.TelcosSimulacion.client.model.Respuesta;
import io.TelcosSimulacion.client.model.CatalogoEstadoCivil;
import io.TelcosSimulacion.client.model.CatalogoEstados;
import io.TelcosSimulacion.client.model.CatalogoResidencia;
import io.TelcosSimulacion.client.model.CatalogoSexo;
import io.TelcosSimulacion.client.model.CatalogoTipoAsentamiento;
import io.TelcosSimulacion.client.model.CatalogoTipoDomicilio;
import io.TelcosSimulacion.client.model.DomicilioPeticion;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Before;
import java.util.concurrent.TimeUnit;

public class TelecosSimulacionApiTest {
	
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
    
}
