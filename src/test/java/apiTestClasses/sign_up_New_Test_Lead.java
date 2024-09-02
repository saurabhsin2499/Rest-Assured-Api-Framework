package apiTestClasses;
import apiTestMehtods.createUserMethods;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import sevices.admitkard;

import static utils.RandomDataGenerator.*;

public class sign_up_New_Test_Lead  {

    private admitkard ak = new admitkard();


    @Test(priority = 1,description = "Testcase for checking create user through pre-login",groups="Re gression")
    /*
    1. POST request for send otp.
    2. POST request to insert otp and save register token
    3. POST request to insert name and email.
    4. Verify date created properly in DB
     */
    public void createUserTestScenario() {

        //POST request for send otp
        //Generate payload
        Response response = null;
        String mobileNumber = getRandomTestingPhoneNumber();
        String reqPayload = createUserMethods.getPayloadForSendOtpRequest(mobileNumber);

        //POST /sendOTP
        try {
             response = ak.sendOTP(reqPayload);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Asset Value
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK,"Status code not matched");

        //Generate Payload for verifyOTP
        String reqPayloadForVerifyOTP = createUserMethods.getPayloadForVerifyOtpRequest(mobileNumber);

        //POST // verifyOTP
        try {
            response = ak.verifyOTP(reqPayloadForVerifyOTP);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Asset values
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

        //Save register Token
        String registerToken = JsonPath.parse(response.asString()).read("registerToken");

        //verify Name and email
        //Generate Payload
        String reqPayloadForFullNameANDEmail = createUserMethods.getPayloadForNameAndEmailRequest(registerToken);

        //POST /email/
        try {
            response = ak.verifyNameAndEmail(reqPayloadForFullNameANDEmail);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Asset Values
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK,"Status code not matched");

    }


}
