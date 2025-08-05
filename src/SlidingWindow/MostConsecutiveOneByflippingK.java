package SlidingWindow;

public class MostConsecutiveOneByflippingK {

/*
*1004. Max Consecutive Ones III
*Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
*
* */


    /*
    * solution -> here we are using sliding window pattern where we will have two points left, right & count of zero's & max
    * first we will loop till r < n;
    * if we see zero -> we will increment the count of zero's
    * if the zero's count > k -> & nums[left] ==0   we will decrease the zero's count & move the left + 1
    * and we will also note the maximum lenth -> standard -> right - left + 1;
    * */


    public int longestOnes(int[] nums, int k) {

        int max = 0;
        int n = nums.length;
        int zero = 0;

        int l = 0;

        for(int r = 0; r < n; r++){

            if(nums[r] == 0) {
                zero++;
            }

            if (zero > k) {
                if (nums[l] == 0) {
                    zero--;
                }
                l++;
            }

            max = Math.max(max, r-l+1);
        }

        return max;

    }
}
