/**
 * Project Name: 邮乐支付系统
 * File Name: Java8Tester
 * Package Name: com.java8.demo
 * Date: 2019/7/23 10:58
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.java8.demo;

/**
 * ClassName: Java8Tester <br>
 * Function: java8测试. <br>
 * Date: 2019/7/23 10:58 <br>
 */
public class Java8Tester {
    final static String salutation = "Hello! ";

    public static void main(String args[]){
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;
        Java8Tester tester = new Java8Tester();
        System.out.println(tester.operate(1, 2, addition));
        System.out.println(tester.operate(10, 2, subtraction));
        System.out.println(tester.operate(11, 2, multiplication));
        System.out.println(tester.operate(3, 2, division));
    }

    /**
     * 数学计算
     */
    interface MathOperation {
        double operation(double a, int b);
    }

    private double operate(double a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
