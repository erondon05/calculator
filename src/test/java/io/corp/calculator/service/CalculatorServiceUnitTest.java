package io.corp.calculator.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;



import io.corp.calculator.services.CalculatorService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;


public class CalculatorServiceUnitTest  {

	@MockBean
	private CalculatorService calculatorService;
	   
	   @Before
	    public void setUp() {
	        calculatorService = Mockito.mock(CalculatorService.class);
	    }

	@Test
	public void calculatorServiceTest() throws Exception {
	
		
	     BigDecimal firstNumber = new BigDecimal("10");
	     BigDecimal secondNumber = new BigDecimal("5");
	     BigDecimal result = firstNumber.subtract(secondNumber);
	     String operation = "subtraction";
	     
	        
		Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
		.thenReturn(result);		

		assertEquals(5d, result.doubleValue(), "validating the result obtained");
	}
	




}
