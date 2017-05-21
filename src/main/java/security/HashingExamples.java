package security;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by srikanth.kannan on 7/15/16.
 */
public class HashingExamples {

    private static final ThreadLocal<MessageDigest> md5Hash = new ThreadLocal() {
        protected MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException var2) {
                throw new RuntimeException("Failed to generate MessageDigest.", var2);
            }
        }
    };

    public static void main(String args[]){

        HashingExamples hashingExamples = new HashingExamples();
        Scanner scanner = new Scanner(System.in);
        String inp;
        System.out.println("Enter a string to hash using MD5. Type \"exit\" to quit ");
        while(true){
            inp = scanner.next();
            if("exit".equalsIgnoreCase(inp)){
                break;
            }
            System.out.println("MD5 hash of " + inp + " = " + hashingExamples.generateMD5Hash(inp));
        }
        scanner.close();
    }

    public String generateMD5Hash(String data) {
        byte[] byteData = data.getBytes();
        byte[] hashOut = md5Hash.get().digest(byteData);
        System.out.println("hashOut = " + hashOut);
        byte[] byte15Hash = Arrays.copyOf(hashOut, 15);
        String charHash =  Base64.encode(byte15Hash);
        return charHash;
    }
}
