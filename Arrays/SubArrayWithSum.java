/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class SubArrayWithSum
{
	public static void subArrayWithSum(int X, int num[]) {
 
		int n = num.length;
		int sum[] = new int[n];
		sum[0] = num[0];
		int currSum = 0;
 
		Map<Integer,Integer> hm = new LinkedHashMap<>();
		System.out.println("Given array: "+Arrays.toString(num));
		System.out.println("Given sum: "+X);
		for (int i=0; i<n; i++) {
			currSum += num[i];
 
			if (currSum == X) {
				System.out.println("0 to "+i);
				return;
			}
 
			if (hm.get(currSum-X) != null) {
				System.out.println((hm.get(currSum-X)+1)+" to "+i);
				return;
			}
			hm.put(currSum,i);
		}
		System.out.println("No subarray found");
	} 
 
	public static void main (String[] args) throws java.lang.Exception
	{
		int num[] = {1,2,-2,7,5};
		int X  = 0;
		subArrayWithSum(X,num);
	}
}
