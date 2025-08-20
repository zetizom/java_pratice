class Person {
	String name;
	
	Person(String name) {
		this.name = name;
	}
	
	void introduce() {
		System.out.println("내 이름은 " + name + "입니다.");
	}
}

class Employee extends Person {
	String jobTitle;
	
	Employee (String name, String jobTitle) {
		super(name);
		this.jobTitle = jobTile;
	}
	
	void introduce() {
		super.introduce();
		System.out.println("내 직급은 " + jobTitle + "입니다.");
	}
}

public class class_5_6 {
	public static void main(String[] args) {
		Employee employee = new Employee("서형완", "인턴");
		employee.introduce();
	}
}