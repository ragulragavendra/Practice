package polymorphism;
class Bank{
	public void interest() {
		System.out.println("2% Interest");
	}
}
class IndianBank extends Bank{
	public void interest() {
		System.out.println("5% Interest");
	}
}
public class Runtime_MethodOverriding {
	public static void main (String[] args) {
		IndianBank mybank = new IndianBank();
		mybank.interest();
	}
}
