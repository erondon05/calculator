package io.corp.calculator.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import io.corp.calculator.ApplicationConfig;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest {
	
	
	@LocalServerPort
    int port;


	
	@MockBean
	private CalculatorController calculatorController;
	   
	   @Before
	    public void setUp() {
		   calculatorController = Mockito.mock(CalculatorController.class);
		   
	    }
	   
	   @Test
	   public void calculatorControllerTest() throws URISyntaxException {
		   RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
			 BigDecimal firstNumber = new BigDecimal("12");
		     BigDecimal secondNumber = new BigDecimal("7");
		     String operation = "subtraction";
		        String  urlEndopint = "http://localhost:" + port +  "/calculator/calculate?" + "first=" + firstNumber + 
		                "&second=" + secondNumber + "&operation=" + operation;
		    	
		        URI uri = new URI(urlEndopint);
		    	
		        ResponseEntity<BigDecimal>  result = restTemplate.getForEntity(uri, BigDecimal.class);
		    
			
			Mockito.when(this.calculatorController.calcula(firstNumber, secondNumber, operation))
			.thenReturn(result);
			
			assertEquals(200, result.getStatusCodeValue(), "validating the result obtained");
			
		}

}
