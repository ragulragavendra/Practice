package abstraction;

abstract class shape{
	abstract public void displayShape();
	public void display() {
		System.out.println("I am from Shape class");
	}
}
class circle extends shape{
	public void displayShape() {
		System.out.println("I am circle");
	}
}
public class abstractClass {
	public static void main(String[] args) {
		circle c=new circle();
		c.display ();
		c.displayShape();
	}
}
