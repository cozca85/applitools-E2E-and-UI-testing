package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cases.TraditionalTests;
import cases.TraditionalTestsVersionTwo;
import cases.VisualAITests;

@RunWith(Suite.class)
@SuiteClasses({
	TraditionalTests.class,
	TraditionalTestsVersionTwo.class,
	VisualAITests.class
})
public class AllTests {

}
