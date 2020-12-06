import java.util.Scanner;
import java.lang.Math;
import java.nio.charset.StandardCharsets;  

class rc4
{
	static void print(byte a[], int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter msg:");
		String msg = ob.nextLine();
		byte[] bytemsg = msg.getBytes();
		print(bytemsg,msg.length());

		System.out.println("Enter key:");
		String key = ob.nextLine();

		int i,j,k;
		byte[] s = new byte[256];

		for(i=0;i<256;i++)
		{
			s[i] = (byte)i;
		}
		//print(s);

		j = 0;
		byte temp;
		for(i=0;i<256;i++)
		{
			j = (j+s[i]+key.charAt(i%key.length()))%256;
			j = Math.abs(j);
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
		//print(s);

		i = 0;
		j = 0;
		
		int p=0;
		byte[] streambytes = new  byte[256];
		
		for(int x=0;x<msg.length();x++)
		{
			i = (i+1)%256;
			j = (j+s[i])%256;

			i = Math.abs(i); 
			j = Math.abs(j);

			temp = s[i];
			s[i] = s[j];
			s[j] = s[i];

			k = s[Math.abs(s[i]+s[j])]%256;
			k = Math.abs(k);
			//System.out.println(s[k]);
			streambytes[p] =s[k];
			p++; 
		}


		//Encryption
		byte[] pt = new byte[256];
		byte[] ct = new byte[256];
		for(i=0;i<msg.length();i++)
		{
			ct[i] = (byte)(streambytes[i] ^ bytemsg[i]);
		}
		//print(ct, msg.length());
		System.out.println(new String(ct,StandardCharsets.UTF_8));

		//Decryption
		for(i=0;i<msg.length();i++)
		{
			pt[i] = (byte)(streambytes[i] ^ ct[i]);
		}
		//print(pt, msg.length());
		System.out.println(new String(pt,StandardCharsets.UTF_8));
	}
}