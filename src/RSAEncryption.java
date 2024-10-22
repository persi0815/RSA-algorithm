import javax.crypto.Cipher;
import java.security.PublicKey;
import java.util.Base64;

public class RSAEncryption {
    public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes); // 바이트 배열을 Base64로 인코딩하여 문자열로 변환
    }
}
