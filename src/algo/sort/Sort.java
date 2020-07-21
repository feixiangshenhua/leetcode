/**
 * Project Name: 邮乐支付系统
 * File Name: Sort
 * Package Name: algo.sort
 * Date: 2019/9/18 10:12
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package algo.sort;

import java.util.Arrays;

/**
 * ClassName: Sort <br>
 * Function: 排序算法. <br>
 * Date: 2019/9/18 10:12 <br>
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = {11,18,15,24,17,6,5,10,54,47,89,52,4,2,3,7,5,1};
        array = selectSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length <= 1){
            return array;
        }else {
            for (int i = 0; i < array.length; i++) {
                boolean isNotSwap = false;
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j+1]) {
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                        isNotSwap = true;
                    }
                }
                if (!isNotSwap){
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 插入排序
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }else {
            for (int i = 1; i < array.length; i++) {
                int value = array[i];
                int j = i -1;
                for (; j >= 0; j--) {
                    if (value < array[j]){
                        array[j+1] = array[j];
                    }else {
                        break;
                    }
                }
                array[j+1] = value;
            }
        }
        return array;
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
