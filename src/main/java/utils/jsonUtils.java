package utils;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class jsonUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();
    public static Map<String, String> getJsonFileData(String envJsonFilePath) throws IOException {
        Map<String, String> apiRelatedData  = new HashMap<>();
        String completeFilePAth =  System.getProperty("user.dir")+ "/src/test/resource/"+ envJsonFilePath;
        apiRelatedData = objectMapper.readValue(new File(completeFilePAth), new TypeReference<>() {});
        return  apiRelatedData;
    }
}
