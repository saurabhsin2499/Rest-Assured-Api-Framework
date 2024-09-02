package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.json.simple.JSONObject;
import reporting.ExtentReportUtils;

import java.util.Map;
import static io.restassured.RestAssured.given;

public class restUtils {


    private static RequestSpecification requestSpecification (String endPoints, Object payload, Map<String, String> header){
                RequestSpecification requestSpecification =  given()
                .baseUri(endPoints)
                .headers(header)
                .contentType(ContentType.JSON)
                .body(payload);
        return requestSpecification;
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification   = SpecificationQuerier.query(requestSpecification);
        ExtentReportUtils.logNewAPICALLDetails("============================================ NEW API CALL =============================================================");
        ExtentReportUtils.logInfoDetails(queryableRequestSpecification.getBaseUri());
        ExtentReportUtils.logInfoDetails("Body or Payload");
        ExtentReportUtils.logJSON(queryableRequestSpecification.getBody());
        ExtentReportUtils.logInfoDetails("Method "+queryableRequestSpecification.getMethod());
        ExtentReportUtils.logInfoDetails("Header");
        ExtentReportUtils.logHeader(queryableRequestSpecification.getHeaders().asList());

    }

    private static void printResponseLogInReport(Response response){
        ExtentReportUtils.logInfoDetails("Status code "+ response.getStatusCode());
        ExtentReportUtils.logInfoDetails("Response Body");
        ExtentReportUtils.logJSON(response.getBody().prettyPrint());
    }

    public static Response PostMethod(String endPoints, JSONObject payload, Map<String, String> header){
        RequestSpecification request = requestSpecification(endPoints,payload,header);
        Response response = request.when().post();
        printRequestLogInReport(request);
        printResponseLogInReport(response);
        return response;
    }

    public static Response PostMethod(String endPoints, String payload, Map<String, String> header){
        RequestSpecification request = requestSpecification(endPoints,payload,header);
        return request
                .when()
                .post()
                .then()
                .extract().response();

    }

    public static String getAlphaNumericString(int n)
    {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
