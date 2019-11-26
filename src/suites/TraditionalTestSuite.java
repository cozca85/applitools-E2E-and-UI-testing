package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cases.TraditionalTests;
import cases.TraditionalTestsVersionTwo;

@RunWith(Suite.class)
@SuiteClasses({ TraditionalTests.class,
	TraditionalTestsVersionTwo.class
	})
public class TraditionalTestSuite {

}
