package io.corp.calculator.util;

import java.math.BigDecimal;

public interface Operation {
	BigDecimal  calculate(BigDecimal   numberOne, BigDecimal   numberTwo);
}
