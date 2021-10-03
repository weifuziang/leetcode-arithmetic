package com.wfz.primary;

public class StockPurchase {

    /*
    给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）

    输入: prices = [7,1,5,3,6,4]
    输出: 7
    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

    */

    public static void main(String[] args) {

//        int[] prices = new int[]{1, 2, 5, 3, 6, 4, 5, 6, 7, 2, 10};

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
        int[] prices = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            prices[i] = (int) (Math.random() * 80000000); // 生成一个[0, 8000000) 数
        }

        long start = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(maxProfit(prices));
        long start2 = System.currentTimeMillis();
        System.out.println(start2-start);
        System.out.println(maxProfit2(prices));
        long end = System.currentTimeMillis();
        System.out.println(end-start2);

    }


    //方法一： 使用贪心算法计算
    private static long maxProfit(int[] prices) {

        if (prices.length < 2)
            return 0;

        int index = 0;
        long total = 0;

        while (index < prices.length - 1) {//每次循环能找到股票k线的最高点和最低点，然后相减，并累加到total上

            if (prices[index] > prices[index + 1]) {//判断股票开始的k线是上升趋势

                while (index < prices.length - 1 && prices[index] > prices[index + 1]) {//循环判断直到找到最高的k线点
                    index++;
                }
                int minValue = prices[index];
                while (index < prices.length - 1 && prices[index] < prices[index + 1]) {//循环判断直到找到最低的k线点
                    index++;
                }
                total += prices[index] - minValue;

            } else if (prices[index] < prices[index + 1]) {//判断股票开始的k线是下降的趋势

                int minValue = prices[index];

                while (index < prices.length - 1 && prices[index] < prices[index + 1]) {
                    index++;
                }

                total += prices[index] - minValue;

            } else {//判断股票没有增也没有减
                index++;
            }

        }

        return total;

    }


    //方法二： 遍历数据，将前后两个元素相减（后面的减去前面的元素），将数值为正数加起来即可
    private static long maxProfit2(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        long total = 0;
        int index = 0;
        while (index < prices.length - 1) {

            //将两个相邻的数相减（后者减去前者）
            int value = prices[index + 1] - prices[index];
            //将大于0的累加到total上
            total = total + Math.max(value, 0);
            //所以累加
            index++;
        }

        return total;
    }

}
