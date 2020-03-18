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
	public double calculate(BigDecimal first, BigDecimal second, String operation) {
		Operation operacion = null;
		double result = 0;
		try {
			
			   switch (operation) {
	            case CalculatorConstants.ADDITION:
	            	
	            	 operacion = addition();
	            	 return result =  operacion.calculate(first.doubleValue(), second.doubleValue());
	              
	            case CalculatorConstants.SUBTRACTION:
	            	
	            	 operacion = Subtraction();
	            	 return result = operacion.calculate(first.doubleValue(), second.doubleValue());
	          
	            case CalculatorConstants.MILTIPLICATION:
	            	 operacion = multiply();
	            	 return result = operacion.calculate(first.doubleValue(), second.doubleValue());
	                
	            case CalculatorConstants.DIVISION:	            	
	            	 operacion = division();
	            	 return result = operacion.calculate(first.doubleValue(), second.doubleValue());
	               
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
		return (double  x, double  y) -> (x + y);
	} 
	
	/**
	 * Expresión lambda  to Subtraction
	 * @return double
	 */
	private Operation Subtraction() {
		return (double  x, double  y) -> (x -y);
	} 

	/**
	 * Expresión lambda  to multiply
	 * @return double
	 */
	private Operation multiply() {
		return (double  x, double  y) -> (x *y);
	} 
	
	/**
	 * Expresión lambda  to division
	 * @return double
	 */
	private Operation division() {
		return (double  x, double  y) -> (x /y);
	} 


}
