/**
 * Project Name: 邮乐支付系统
 * File Name: TestAutoBox
 * Package Name: com.effective
 * Date: 2019/11/8 10:38
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.effective;

/**
 * ClassName: TestAutoBox <br>
 * Function: . <br>
 * Date: 2019/11/8 10:38 <br>
 */
public class TestAutoBox {
    public static void main(String[] args) {
        long num = 0L;
        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            num += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("用时:" + (end-start)/1000 + "," + num);
    }
}
