package utils;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import reporting.ExtentReportUtils;
import java.util.*;
import static reporting.setUp.extentTest;

public class assertionUtils {

    public static void assertValueWithJsonPath(Response actualResponse, Map<String ,Object> expectedValue) {
        List<assertionKeys> actualValueMap = new ArrayList<>();
        //Add Header
        actualValueMap.add(new assertionKeys("JSONPATH","EXPECTED_VALUE","ACTUAL_VALUE","RESULTS"));
        boolean allMatched = true;
        Set<String> jsonPaths = expectedValue.keySet();
        for(String jsonpath: jsonPaths){
            Optional<Object> actualValue = Optional.ofNullable(actualResponse.jsonPath().get(jsonpath));
            if(actualValue.isPresent()){
                Object value = actualValue.get();
                if(value.equals(expectedValue.get(jsonpath))){
                    System.out.println(jsonpath+"=="+expectedValue.get(jsonpath)+"=="+value);
                    actualValueMap.add(new assertionKeys(jsonpath,expectedValue.get(jsonpath),value,"Matched"));
                }
                else{
                    allMatched=false;
                    actualValueMap.add(new assertionKeys(jsonpath,expectedValue.get(jsonpath),value,"Not_Matched"));
                }
            }
            else{
                allMatched=false;
                actualValueMap.add(new assertionKeys(jsonpath,expectedValue.get(jsonpath),"VALUE_NOT_FOUND","Not_Matched"));
            }
        }
        if(allMatched){
            ExtentReportUtils.logPassDetails("All Assertion Passed");
        }
        else{
            ExtentReportUtils.logFailureDetails("Some Assertion Failed") ;
        }
        System.out.println(actualValueMap);
        String[][] result = actualValueMap.stream().map(assertionKeys-> new String[] {assertionKeys.getJsonpath(),  (String) assertionKeys.getExpectedValue(),assertionKeys.getActualValue(),assertionKeys.getAssertionResult()}).toArray(String[][] :: new);
        extentTest.get().info(MarkupHelper.createTable(result));


    }
}
