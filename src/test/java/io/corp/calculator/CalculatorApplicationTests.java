package io.corp.calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {
	
	@LocalServerPort
    int port;



	@Test
	void additionTest() throws URISyntaxException{
    	String operation = "addition";
    	
    	RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
             
        
        BigDecimal firstNumber = new BigDecimal("5");
        BigDecimal secondNumber = new BigDecimal("20");
        
        String  urlEndopint = "http://localhost:" + port +  "/calculator/calculate?" + "first=" + firstNumber + 
                "&second=" + secondNumber + "&operation=" + operation;
    	
        URI uri = new URI(urlEndopint);
        

        ResponseEntity<BigDecimal>  result = restTemplate.getForEntity(uri, BigDecimal.class);
        
        assertAll(
                () -> assertEquals(200, result.getStatusCodeValue(), "validating http response"),
                () -> assertEquals(25.0d, result.getBody().doubleValue(), "validating the result obtained")
                );
        
    }
	
    
	@Test
	void subtractionTest() throws URISyntaxException {
	String operation = "subtraction";
    	
    	RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        
        BigDecimal firstNumber = new BigDecimal("30");
        BigDecimal secondNumber = new BigDecimal("10");
        
        String  urlEndopint = "http://localhost:" + port +  "/calculator/calculate?" + "first=" + firstNumber + 
                "&second=" + secondNumber + "&operation=" + operation;
    	
        URI uri = new URI(urlEndopint);
    	
        ResponseEntity<BigDecimal>  result = restTemplate.getForEntity(uri, BigDecimal.class);
        
        assertAll(
                () -> assertEquals(200, result.getStatusCodeValue(), "validating http response"),
                () -> assertEquals(20.0d, result.getBody().doubleValue(), "validating the result obtained")
                );

    }
    
	@Test
	void multiplicationTest() throws URISyntaxException {
	String operation = "multiplication";
    	
    	RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
 
        
        BigDecimal firstNumber = new BigDecimal("8");
        BigDecimal secondNumber = new BigDecimal("5");
        
        String  urlEndopint = "http://localhost:" + port +  "/calculator/calculate?" + "first=" + firstNumber + 
                "&second=" + secondNumber + "&operation=" + operation;
    	
        URI uri = new URI(urlEndopint);
    	
        ResponseEntity<BigDecimal>  result = restTemplate.getForEntity(uri, BigDecimal.class);
        
        assertAll(
                () -> assertEquals(200, result.getStatusCodeValue(), "validating http response"),
                () -> assertEquals(40.0d, result.getBody().doubleValue(), "validating the result obtained")
                );
        

    }
    
	@Test
	void divisionTest() throws URISyntaxException {
	String operation = "division";
    	
    	RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        
        BigDecimal firstNumber = new BigDecimal("50");
        BigDecimal secondNumber = new BigDecimal("5");
        
        String  urlEndopint = "http://localhost:" + port +  "/calculator/calculate?" + "first=" + firstNumber + 
                "&second=" + secondNumber + "&operation=" + operation;
    	
        URI uri = new URI(urlEndopint);
    	
        ResponseEntity<BigDecimal>  result = restTemplate.getForEntity(uri, BigDecimal.class);
        
        assertAll(
                () -> assertEquals(200, result.getStatusCodeValue(), "validating http response"),
                () -> assertEquals(10.0d, result.getBody().doubleValue(), "validating the result obtained")
                );

    }


}
