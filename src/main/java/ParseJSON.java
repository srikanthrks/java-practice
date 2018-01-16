import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class ParseJSON {
    //private static final Logger logger = LoggerFactory.getLogger(ParseJSON.class);
    public static void main(String[] args) {
    }

    @Test
    public void testGetNodeNames(){
        try {
            String expected = "[gke-setup-dev45d53-default-pool-ccfb770e-f5r8, "
                    + "gke-setup-dev45d53-default-pool-ccfb770e-fj5q, "
                    + "gke-setup-dev45d53-default-pool-ccfb770e-kr1d, "
                    + "gke-setup-dev45d53-default-pool-ccfb770e-qdgk, "
                    + "gke-setup-dev45d53-default-pool-ccfb770e-rclj]";
            Assert.assertEquals(expected, getNodeNames(getLocalFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLocalFile(){
        try {
            Assert.assertNotNull(getLocalFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * return the value of a JSON field, else returns null
     * @param jsonAsString
     * @return
     */
    private static String getNodeNames(String jsonAsString){

        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        List<String> list = new ArrayList();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonAsString);
            JSONArray jsonArray = (JSONArray) jsonObject.get("items");
            ListIterator<JSONObject> listIterator = jsonArray.listIterator();
            while (listIterator.hasNext()){
                JSONObject metadata = (JSONObject) listIterator.next().get("metadata");
                list.add(metadata.get("name").toString());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list.toString();
    }

    private String getLocalFile() throws IOException {
        //file contains the JSON from kubernetes // kubectl get nodes -o json
        return Files.toString(new File("/Users/srikanthkannan/repos/java-practice/resources/nodes.json"), Charsets.UTF_8);
    }




}
