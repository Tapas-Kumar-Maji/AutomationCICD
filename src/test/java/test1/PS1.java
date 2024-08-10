package test1;

import org.testng.annotations.Test;

public class PS1 extends PS {

	@Test
	public void alto() {
		this.car();

//		only one time value passed, and only one object os created.
		PS2 obj = new PS2(3);
		System.out.println(obj.increment());
		System.out.println(obj.decrement());

		System.out.println(obj.multiplyByThree());
		System.out.println(obj.divideByThree());
	}
}
