package keywords;

class CounterClass{
	int i=0;
	static int j=0;
	public CounterClass(){
		i++;
		j++;
		System.out.println("i :"+i +"  j :"+j);
	}
}
public class StaticKeyword {

	public static void main(String[] args) {
		CounterClass C1 = new CounterClass();
		CounterClass C2 = new CounterClass();
		CounterClass C3 = new CounterClass();
	}

}
