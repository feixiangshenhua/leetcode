/**
 * Project Name: 邮乐支付系统
 * File Name: YangHuiSanJiaoPrint
 * Package Name: com.leetcode.yanghuisanjiao
 * Date: 2019/7/1 17:02
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.leetcode.yanghuisanjiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: YangHuiSanJiaoPrint <br>
 * Function: 杨辉三角. <br>
 * Date: 2019/7/1 17:02 <br>
 */
public class YangHuiSanJiaoPrint {

    public static void main(String[] args) {
        YangHuiSanJiaoPrint yhsj = new YangHuiSanJiaoPrint();
        List<List<Integer>> list = yhsj.generate(5);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 打印杨辉三角（帕斯卡三角）
     * 示例:
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

}
