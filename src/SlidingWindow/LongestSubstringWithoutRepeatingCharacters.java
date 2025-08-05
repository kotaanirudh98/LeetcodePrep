package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
3. Longest Substring Without Repeating Characters
    * Given a string s, find the length of the longest substring without duplicate characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    * */


    /*
    * Explanation: We will be using two pointer, where left & right
    * we will loop till where right - 0; right < n;
    * we will also take a Hashmap -> store the characters & it's index values.
    * left -> 0 & Max will be -> 0 on every loop we will store the max value.
    * max(max, right -left + 1);
    * if map contains char we will move the left -> max(left, myMap.get(ch) + 1)
    *
    *
    * */

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        if(len <= 1){
            return len;
        }

        HashMap<Character, Integer> myMap = new HashMap<>();


        int start = 0;
        int max = 0;


        for (int right  = 0; right < len; right++){
            char ech = s.charAt(right);
            if(myMap.containsKey(ech)){
                start = Math.max(start, myMap.get(ech) + 1);
            }
            myMap.put(ech, right);
            max = Math.max(max,right - start +1);
        }

        return max;

    }
}
