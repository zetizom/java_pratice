interface Calculable {
	int sum (int a, int b); // 인터페이스의 역할은 최소한 이 기능을 가지고 있다!
}                        	// 상속 받은 아이들도!!!

class SimpleCalculator implements Calculable{
	
	public int sum(int a, int b) { // 추상메서드 사용 시 public 필수!!!
		return a + b;
	}
}

class AdvancedCalculator extends SimpleCalculator implements Calculable{
	
	public int sum(int num[]) {
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