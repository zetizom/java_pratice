interface Calculabe {
	int sum (int a, int b);
}

class SimpleCalculator {
	
	int sum(int a, int b) {
		return a + b;
	}
}

class AdvancedCalculator extends SimpleCalculator {
	
	int sum(int num[]) {
		int sum = 0;
		for(int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		return sum;
	}
}

public class class_5_8 {
	public static void main(String[] args) {
		
		int num[] = {1, 2, 3, 4, 5};
		
		AdvancedCalculator ac = new AdvancedCalculator();
		System.out.println(ac.sum(1, 2));
		System.out.println(ac.sum(num));
	}
}