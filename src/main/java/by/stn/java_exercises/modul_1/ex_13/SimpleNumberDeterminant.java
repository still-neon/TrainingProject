package java_exercises.modul_1.ex_13;

public class SimpleNumberDeterminant {
	public static void main(String[] args) {
		int num = 7;
		int d = 1;
		int count = 0;
				
		while(d < num) {
			if(num % d == 0) {
				count++;
				if(count == 2)
					break;
			}
			d++;
		}
		
		if(count == 1)
			System.out.println("����� " + num + " �������");
		else 
			System.out.println("����� " + num + " �� �������� �������");
	}
}