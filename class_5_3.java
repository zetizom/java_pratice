class Calculator {
	int a;
	int b;
	double c;
	double d;
	
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
		System.out.println(calcuator.add(1.2, 2.4));
	}
}