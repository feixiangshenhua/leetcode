/**
 * Project Name: 邮乐支付系统
 * File Name: TestTreeMap
 * Package Name: com.concurrent
 * Date: 2019/12/9 11:28
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.concurrent;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * ClassName: TestTreeMap <br>
 * Function: . <br>
 * Date: 2019/12/9 11:28 <br>
 */
public class TestTreeMap {
    public static void main(String[] args) {

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("b", "b");
        treeMap.put("c", "c");
        treeMap.put("a", "a");
        Set<Map.Entry<String,String>> set = treeMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
