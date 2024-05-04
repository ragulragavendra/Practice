package polymorphism;

class Calculation {
	public void add(int a, int b) {
		System.out.println("Result : "+ (a+b));
	}
	public void add(int a, int b, int c) {
		System.out.println("Result : "+ (a+b+c));
	}
	public void add(double a, double b) {
		System.out.println("Result : "+ (a+b));
	}
}
public class Compile_MethodOverloading {
	public static void main(String[] args) {
		Calculation calc= new Calculation();
		calc.add(2,4);
		calc.add(2,4,5);
		calc.add(5.2, 5.2);
	}
}
