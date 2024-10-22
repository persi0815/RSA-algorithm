import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAAlgorithm {
    public static void main(String[] args) {
        try {
            // 1. RSA 키 생성
            KeyPair keyPair = RSAKeyGeneration.generateRSAKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // 2. 평문
            String plainText = "Hello, RSA!";

            // 3. RSA 암호화
            String encryptedText = RSAEncryption.encrypt(plainText, publicKey);
            System.out.println("Encrypted Text: " + encryptedText);

            // 4. RSA 복호화
            String decryptedText = RSADecryption.decrypt(encryptedText, privateKey);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}