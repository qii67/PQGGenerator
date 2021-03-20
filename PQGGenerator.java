import java.math.BigInteger;
import java.util.Random;

public class PQGGenerator {

    static BigInteger q = null;
    static BigInteger p = null;
    static BigInteger g = null;

    /**
     * generate security parameters p q g of cyclic group G, G is a subgroup of multiplicative group Zp*
     * p is a big prime number, q is a big prime number, and q | (p - 1), g is the generator
     * This method is a implementation of Schnorr Group(https://en.wikipedia.org/wiki/Schnorr_group), you can get a designated p_bit and q_bit parameters
     * For security, p is recommended (1024-3072bits) and q is recommended (160-256bits)
     * Since p is generated from p, so may be p's bit length is not exactly as what you set, try more times!
     * @param p_bits, p's length in bit
     * @param q_bits, q's length in bit
     */
    public static void generatePQG(int p_bits, int q_bits) {
        BigInteger ONE = new BigInteger("1");

        // p = kq + 1
        BigInteger k = null;
        BigInteger h = null;

        // 1, generate q
        boolean flag = true;
        while (flag) {
            q = BigInteger.probablePrime(q_bits, new Random());
            if (q.isProbablePrime(10)) {
                flag = false;
            }
        }

        // 2, generate p
        flag = true;
        while (flag) {
            k = new BigInteger(p_bits - q_bits + 1, new Random());
            p = q.multiply(k).add(ONE);
            if (p.isProbablePrime(10)) {
                flag = false;
            }
        }

        // 3, generate g
        flag = true;
        while (flag) {
            h = new BigInteger(20, new Random());
            if ((g = h.modPow((p.subtract(ONE).divide(q)),p)).compareTo(ONE) != 0) {
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        generatePQG(1024, 160);
        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("g: " + g);

        System.out.println("p's length: " + p.bitLength());
        System.out.println("q's length: " + q.bitLength());
        System.out.println("g's length: " + g.bitLength());

        // test g^q mod p = 1
        System.out.println(g.modPow(q, p));
    }
}
