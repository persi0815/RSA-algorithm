import java.math.BigInteger;

public class SimpleRSA {
    private BigInteger n, d, e;
    private int bitlen = 1024;

    // RSA 키 생성자
    public SimpleRSA(int bits, BigInteger p, BigInteger q) {
        // 공개키: (e, n), 비밀키: (d, n)
        n = p.multiply(q);  // n = p * q (= 119)
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); // phi = (p-1) * (q-1)
        e = BigInteger.valueOf(5); // e 값은 ϕ(n)과 서로소이고 작은 수 5로 선택
        d = e.modInverse(phi); // d 값 계산 (= 77)

        // 공개키: {5, 119}, 개인키{77, 119}
    }

    // 암호화 함수
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);  // 암호화: c = m^e mod n
    }

    // 복호화 함수
    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, n);  // 복호화: m = c^d mod n
    }

    public static void main(String[] args) {
        // 소수 p=7, q=17 설정 / 3 11
        BigInteger p = BigInteger.valueOf(7);
        BigInteger q = BigInteger.valueOf(17);

        // RSA 객체 생성
        SimpleRSA rsa = new SimpleRSA(1024, p, q);

        // 학번에서 암호화할 부분: 12, 60, 61
        BigInteger[] studentIdParts = {
                BigInteger.valueOf(12),
                BigInteger.valueOf(60),
                BigInteger.valueOf(61)
        };

        System.out.print("원본 학번: " + 2022);
        for (BigInteger part : studentIdParts) {
            System.out.print(part + "");
        }
        System.out.println();

        // 암호화
        System.out.print("암호화된 값: " + 2022);
        BigInteger[] encryptedParts = new BigInteger[studentIdParts.length];
        for (int i = 0; i < studentIdParts.length; i++) {
            encryptedParts[i] = rsa.encrypt(studentIdParts[i]);
            System.out.print(encryptedParts[i] + "");
        }
        System.out.println();

        // 복호화
        System.out.print("복호화된 값: " + 2022);
        for (BigInteger encryptedPart : encryptedParts) {
            BigInteger decrypted = rsa.decrypt(encryptedPart);
            System.out.print(decrypted + "");
        }
        System.out.println();
    }
}
