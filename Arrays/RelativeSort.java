/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

//In CustomComparartor use everything wrt Objects i.e use Wrapper Classes of Primitive Types

class CustomComparator implements Comparator<Integer>{
    Map<Integer,Integer> hm; 
    public CustomComparator(Map<Integer,Integer> hm) {
        this.hm = hm;
    }
    
    @Override
    public int compare(Integer A,Integer B) {
        if (hm.containsKey(A) && hm.containsKey(B))
		return hm.get(A)-hm.get(B);
        else if (hm.containsKey(A))
		return -1;
	else if (hm.containsKey(B))
		return 1;
	else
		return A - B;
    }
}
class RelativeSort {

	public static void main (String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while (T-- >0) {
		    int M = sc.nextInt();
		    int N = sc.nextInt();
		    
		    Integer a[] = new Integer[M];
		    for (int i=0; i<M; i++)
		        a[i] = sc.nextInt();
		        
		    Integer b[] = new Integer[N];
		    for (int i=0; i<N; i++)
		        b[i] = sc.nextInt();
			
		    System.out.println("Original array to be sorted: "+Arrays.toString(a));
		    System.out.println("Relative array: "+Arrays.toString(b));
		    Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		    for (int i=0; i<N; i++)
		        hm.put(b[i],i);
		        
		    Arrays.sort(a, new CustomComparator(hm));
		    System.out.println("Sorted array: "+Arrays.toString(a));
		  
		}
				
	}
}
