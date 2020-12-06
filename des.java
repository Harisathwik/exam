import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
class des
{
	public static void main(String[] args)
	{
		try
		{
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			SecretKey key = kg.generateKey();
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			byte[] text = "HELLOWORLD".getBytes();

			cipher.init(cipher.ENCRYPT_MODE, key);
			
			byte[] textEnc = cipher.doFinal(text);
			System.out.println("Encrypted text in bytes:"+textEnc);
			System.out.println("Encrypted text in string :"+new String(textEnc));

			cipher.init(cipher.DECRYPT_MODE, key);

			byte[] textDec = cipher.doFinal(textEnc);
			System.out.println("Decrypted text in bytes:"+textDec);
			System.out.println("Decrypted text in string :"+new String(textDec));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}