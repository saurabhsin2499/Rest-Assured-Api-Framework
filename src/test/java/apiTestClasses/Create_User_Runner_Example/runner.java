package apiTestClasses.Create_User_Runner_Example;

import org.testng.TestNG;

import java.util.Collections;

public class runner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(Collections.singletonList("Testng/createUserTestng.xml"));

        int numberOfRuns = 20; // specify the number of times you want to run the suite
        for (int i = 0; i < numberOfRuns; i++) {
            System.out.println("Run #" + (i + 1));
            testng.run();
        }
    }
}
