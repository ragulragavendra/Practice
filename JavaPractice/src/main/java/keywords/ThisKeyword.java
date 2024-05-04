package keywords;

class Student{
	int rollNo;
	String Name;
	
	Student(int rollNo, String Name){
		this.rollNo=rollNo;
		this.Name=Name;
	}
	public void display() {
		System.out.println("Name: "+Name+" Roll No: "+rollNo);
	}
}
public class ThisKeyword {
	public static void main(String[] args) {
		Student s1= new Student(123,"Ragul");
		Student s2= new Student(456,"Arun");
		
		s1.display();
		s2.display();
	}
}
