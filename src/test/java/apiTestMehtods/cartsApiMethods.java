package apiTestMehtods;
import io.restassured.response.Response;

import org.json.simple.JSONObject;
import utils.RandomDataGenerator;
import utils.restUtils;

import java.util.HashMap;
import java.util.Map;


import static utils.assertionUtils.assertValueWithJsonPath;

public class cartsApiMethods extends RandomDataGenerator {

    public static JSONObject getPayloadForRequest(){
        JSONObject payload = new JSONObject();
        String name = restUtils.getAlphaNumericString(6);
        String job = restUtils.getAlphaNumericString(3);
        payload.put("name",name);
        payload.put("job",job);
        return payload;
    }

    public static JSONObject getPayloadForRequestUsingDtaFaker(){
        JSONObject payload = new JSONObject();
        String name = getRandomFirstName();
        String job = getRandomJobRole();
        payload.put("name",name);
        payload.put("job",job);
        return payload;
    }

    public static void createDummyCartValue(String api, JSONObject reqPayload){
        Response res = restUtils.PostMethod(api, reqPayload, new HashMap<String, String>());
        Map<String, Object> expectedValue = new HashMap<>();
        expectedValue.put("name",reqPayload.get("name"));
        expectedValue.put("job",reqPayload.get("job"));
        assertValueWithJsonPath(res,expectedValue);

    }
}
