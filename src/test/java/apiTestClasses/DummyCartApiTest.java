package apiTestClasses;
import infraSetUp.base;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;




public class DummyCartApiTest extends base {



    @Test
    public void verifyCartValue() {
        JSONObject reqPayload = CartMethods.getPayloadForRequestUsingDtaFaker();
        CartMethods.createDummyCartValue(Data.get("baseURI"), reqPayload);
    }

}
