/**
 * Project Name: 邮乐支付系统
 * File Name: BinarySearch
 * Package Name: algo.search
 * Date: 2019/9/20 10:34
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package algo.search;

/**
 * ClassName: BinarySearch <br>
 * Function: 二分查找. <br>
 * Date: 2019/9/20 10:34 <br>
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {8,11,19,23,27,33,45,55,67,98};
        //System.out.println(binarySearch(arr, 23));
        System.out.println(recursionBinarySearch(arr, 0, arr.length-1, 23));
    }

    /**
     * 循环的方式二分查找
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high-low)>>1);
            if (arr[mid] == value) {
                return mid;
            }else if (arr[mid] > value) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归的方式二分查找
     * @param arr
     * @param start
     * @param end
     * @param value
     * @return
     */
    public static int recursionBinarySearch(int[] arr, int start, int end, int value){
        if (start > end) {
            return -1;
        }
        int mid = start + ((end-start) >> 1);
        if (arr[mid] == value) {
            return mid;
        }else if (arr[mid] > value) {
            return recursionBinarySearch(arr, start, mid-1, value);
        }else {
            return recursionBinarySearch(arr, mid+1, end, value);
        }
    }
}
