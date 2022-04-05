package com.rag;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*3.2. JUnit Jupiter
This module includes new programming and extension models for writing tests in JUnit 5. 
New annotations in comparison to JUnit 4 are:


freestar
@TestFactory – denotes a method that's a test factory for dynamic tests
@DisplayName – defines a custom display name for a test class or a test method
@Nested – denotes that the annotated class is a nested, non-static test class
@Tag – declares tags for filtering tests
@ExtendWith – registers custom extensions
@BeforeEach – denotes that the annotated method will be executed before each test method (previously @Before)
@AfterEach – denotes that the annotated method will be executed after each test method (previously @After)
@BeforeAll – denotes that the annotated method will be executed before all test methods in the current class (previously @BeforeClass)
@AfterAll – denotes that the annotated method will be executed after all test methods in the current class (previously @AfterClass)
@Disable – disables a test class or method (previously @Ignore)*/

//@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitInfo {

	@Test
	public void test() {
		
	}
}
