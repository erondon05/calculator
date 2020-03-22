package io.corp.calculator.controllers;



import java.math.BigDecimal;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.corp.calculator.services.CalculatorService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@WebMvcTest(value = CalculatorController.class)
public class CalculatorControllerTest {
	


	
	@MockBean
	private CalculatorController calculatorController;
	
	 protected MockMvc mockMvc;
	 
	 @Autowired
	 private WebApplicationContext webApplicationContext;

		@MockBean
		private CalculatorService calculatorService;
	 
	   @Before
	    public void setUp() {
		   this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		   calculatorService = Mockito.mock(CalculatorService.class);
		   
	    }
	   
	   @Test
	   public void calculatorControllerTest() throws Exception {
			 BigDecimal firstNumber = new BigDecimal("12");
		     BigDecimal secondNumber = new BigDecimal("7");
		     BigDecimal result = firstNumber.add(secondNumber);
		     String operation = "subtraction";
		        String  urlEndopint ="http://localhost:8080"  +"/calculator/calculate?" + "first=" + firstNumber + 
		                "&second=" + secondNumber + "&operation=" + operation;
		        
				Mockito.when(this.calculatorService.calculate(firstNumber, secondNumber, operation))
				.thenReturn(result);

				mockMvc.perform(get(urlEndopint))
		                .andExpect(status().isOk());
				
		}

}
