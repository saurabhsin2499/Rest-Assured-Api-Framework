package apiTestClasses;
import apiTestMehtods.cartsApiMethods;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;




public class DummyCartApiTest  {



    @Test(priority = 1,groups = "Regression")
    public void verifyCartValue1() {
        JSONObject reqPayload = cartsApiMethods.getPayloadForRequestUsingDtaFaker();
        cartsApiMethods.createDummyCartValue("https://reqres.in/api/users", reqPayload);
        System.out.println("Class 1 and Thread " + Thread.currentThread().getId());
    }

    @Test(priority = 2,groups = "Smoke")
    public void verifyCartValue2() {
        JSONObject reqPayload = cartsApiMethods.getPayloadForRequestUsingDtaFaker();
        cartsApiMethods.createDummyCartValue("https://reqres.in/api/users", reqPayload);
        System.out.println("Class 1 and Thread "+ Thread.currentThread().getId());

    }

}
