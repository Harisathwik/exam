import java.util.Scanner;
import java.math.BigInteger;
import java.security.SecureRandom;
class rsacopy
{
	static BigInteger encrypt(BigInteger pt, BigInteger e, BigInteger modulus)
	{
		return pt.modPow(e, modulus);
	}
	static BigInteger decrypt(BigInteger ct, BigInteger d, BigInteger modulus)
	{
		return ct.modPow(d, modulus);
	}
	public static void main(String[] args)
	{
		BigInteger one = new BigInteger("1");
		SecureRandom random = new SecureRandom();

		int n;
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter n:");
		n = ob.nextInt();

		BigInteger p = BigInteger.probablePrime(n/2, random);
		BigInteger q = BigInteger.probablePrime(n/2, random);

		BigInteger modulus =p.multiply(q);
		BigInteger phi = p.subtract(one).multiply(q.subtract(one));

		BigInteger e = new BigInteger("65537");
		BigInteger d = e.modInverse(phi);

		System.out.println("pub:"+e);
		System.out.println("pri:"+d);
		
		BigInteger pt = new BigInteger(n-1, random);
		BigInteger ct;

		System.out.println("original msg:"+pt);

		ct = encrypt(pt, e, modulus);
		System.out.println("Encrypted text:"+ct);

		pt = decrypt(ct, d, modulus);
		System.out.println("Decrypted text:"+pt);


	}
}