package com.leetcodeblind75;

/* 
Given an array prices[] of non-negative integers, representing the prices of the stocks 
on different days, find the maximum profit possible by buying and selling the stocks on 
different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. 
If it is not possible to make a profit then return 0.

*/
public class BestTimeToBuyandSellStock {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        // to initialize minvalue =Integer.MAX_VALUE  maxvalue =Integer.MIN_VALUE;
        int maxProfit=Integer.MIN_VALUE;   
        int minPrice=Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice,prices[i]);
            int currentProfit = prices[i]-minPrice;
            maxProfit =Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }




    
}
