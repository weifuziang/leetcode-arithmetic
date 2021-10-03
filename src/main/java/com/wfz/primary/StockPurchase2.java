package com.wfz.primary;

public class StockPurchase2 {
    /*
    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

    示例 1：

    输入：[7,1,5,3,6,4]
    输出：5
    解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
         注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

    示例 2：

    输入：prices = [7,6,4,3,1]
    输出：0
    解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
   联系官方授权，非商业转载请注明出处。

     */

    public static void main(String[] args) {

        int[] prices = {7, 2, 5, 3, 6, 4, 1, 10};
        // int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));


    }

    private static int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int index = 0;
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        while (index < prices.length) {

            if (prices[index] < min) {//获取到股票K线的历史最小值
                min = prices[index];
                //如果，出现了比股票K线的历史最小值大，则比较该值和最小值之差是否比之前的差值大，如果大则覆盖，如果小，则不处理
            } else if ((prices[index] - min) > maxProfit) {
                maxProfit = prices[index] - min;
            }

            index++;

        }

        return maxProfit;


    }
}
