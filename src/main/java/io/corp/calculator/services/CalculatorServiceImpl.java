package io.corp.calculator.services;



import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import io.corp.calculator.TracerImpl;
import io.corp.calculator.constants.CalculatorConstants;
import io.corp.calculator.util.Operation;

@Service
public class CalculatorServiceImpl implements CalculatorService {
	/**
	 * Logger de log42
	 */
	private static final Logger LOGGER = LogManager.getLogger(CalculatorServiceImpl.class);
	

	private TracerImpl tracer = new TracerImpl();
	

	@Override
	public BigDecimal calculate(BigDecimal first, BigDecimal second, String operation) {
		Operation operacion = null;
		BigDecimal result = null;
		try {
			
			   switch (operation) {
	            case CalculatorConstants.ADDITION:
	            	
	            	 operacion = addition();
	            	 return result =  operacion.calculate(first, second);
	              
	            case CalculatorConstants.SUBTRACTION:
	            	
	            	 operacion = Subtraction();
	            	 return result = operacion.calculate(first, second);
	          
	            case CalculatorConstants.MILTIPLICATION:
	            	 operacion = multiply();
	            	 return result = operacion.calculate(first, second);
	                
	            case CalculatorConstants.DIVISION:	            	
	            	 operacion = division();
	            	 return result = operacion.calculate(first, second);
	               
	            default:		            	
	  			  tracer.trace(result);

	        }	
		
			

		} catch (Exception e) {
			
			LOGGER.error(CalculatorConstants.ERROR_MSG, e);
			  tracer.trace(result);
		
		}
		return result;

	
	}


	/**
	 * Expresión lambda  to addition
	 * @return double
	 */
	private Operation addition() {
		return (BigDecimal x, BigDecimal y) -> (x.add(y));
	} 
	
	/**
	 * Expresión lambda  to Subtraction
	 * @return double
	 */
	private Operation Subtraction() {
		return (BigDecimal  x, BigDecimal  y) -> (x.subtract(y));
	} 

	/**
	 * Expresión lambda  to multiply
	 * @return double
	 */
	private Operation multiply() {
		return (BigDecimal  x, BigDecimal  y) -> (x.multiply(y));
	} 
	
	/**
	 * Expresión lambda  to division
	 * @return double
	 */
	private Operation division() {
		return (BigDecimal  x, BigDecimal  y) -> (x.divide(y));
	} 


}
