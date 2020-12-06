import java.util.Scanner;
class caeser
{
	public static String encrypt(String pt,int k)
	{
		String ct = "";
		int val;

		for(int i=0;i<pt.length();i++)
		{
			val = (int)pt.charAt(i);
			val -= 97;
			val += k;
			val %= 26;
			val += 97;
			ct += (char)val;
		}
		return ct;
	}

	public static String decrypt(String ct,int k)
	{
		String pt = "";
		int val;
		k = 26-k;

		for(int i=0;i<ct.length();i++)
		{
			val = (int)ct.charAt(i);
			val -= 97;
			val += k;
			val %= 26;
			val += 97;
			pt += (char)val;
		}
		return pt;
	}

	public static void main(String[] args)
	{
		String pt,ct;
		int k;
		Scanner ob = new Scanner(System.in);
		System.out.println("Eneter pt:");
		pt = ob.nextLine();
		System.out.println("Eneter key:");
		k = ob.nextInt();
		
		ct = encrypt(pt, k);
		System.out.println("Cipher Text is :"+ct);

		pt = decrypt(ct, k);
		System.out.println("plain Text is :"+pt);

	}
}