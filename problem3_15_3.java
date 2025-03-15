package leetcode;

public class problem3_15_3 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit2(prices));
    }


    //贪心算法
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public  static int maxProfit2(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int num:prices){
            if(num<min) min=num;
            else max=Math.max(num-min,max);
        }
        return max;
    }

}
