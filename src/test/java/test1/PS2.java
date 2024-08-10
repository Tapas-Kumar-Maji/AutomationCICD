package test1;

public class PS2 extends PS3 {

	int a;

	public PS2(int a) {
		super(a);
		this.a = a;
	}

	public int increment() {
		return ++a;
	}

	public int decrement() {
		return --a;
	}
}
