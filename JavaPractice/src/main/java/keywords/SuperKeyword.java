package keywords;

class parentClass{
	String classname="Parent Class variable";
	parentClass(){
		System.out.println("I am a Parent Class constructor");
	}
	public void name() {
		System.out.println("I am from Parent Class");
	}
}

class childClass extends parentClass{
	String classname="Child Class variable";
	childClass(){
		super(); //if we didn't mention then also parent class constructor will be called
		System.out.println("I am a Child Class constructor");
	}
	public void name() {
		System.out.println("I am from child Class");
	}
	public void printNames() {
		//Super Keyword - Variable
		System.out.println(super.classname);
		System.out.println(classname);
		
		//Super Keyword - Method
		super.name();
		name();
	}
}

public class SuperKeyword {
	public static void main (String[] args) {
		childClass c1= new childClass();
		c1.printNames();
	}
}
