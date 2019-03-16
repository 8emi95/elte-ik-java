import java.util.ArrayList;
import java.util.List;

import test.*;
import szallitas.*;

public class SzallitasTeszt {

	public static void main(String[] args) {
		List<Test> tests = new ArrayList<Test>();
		tests.add(new Test2());
		tests.add(new Test3());
		tests.add(new Test4());
		tests.add(new Test5());
		int mark = 1;
		for (Test test : tests) {
			if (test.test()) {
				++mark;
			}
		}
		System.out.println("A jegyed valoszinuleg: " + mark);
	}

}