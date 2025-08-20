abstract class Animal {
	abstract void makeSound();
}

class Dog extends Animal {
 	void makeSound() {
 		System.out.println("멍멍");
 	}
}

class Cat extends Animal {
 	void makeSound() {
 		System.out.println("야옹");
 	}
 	
 	void hi() {
 		System.out.println("안녕");
 	}
}

public class class_5_4 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat(); // 이때 만약 cat을 Cat이 아닌 Animal 객체로 선언하면 hi함수를 부를 수 없다. 
		dog.makeSound();     // 왜냐하면 Animal 추상 클래스에 hi를 정의하지 않았기 때문이다. 
		cat.makeSound();
		cat.hi();
	}
}