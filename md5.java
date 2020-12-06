import java.security.MessageDigest;
import java.util.*;
class MD5
{
	static String byteArrayToHexString(byte[] b) 
	{
  		String result = "";
  		for (int i=0; i<b.length; i++) 
  		{
    		result +=
          	Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring(1);
  		}
  		return result;
	}
	public static void main(String[] args)
	{
		MessageDigest md=null;
		try
		{
			md = MessageDigest.getInstance("MD5");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter str:");
		String str = ob.nextLine();
		byte[] bytestr = str.getBytes();
		bytestr = md.digest(bytestr);
		System.out.println(bytestr);
		System.out.println(byteArrayToHexString(bytestr));

	}
}
