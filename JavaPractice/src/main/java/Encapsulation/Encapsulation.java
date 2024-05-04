package Encapsulation;

class BankLoan{
	private String name;
	private int age;
	private double amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
public class Encapsulation {

	public static void main(String[] args) {
		BankLoan loan = new BankLoan();
		loan.setName("Arun");
		loan.setAge(20);
		loan.setAmount(500);
		System.out.println(loan.getName()+" age is "+loan.getAge()+" and he bought a loan of $"+loan.getAmount());
	}

}
