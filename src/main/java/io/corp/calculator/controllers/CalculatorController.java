package io.corp.calculator.controllers;



import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.corp.calculator.services.CalculatorService;
/**
 * <b>.</b><br>
 * <b><br>
 * <b>Arithmetic calculations </b><br>
 * <p>
 * </p>
 * 
 * @author erondon (1.0)
 * @version 1.0
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	/**
	 * Default.
	 */
	public CalculatorController() {
		super();

	}
	
	@Autowired
    private CalculatorService calculatorService; 
    
	/**
	 * 
	 * @param first number
	 * @param second number 
	 * @param operation operation  
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/calculate")
    public ResponseEntity<BigDecimal> calcula(@RequestParam(name = "first") BigDecimal first,
            @RequestParam(name = "second") BigDecimal second,
            @RequestParam(name = "operation") String operation) {
		BigDecimal result = this.calculatorService.calculate(first, second, operation);
     
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	

}
