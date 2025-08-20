import java.util.ArrayList;

abstract class Animal {
	String name;
	
	Animal(String name) { 
		this.name = name; 
	} // 생성자는 내용을 채워서
	
	abstract void eat(); // acstract은 메서드에만
}

interface Flyable {
	void fly();
}

class Eagle extends Animal implements Flyable {
	Eagle(String name) {
		super(name);
	}// Animal에서 생성자를 만들었기 때문에, 
	 // Eagle에서는 기본생성자가 만들어 지지 않는다. 그래서 생성자를 명시해야한다.
	 
	
	@override // 명시적으로 override를 확인 할 수 있도록
	public void eat () {
		System.out.println("독수리가 부리로 쪼아 먹습니다.");
	}
	
	@override 
	public void fly () {
		System.out.println("독수리가 하늘을 높이 납니다.");
	}
}

class Tiger extends Animal {
	Tiger(String name) {
		super(name);
	}
	
	
	public void eat () {
		System.out.println("호랑이가 어흥하며 먹습니다.");
	}
}

public class class_5_7 {
	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Tiger("호랑이")); // 기본 생성자가 없어졌으니, 
		animals.add(new Eagle("독수리")); // 내가 만든 생성자에의해 name을 필수적으로 넣어야한다.
		
		for (Animal animal: animals) {
			animal.eat();
			if (animal instanceof Flyable) {
				((Flyable)animal).fly(); // 현재 Animal타입에서는 fly를 사용할 수
			}  // 없으니(추상메서드에 정의 x) Flyable로 낮추워서 fly 메서드 사용
		}
	}
}