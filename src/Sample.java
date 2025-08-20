class Calculator {
    int a;
    int b;
    Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    int plus(int a, int b) {
        return a + b;
    }

    int minus(int a, int b) {
        return a - b;
    }
}


public class Sample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10, 5);
        System.out.println(calculator.plus(10, 5));
        System.out.println(calculator.minus(10, 5));
    }
}
