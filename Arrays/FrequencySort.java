import java.util.*;
import java.lang.*;
import java.io.*;
 
//Sort array by frequency and then by increasing order

class FrequencySort {
 
    static class Pair {
        int c;
        int n;
        Pair(int c, int n) {
            this.c = c;
            this.n = n;
        }
    }
 
    public static void main (String args[]) throws java.lang.Exception {
      Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    while (T-- >0) {
          int N = sc.nextInt();
          int a[] = new int[N];

          for (int i=0; i<N; i++)
              a[i] = sc.nextInt();

          Map<Integer,Integer> hm = new HashMap<>();

          /**
          PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
              public int compare(Pair A,Pair B) {
                  if (A.c == B.c)
                      return A.n-B.n;
                  return B.c-A.c;
              }
         });
         **/

         for (int i=0; i<N; i++) {
              if (hm.get(a[i]) == null)
                  hm.put(a[i],1);
              else
                  hm.put(a[i],hm.get(a[i])+1);
          }

          Set<Map.Entry<Integer,Integer>> set = hm.entrySet();
          List<Map.Entry<Integer,Integer>> llist = new ArrayList<Map.Entry<Integer,Integer>>(set);
          Collections.sort(llist, new Comparator<Map.Entry<Integer, Integer>>() {
            
            public int compare(Map.Entry<Integer, Integer> A, Map.Entry<Integer, Integer> B) {
               if (A.getValue() == B.getValue())
                  return A.getValue()-B.getValue();
               return B.getValue()-A.getValue();
            }
          });

          for (Map.Entry e : llist) {
            for (int i=1; i<= (Integer)e.getValue(); i++)
            System.out.print(e.getKey()+" ");
          }
          
          System.out.println();
	      }
     }
}
