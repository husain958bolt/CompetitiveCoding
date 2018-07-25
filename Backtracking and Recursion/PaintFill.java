/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class PaintFill
{
	static int M;
	static int N;


	// A recursive function to replace previous color 'prevC' at  '(x, y)' 
	// and all surrounding pixels of (x, y) with new color 'newC' and

	public static void floodFillUtil(int screen[][], int x, int y, int prevC, int newC) {
    	// Base cases
    	if (x < 0 || x >= M || y < 0 || y >= N)
       		return;
    	if (screen[x][y] != prevC)
        	return;
 
	    // Replace the color at (x, y)
	    screen[x][y] = newC;
 
    	// Recur for north, east, south and west
    	floodFillUtil(screen, x+1, y, prevC, newC);
	    floodFillUtil(screen, x-1, y, prevC, newC);
	    floodFillUtil(screen, x, y+1, prevC, newC);
	    floodFillUtil(screen, x, y-1, prevC, newC);
	}
		 
	// It mainly finds the previous color on (x, y) and
	// calls floodFillUtil()
	public static void floodFill(int screen[][], int x, int y, int newC)
	{
	    int prevC = screen[x][y];
	    floodFillUtil(screen, x, y, prevC, newC);
	}
 
	// Driver program to test above function
	public static void main(String args[])
	{
	    int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
	                      {1, 1, 1, 1, 1, 1, 0, 0},
	                      {1, 0, 0, 1, 1, 0, 1, 1},
	                      {1, 2, 2, 2, 2, 0, 1, 0},
	                      {1, 1, 1, 2, 2, 0, 1, 0},
	                      {1, 1, 1, 2, 2, 2, 2, 0},
	                      {1, 1, 1, 1, 1, 2, 1, 1},
	                      {1, 1, 1, 1, 1, 2, 2, 1},
	                     };
		M = screen.length;
		N = screen[0].length;
	    int x = 4, y = 4, newC = 3;
	    floodFill(screen, x, y, newC);
	 
	    System.out.println("Updated screen after call to floodFill:");
	    for (int i=0; i<M; i++)
	    {
	        for (int j=0; j<N; j++)
	           System.out.print(screen[i][j]);
	        System.out.println();
	    }
	}

}
