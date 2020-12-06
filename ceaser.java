class ceaser
{
	public static StringBuffer encrypt(String s,int key)
	{
		StringBuffer result = new StringBuffer();
		for(int i=0;i<string.length();i++)
		{
			if(Character.isUpperCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i)+key - 65 )%26+65);
				result.append(ch);
			}
			else
			{
				char ch = (char)(((int)text.charAt(i)+key - 97 )%26+97);
				result.append(ch);
			}
		}
	}
	public static void main(String[] args)
	{
		String s="HELLO WORLD";
		int key=5;
		String cipher = encrypt(s,key);
		System.out.println(cipher);

	}
}