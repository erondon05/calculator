package io.corp.calculator.services;

import java.math.BigDecimal;



public interface CalculatorService {
	
	/**
	 * Service to calculate arithmetic operations
	 * 
	 * @param first number
	 * @param second number 
	 * @param operation operation  
	 * @return double
	 */
	double calculate(BigDecimal first, BigDecimal second, String operation);
}
