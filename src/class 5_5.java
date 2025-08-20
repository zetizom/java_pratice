interface Flyable {
	void fly();
	defult void takeOff() {
		System.out.println("이륙합니다.");
	}
}

class Bird implements Flyable {
	void fly() {
		System.out.println("새가 하늘을 납니다.");
	}
}

class class 5_5 {
	public static void main(String[] args) {
		Bird bird = new Bird();
		bird.takeOff();
		bird.fly();
	}
}