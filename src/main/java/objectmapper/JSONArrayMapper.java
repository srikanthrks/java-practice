package objectmapper;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONArrayMapper {
    public static void main(String[] args) {
    }

    @Test
    public void testJSONArrayMapper(){
        TestRun[] testRunArray = null;
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonDump =  "[\n"
                + "  {\n"
                + "    \"testName\": \"test_something\",\n"
                + "    \"builds\": [\n"
                + "      {\n"
                + "        \"source\": {\n"
                + "          \"branch\": \"trunk\",\n"
                + "          \"hash\": \"0200c5eac05aa495caf865a0e9661ec10875bad4\"\n"
                + "        },\n"
                + "        \"builtOn\": \"testbed-0012.example.com\",\n"
                + "        \"duration\": 3258983,\n"
                + "        \"buildNumber\": 270,\n"
                + "        \"result\": \"SUCCESS\",\n"
                + "        \"startTime\": 1391341779000\n"
                + "      },\n"
                + "      {\n"
                + "        \"source\": {\n"
                + "          \"branch\": \"release_1\",\n"
                + "          \"hash\": \"b20890752019c367a6f46425e104a824f3989387\"\n"
                + "        },\n"
                + "        \"builtOn\": \"testbed-0014.example.com\",\n"
                + "        \"duration\": 3224116,\n"
                + "        \"buildNumber\": 271,\n"
                + "        \"result\": \"FAILURE\",\n"
                + "        \"startTime\": 1391425629000\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
                + "  {\n"
                + "    \"testName\": \"test_something_else\",\n"
                + "    \"builds\": [\n"
                + "      {\n"
                + "        \"source\": {\n"
                + "          \"branch\": \"trunk\",\n"
                + "          \"hash\": \"0200c5eac05aa495caf865a0e9661ec10875bad4\"\n"
                + "        },\n"
                + "        \"builtOn\": \"testbed-0013.example.com\",\n"
                + "        \"duration\": 3258983,\n"
                + "        \"buildNumber\": 271,\n"
                + "        \"result\": \"FAILURE\",\n"
                + "        \"startTime\": 1391341779000\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "]";
        try {
            //objectMapper.readValue(jsonDump, JsonNode.class); // using the default
            testRunArray = objectMapper.readValue(jsonDump, TestRun[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(testRunArray[0].builds[0].source.get("hash"), "0200c5eac05aa495caf865a0e9661ec10875bad4");
        Assert.assertEquals(testRunArray[0].builds[1].source.get("hash"), "b20890752019c367a6f46425e104a824f3989387");
    }

    static class TestRun {
        @JsonProperty("testName")
        public String testName;
        @JsonProperty("builds")
        public Build[] builds = new Build[1];

    }
    static class Build{
        @JsonProperty("source")
        public Map<String, String> source;
        @JsonProperty("builtOn")
        public String buildOn;
        @JsonProperty("duration")
        public String duration;
        @JsonProperty("buildNumber")
        public String buildNumbber;
        @JsonProperty("result")
        public String result;
        @JsonProperty("startTime")
        public String startTime;
    }
}
