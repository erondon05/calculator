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
	public void additionTest() throws Exception {
	
		
	     BigDecimal firstNumber = new BigDecimal("20");
	     BigDecimal secondNumber = new BigDecimal("10");
	     BigDecimal result = firstNumber.add(secondNumber);
	     String operation = "addition";
	     
	        
		Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
		.thenReturn(result);		

		assertEquals(30d, result.doubleValue(), "validating the result obtained");
	}
	
	@Test
	public void subtractionTest() throws Exception {
	
		
	     BigDecimal firstNumber = new BigDecimal("10");
	     BigDecimal secondNumber = new BigDecimal("5");
	     BigDecimal result = firstNumber.subtract(secondNumber);
	     String operation = "subtraction";
	     
	        
		Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
		.thenReturn(result);		

		assertEquals(5d, result.doubleValue(), "validating the result obtained");
	}
	
	
	@Test
	public void multiplicationTest() throws Exception {
	
		
	     BigDecimal firstNumber = new BigDecimal("9");
	     BigDecimal secondNumber = new BigDecimal("3");
	     BigDecimal result = firstNumber.multiply(secondNumber);
	     String operation = "multiplication";
	     
	        
		Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
		.thenReturn(result);		

		assertEquals(27d, result.doubleValue(), "validating the result obtained");
	}
	
	@Test
	public void divisionTest() throws Exception {
	
		
	     BigDecimal firstNumber = new BigDecimal("40");
	     BigDecimal secondNumber = new BigDecimal("10");
	     BigDecimal result = firstNumber.divide(secondNumber);
	     String operation = "division";
	     
	        
		Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
		.thenReturn(result);		

		assertEquals(4d, result.doubleValue(), "validating the result obtained");
	}
	




}
