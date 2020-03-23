package io.corp.calculator;



import java.math.BigDecimal;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import io.corp.calculator.controllers.CalculatorController;
import io.corp.calculator.services.CalculatorService;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplicationTests.class)
public class CalculatorApplicationTests {

	@MockBean
	private CalculatorController calculatorController;
	

	
	 protected MockMvc mockMvc;
	 
	 @Autowired
	 private WebApplicationContext webApplicationContext;

		@MockBean
		private CalculatorService calculatorService;
	 
	   @Before
	    public void setUp() {
		   mockMvc = MockMvcBuilders
			        .webAppContextSetup(webApplicationContext)
			        .build();
		   calculatorService = Mockito.mock(CalculatorService.class);
		   calculatorController = new CalculatorController(calculatorService);
		   
	    }
	   
	   @Test
	   public void additionTest() throws Exception {
		    BigDecimal firstNumber = new BigDecimal("5");
	        BigDecimal secondNumber = new BigDecimal("20");
		     BigDecimal resultp = firstNumber.add(secondNumber);
		     String operation = "addition";
		        
		        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		        		requestParams.add("first", firstNumber.toString());
		        		requestParams.add("second", secondNumber.toString());
		        		requestParams.add("operation", operation);

	
		        
				Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
				.thenReturn(resultp);
				
								
				// when
				ResultActions result = mockMvc.perform(get("/calculator/calculate").params(requestParams));
				        

			    assertAll(
		                () -> result.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value())),
		                () -> assertEquals(25d, resultp.doubleValue(), "validating the result obtained")
		                );
				
				
		}
	   
	   
	   @Test
	   public void subtractionTest() throws Exception {
		      BigDecimal firstNumber = new BigDecimal("30");
		        BigDecimal secondNumber = new BigDecimal("10");
		     BigDecimal resultp = firstNumber.subtract(secondNumber);
		     String operation = "subtraction";
		        
		        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		        		requestParams.add("first", firstNumber.toString());
		        		requestParams.add("second", secondNumber.toString());
		        		requestParams.add("operation", operation);

	
		        
				Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
				.thenReturn(resultp);
				
								
				// when
				ResultActions result = mockMvc.perform(get("/calculator/calculate").params(requestParams));
				        

			    assertAll(
		                () -> result.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value())),
		                () -> assertEquals(20d, resultp.doubleValue(), "validating the result obtained")
		                );
				
				
		}
	   
	   
	   @Test
	   public void multiplicationTest() throws Exception {
		      BigDecimal firstNumber = new BigDecimal("8");
		        BigDecimal secondNumber = new BigDecimal("5");
		     BigDecimal resultp = firstNumber.multiply(secondNumber);
		     String operation = "multiplication";
		        
		        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		        		requestParams.add("first", firstNumber.toString());
		        		requestParams.add("second", secondNumber.toString());
		        		requestParams.add("operation", operation);

	
		        
				Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
				.thenReturn(resultp);
				
								
				// when
				ResultActions result = mockMvc.perform(get("/calculator/calculate").params(requestParams));
				        

			    assertAll(
		                () -> result.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value())),
		                () -> assertEquals(40d, resultp.doubleValue(), "validating the result obtained")
		                );
				
				
		}
	  
	    
	   @Test
	   public void divisionTest() throws Exception {
	        BigDecimal firstNumber = new BigDecimal("50");
	        BigDecimal secondNumber = new BigDecimal("5");
		     BigDecimal resultp = firstNumber.divide(secondNumber);
		     String operation = "division";
		        
		        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		        		requestParams.add("first", firstNumber.toString());
		        		requestParams.add("second", secondNumber.toString());
		        		requestParams.add("operation", operation);

	
		        
				Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
				.thenReturn(resultp);
				
								
				// when
				ResultActions result = mockMvc.perform(get("/calculator/calculate").params(requestParams));
				        

			    assertAll(
		                () -> result.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value())),
		                () -> assertEquals(10d, resultp.doubleValue(), "validating the result obtained")
		                );
				
				
		}




}
