class Calculator {
	
	int add(int a, int b) {
		return a + b;
	}
	
	double add(double c, double d) {
		return c + d;
	}
}

public class class_5_3 {
	public static void main(String[] args) {
		Calculator calcuator = new Calculator();
		System.out.println(calcuator.add(1, 2));
		double result = calcuator.add(1.2, 2.4);
		System.out.printf("%.1f", result);
	}
}