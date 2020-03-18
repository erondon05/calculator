package io.corp.calculator;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
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
    public void additionTest() throws URISyntaxException{
    	String operation = "addition";
    	
    	RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        
        int firstNumber = 5;
        int secondNumber = 20;
        
        String  urlEndopint = "http://localhost:" + port +  "/calculator/calculate?" + "first=" + firstNumber + 
                "&second=" + secondNumber + "&operation=" + operation;
    	
        URI uri = new URI(urlEndopint);
    	
        ResponseEntity<Double>  result = restTemplate.getForEntity(uri, Double.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(25.0d, result.getBody().doubleValue(), 0.001d);

    }
    
    @Test
    public void subtractionTest() throws URISyntaxException {
	String operation = "subtraction";
    	
    	RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        
        int firstNumber = 30;
        int secondNumber = 10;
        
        String  urlEndopint = "http://localhost:" + port +  "/calculator/calculate?" + "first=" + firstNumber + 
                "&second=" + secondNumber + "&operation=" + operation;
    	
        URI uri = new URI(urlEndopint);
    	
        ResponseEntity<Double>  result = restTemplate.getForEntity(uri, Double.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(20.0d, result.getBody().doubleValue(), 0.001d);

    }
    
    @Test
    public void multiplicationTest() throws URISyntaxException {
	String operation = "multiplication";
    	
    	RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        
        int firstNumber = 8;
        int secondNumber = 5;
        
        String  urlEndopint = "http://localhost:" + port +  "/calculator/calculate?" + "first=" + firstNumber + 
                "&second=" + secondNumber + "&operation=" + operation;
    	
        URI uri = new URI(urlEndopint);
    	
        ResponseEntity<Double>  result = restTemplate.getForEntity(uri, Double.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(40.0d, result.getBody().doubleValue(), 0.001d);

    }
    
    @Test
    public void divisionTest() throws URISyntaxException {
	String operation = "division";
    	
    	RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        
        int firstNumber = 50;
        int secondNumber = 5;
        
        String  urlEndopint = "http://localhost:" + port +  "/calculator/calculate?" + "first=" + firstNumber + 
                "&second=" + secondNumber + "&operation=" + operation;
    	
        URI uri = new URI(urlEndopint);
    	
        ResponseEntity<Double>  result = restTemplate.getForEntity(uri, Double.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(10.0d, result.getBody().doubleValue(), 0.001d);

    }


}
