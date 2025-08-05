package SlidingWindow;

import java.util.HashMap;

public class FruitsinBasket {

/*
* 904. Fruit Into Baskets
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.



Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
*
* */


    /*
    * SOlution is we will be using two pointer with sliding window
    * we will have left = 0, max = 0, and hashMap which is stroe occurence of elements
    * first we will loop through array -> add the r < n; ->
    * then we check if the mapsze() > 2 -> then we will add that fruits[left] - 1 -> which means shrinking it down.
    * & if the map.get -> == 0 we will remove map.recmove that one, this will be in while/if loop only
    * left++
    * max = Math.max(max, right -left + 1);
    * */


    public int totalFruit(int[] fruits) {

        int l = 0;
        int max = 0;

        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int r =0; r < fruits.length; r++){
            myMap.put(fruits[r], myMap.getOrDefault(fruits[r],0) + 1);


            if (myMap.size() > 2){
                myMap.put(fruits[l], myMap.get(fruits[l]) -1);

                if(myMap.get(fruits[l]) == 0) {
                    myMap.remove(fruits[l]);
                }

                l++;
            }

            max = Math.max(max, r - l + 1);

        }

        return max;


    }
}
