package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({LoginWithEmptyCredentialsTest.class, LoginWithValidCredentialsTest.class})
public class LoginTestsSuite {
}

