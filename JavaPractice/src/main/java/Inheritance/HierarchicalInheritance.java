package Inheritance;
class car{
	public void run() {
		System.out.println("I am running");
	}
}
class BMW extends car{
	public void company() {
		System.out.println("I am a BMW car");
	}
}
class Ford extends car{
	public void company() {
		System.out.println("I am a Ford car");
	}
}
public class HierarchicalInheritance {
	public static void main (String[] args) {
		BMW mybmw = new BMW();
		mybmw.company();
		mybmw.run();
		
		Ford myford = new Ford();
		myford.company();
		mybmw.run();
	}
}
