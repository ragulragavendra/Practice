package abstraction;

interface UniversityDetails{
	public static final String University ="SASTRA";
	public void NoOfDepartments();
	public void NoOfStudents();
}
class Sastra implements UniversityDetails{

	public void NoOfDepartments() {
		System.out.println("We had 12 department");
	}
	public void NoOfStudents() {
		System.out.println("We had 500+ students");
	}
}
public class interfaceClass{
	public static void main(String[] args) {
		Sastra univ = new Sastra();
		univ.NoOfDepartments();
		univ.NoOfStudents();
	}
}
