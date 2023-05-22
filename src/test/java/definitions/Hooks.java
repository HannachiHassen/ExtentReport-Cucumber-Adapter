package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.HelperClass;

public class Hooks {

	@Before
	public void setUp() {
		HelperClass.setUpDriver();
	}
	
	@After
	public static void tearDown() {
		HelperClass.tearDown();
	}
}