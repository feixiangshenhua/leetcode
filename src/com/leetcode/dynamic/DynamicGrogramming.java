/**
 * Project Name: 邮乐支付系统
 * File Name: DynamicGrogramming
 * Package Name: com.leetcode.dynamic
 * Date: 2019/7/8 11:01
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.leetcode.dynamic;

/**
 * ClassName: DynamicGrogramming <br>
 * Function: 动态规划. <br>
 * Date: 2019/7/8 11:01 <br>
 */
public class DynamicGrogramming {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * @param n
     * @return
     *
     * 方法四：斐波那契数
     * 算法
     *
     * 在上述方法中，我们使用 dpdp 数组，其中 dp[i]=dp[i-1]+dp[i-2]dp[i]=dp[i−1]+dp[i−2]。可以很容易通过分析得出 dp[i]dp[i] 其实就是第 ii 个斐波那契数。
     *
     * Fib(n)=Fib(n-1)+Fib(n-2)
     * Fib(n)=Fib(n−1)+Fib(n−2)
     *
     * 现在我们必须找出以 11 和 22 作为第一项和第二项的斐波那契数列中的第 nn 个数，也就是说 Fib(1)=1Fib(1)=1 且 Fib(2)=2Fib(2)=2。
     *
     * Java
     *
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/pa-lou-ti-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
