# Calculator
micro service based on spring boot that through given numbers can obtain the addition, subtraction, multiplication or division of a number
 to execute `mvn clean install` 


## API REST

the endpoint must receive as a parameter a first number plus a second number to perform the operation 
accepted `addition`,` subtraction`, `multiplication`,` division`

`GET http://localhost:8080/calculator/calculate?first=5&second=20&operation=addition`
result 5 + 20 = 25

 `25`

## JAVA8
	/**
	 * Expresión lambda  to Subtraction
	 * @return double
	 */
	private Operation Subtraction() {
		return (double  x, double  y) -> (x -y);
	} 

