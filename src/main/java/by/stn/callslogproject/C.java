package by.stn.callslogproject;

public class C {
	public static void main(String[] args) {
		B b = new B();
		A a = new A();
//		a.go();
		a = b;


//		b.stop();
		a.go();
		((B) a).stop();
	}
}
