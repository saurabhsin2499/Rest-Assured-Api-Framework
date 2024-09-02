package utils;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


    public static String loadJSONFile(String filePath) {
        String jsonFilePath = System.getProperty("user.dir" ) + File.separator + "src/test/payloadsForAPI" + File.separator +  filePath;
        String jsonData = null;
        try {
            jsonData = readFileAsString(jsonFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    public static String readFileAsString(String FilePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(FilePath)));
    }
}
