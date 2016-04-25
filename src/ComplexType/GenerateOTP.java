
package ComplexType;

import java.security.SecureRandom;

public class GenerateOTP {
    public static String OTP(){
        String alpha = "qwertyuiopasdfghjklzxcvbnm1234567890";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(5);
        for( int i=0;i<5;i++)
            sb.append(alpha.charAt(rnd.nextInt(alpha.length())));
        return sb.toString();
    }
}
