import java.util.Scanner;
class hillcipher
{
	static void fillkey(int[][] keymatrix, String key)
	{
		int x=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				keymatrix[i][j] = (int)key.charAt(x)% 97;
				x++;
			}
		}

	}
	static void printmat(int[][] matrix, int m, int n)
	{
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	static String encrypt(int[][] keymatrix, int[][] ptvector)
	{
		int[][] ct = new int[3][1];
		String cipher = "";
		int i,j,k;
		for(i=0;i<3;i++)
		{
			for(j=0;j<1;j++)
			{
				ct[i][j] = 0;
				for(k=0;k<3;k++)
				{
					ct[i][j] += keymatrix[i][k] * ptvector[k][j];
				}
				cipher += (char)(ct[i][j]+97);
			}
		}
		printmat(ct, 3, 1);
		return cipher;
	}
	public static void main(String[] args)
	{

		String pt, key, ct;
		Scanner ob = new Scanner(System.in);

		System.out.println("Enter pt:");
		pt = ob.nextLine();

		System.out.println("Enter key:");
		key = ob.nextLine();

		//System.out.println(pt);
		//System.out.println(key);

		int[][] keymatrix = new int[3][3];
		fillkey(keymatrix, key);
		//printmat(keymatrix);

		int[][] ptvector = new int[3][1];
		for(int i=0;i<3;i++)
		{
			ptvector[i][0] = (int)pt.charAt(i) % 97;
		}

		//for(int i=0;i<3;i++)
		//{
		//	System.out.println(ptvector[i][0]);
		//}

		ct = encrypt(keymatrix, ptvector);
		System.out.println(ct);

	}
}