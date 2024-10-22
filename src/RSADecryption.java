import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.util.Base64;

public class RSADecryption {
    public static String decrypt(String cipherText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText)); // Base64로 인코딩된 텍스트를 바이트 배열로 변환
        return new String(decryptedBytes); // 바이트 배열을 문자열로 변환
    }
}
