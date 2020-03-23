package io.corp.calculator.controllers;



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

import io.corp.calculator.services.CalculatorService;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorControllerTest.class)
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
		   mockMvc = MockMvcBuilders
			        .webAppContextSetup(webApplicationContext)
			        .build();
		   calculatorService = Mockito.mock(CalculatorService.class);
		   calculatorController = new CalculatorController(calculatorService);
		   
	    }
	   
	   @Test
	   public void calculatorControllerTest() throws Exception {
			 BigDecimal firstNumber = new BigDecimal("12");
		     BigDecimal secondNumber = new BigDecimal("7");
		     String operation = "addition";
		        
		        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		        		requestParams.add("first", firstNumber.toString());
		        		requestParams.add("second", secondNumber.toString());
		        		requestParams.add("operation", operation);


						
					    // when
						ResultActions result = mockMvc.perform(
				                get("/calculator/calculate")
				                .params(requestParams));
				        
				   
	
				result.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
				
				
		}

}
