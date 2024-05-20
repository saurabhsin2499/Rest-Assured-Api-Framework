package infraSetUp;

import utils.jsonUtils;

import java.io.IOException;
import java.util.Map;

public class base {

    protected static Map<String , String> Data;

    static {
        String envFileName = System.getProperty("env") == null ? "env.json":"env.json";
        try {
            Data = jsonUtils.getJsonFileData(envFileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
