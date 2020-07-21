/**
 * Project Name: 邮乐支付系统
 * File Name: Tester
 * Package Name: com.java8.demo
 * Date: 2019/7/23 15:09
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.java8.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Tester <br>
 * Function: . <br>
 * Date: 2019/7/23 15:09 <br>
 */
public class Tester {
    public static void main(String[] args) {
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );
        cars.forEach(System.out::println);
        cars.forEach(Car::collide);
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);

    }
}
