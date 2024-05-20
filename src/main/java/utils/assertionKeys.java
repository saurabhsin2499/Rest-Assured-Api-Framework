package utils;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class assertionKeys {
    private  String jsonpath;
    private Object expectedValue;
    private String actualValue;
    private String assertionResult;

    public assertionKeys(String jsonpath, Object o, Object value, String result) {
        this.jsonpath = jsonpath;
        this.expectedValue = o;
        this.actualValue = (String) value;
        this.assertionResult = result;
    }

    public String getJsonpath() {
        return jsonpath;
    }

    public String getActualValue() {
        return actualValue;
    }

    public String getAssertionResult() {
        return assertionResult;
    }

    public Object getExpectedValue() {
        return expectedValue;
    }
}
