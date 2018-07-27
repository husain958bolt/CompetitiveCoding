/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class FirstMissingPositiveInteger
{
	public static int firstMissingPositive(int[] nums) { 
        if (nums == null || nums.length == 0) {
            return 1;
        }
 
        int index = 0;
        while (index < nums.length) {
            while (nums[index] != (index+1) && nums[index] > 0 && nums[index] <= nums.length) {
                //move it to its home by swapping
                int currentValue = nums[index];
                if (nums[index] == nums[currentValue-1]) {
                    break;
                }
		System.out.println("Before moving nums["+index+"] : "+currentValue+" to correct position in "+Arrays.toString(nums));
                nums[index] = nums[currentValue-1];
                nums[currentValue-1] = currentValue;
                System.out.println("After moving nums["+index+"] : "+currentValue+" to correct position in "+Arrays.toString(nums));
            }
            index++;
        }
 
        index = 0;
        while (index < nums.length && nums[index] == (index+1)) {
            index++;
        }
 
        return index+1;
    }
 
	public static void main (String[] args) throws java.lang.Exception
	{
		int nums[] = {1,8,6,1,2,3,4,-1,-2,5,22,9,10};
		System.out.println("Given array: "+Arrays.toString(nums));
		System.out.println("First missing positive integer: "+firstMissingPositive(nums));
	}
}
