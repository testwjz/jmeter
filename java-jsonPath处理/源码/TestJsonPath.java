import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class TestJsonPath {

    private final DocumentContext ext;

    TestJsonPath(String jsonStr) {
        this.ext = JsonPath.parse(jsonStr);
    }

    public String updateValue(String jsonComplie, Object contextValue) {
        JsonPath p = JsonPath.compile(jsonComplie);
        this.ext.set(p, contextValue);
        return this.ext.jsonString();
    }

    public String updateJSONString(String jsonComplie, String contextValue) {
        JSONObject jsonObject = JSON.parseObject(contextValue);
        JsonPath p = JsonPath.compile(jsonComplie);
        this.ext.set(p, jsonObject);
        return this.ext.jsonString();
    }

    public String deleteValue(String jsonComplie) {
        JsonPath p = JsonPath.compile(jsonComplie);
        this.ext.delete(p);
        return this.ext.jsonString();
    }

    public String addJSONString(String jsonComplie, String contextValue) {
        JSONObject jsonObject = JSON.parseObject(contextValue);
        JsonPath p = JsonPath.compile(jsonComplie);
        this.ext.add(p, jsonObject);
        return this.ext.jsonString();
    }
}
