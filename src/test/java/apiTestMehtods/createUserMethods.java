package apiTestMehtods;

import com.jayway.jsonpath.JsonPath;
import utils.RandomDataGenerator;
import utils.jsonUtils;


public class createUserMethods extends RandomDataGenerator {


    private static jsonUtils jsonUtils = new jsonUtils();


    public static String getPayloadForSendOtpRequest(String mobileNumber) {
        return JsonPath.parse(jsonUtils.loadJSONFile("POST_sendotp_request.json")).set("$.countryCode", "+91")
                .set("$.mobileNumber", mobileNumber)
                .jsonString();
    }

    public static String getPayloadForNameAndEmailRequest(String registerToken) {
        String email = getRandomEmail();
        String Name = getRandomFullName();
        return JsonPath.parse(jsonUtils.loadJSONFile("POST_name_email.json"))
                .set("$.firstName", Name)
                .set("$.email", email)
                .set("$.registerToken", registerToken)
                .jsonString();

    }

    public static String getPayloadForVerifyOtpRequest(String mobileNumber) {
        String opt = getOtp(mobileNumber);
        return JsonPath.parse(jsonUtils.loadJSONFile("POST_verifyOTP.json"))
                .set("$.mobileNumber", mobileNumber)
                .set("$.otp", opt)
                .jsonString();
    }


    public static String getOtp(String mobileNumber) {
        return mobileNumber.substring(6, 10);

    }
}
