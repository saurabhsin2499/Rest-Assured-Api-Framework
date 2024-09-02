package sevices;

import io.restassured.response.Response;
import utils.restUtils;

import java.util.HashMap;

public class admitkard {

    static  String baseURI = "https://auth.admitkard.com";
    static String sendOTP = "/sendotp";
    static String verifyOTP = "/verifyotp";
    static String register = "/register";

    public  Response sendOTP(String reqPayload){
        String url = baseURI  + sendOTP;
        return restUtils.PostMethod(url, reqPayload, new HashMap<String, String>());
    }

    public  Response verifyOTP(String reqPayload){
        String url = baseURI  + verifyOTP;
        return restUtils.PostMethod(url, reqPayload, new HashMap<String, String>());
    }

    public  Response verifyNameAndEmail(String reqPayload){
        String url = baseURI  + register;
        return restUtils.PostMethod(url, reqPayload, new HashMap<String, String>());
    }
}
