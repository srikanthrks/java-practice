package objectmapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by srikanth.kannan on 10/26/17.
 */
public class ObjectMapperExample {

    public static void main(String[] args) {
    }

    @Test
    public void validMappingWithoutIgnoredFieldTest(){
        ObjectMapper mapper = new ObjectMapper();
        JsonHttpEvent jsonHttpEvent;
        try {
            String encoded = "{\"topic\":\"inplay_v3\",\"cookies\":{\"_tmpi\":\"adfasdfasdfsdafsafd\",\"_tmid\":\"aaaaaaaaaaa\"}}";
            jsonHttpEvent = mapper.readValue(encoded, JsonHttpEvent.class);
            System.out.println("encoded = " + mapper.writeValueAsString(jsonHttpEvent));
            Assert.assertEquals(mapper.writeValueAsString(jsonHttpEvent), encoded);
        } catch (IOException e) {
            System.out.println(">> exception while parsing" +  e);
        }
    }

    @Test
    public void validMappingWithIgnoredFieldTest(){
        ObjectMapper mapper = new ObjectMapper();
        JsonHttpEvent jsonHttpEvent = null;
        try {
            String encoded = "{\"topic\":\"inplay_v3\","
                    + "\"cookies\":{\"_tmpi\":\"adfasdfasdfsdafsafd\",\"_tmid\":\"aaaaaaaaaaa\"},\"testJsonIgnore\":\"null\"}";
            String expected = "{\"topic\":\"inplay_v3\",\"cookies\":{\"_tmpi\":\"adfasdfasdfsdafsafd\",\"_tmid\":\"aaaaaaaaaaa\"}}";
            jsonHttpEvent = mapper.readValue(encoded, JsonHttpEvent.class);
            System.out.println("encoded = " + mapper.writeValueAsString(jsonHttpEvent));
            Assert.assertEquals(mapper.writeValueAsString(jsonHttpEvent), expected);
        } catch (IOException e) {
            System.out.println(">> exception while parsing " +  e);
        }
    }

    private static class JsonHttpEvent extends BasicHttpEvent {

    }

    private static class BasicHttpEvent {
        private String topic;
        private Map<String,String> cookies = new HashMap<>();

        private  String testJsonIgnore;

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public Map<String, String> getCookies() {
            return cookies;
        }

        public void setCookies(Map<String, String> cookies) {
            this.cookies = cookies;
        }

        /** this will let the JSON String to be mapped to any subclass of BasicHttpEvent to have this field as optional**/
        @JsonIgnore
        public String getTestJsonIgnore() {
            return testJsonIgnore;
        }

        public void setTestJsonIgnore(String testJsonIgnore) {
            this.testJsonIgnore = testJsonIgnore;
        }
    }
}
