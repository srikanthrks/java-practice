package security;

/**
 * Created by srikanth.kannan on 6/9/16.
 */
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Base64EncodeSalt {

    private static Random rand = new Random((new Date()).getTime());
    private static BASE64Encoder base64Encoder = new BASE64Encoder();

    public static void main(String[] args) throws Exception {

        String st = "HelloWorld";

        String enc = encrypt(st);

        System.out.println("Encrypted string :" + enc);

        System.out.println("Decrypted string :" + decrypt(enc));
        System.out.println("Enter a string to base64encode. Type exit or quit to quit");
        Scanner scanner = new Scanner(System.in);
        String inputStr = null;
        while(!(inputStr = scanner.next()).equalsIgnoreCase("exit")){
            System.out.println("base64encoding : " +
                    base64Encoder.encode(inputStr.getBytes()));
        }
    }

    public static String encrypt(String str) {

        BASE64Encoder encoder = new BASE64Encoder();

        byte[] salt = new byte[8];
        //salt = "USN6P2Z0".getBytes();

        rand.nextBytes(salt);

        return encoder.encode(salt) + encoder.encode(str.getBytes());

    }

    public static String decrypt(String encstr) {

        if (encstr.length() > 12) {

            String cipher = encstr.substring(12);
            System.out.println("cipher = " + cipher);

            BASE64Decoder decoder = new BASE64Decoder();

            try {

                return new String(decoder.decodeBuffer(cipher));

            } catch (IOException e) {

                //  throw new InvalidImplementationException(

                //Fail

            }

        }

        return null;
    }
}
