package com.leetcode.search;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SearchClosest <br>
 * Function: 查找算法. <br>
 * Date: 2019/5/17 10:58 <br>
 */
public class SearchClosest {
    /**
     * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5], k=4, x=3
     * 输出: [1,2,3,4]
     *
     *
     * 示例 2:
     *
     * 输入: [1,2,3,4,5], k=4, x=-1
     * 输出: [1,2,3,4]
     *
     *
     * 说明:
     *
     * k 的值为正数，且总是小于给定排序数组的长度。
     * 数组不为空，且长度不超过 10^4
     * 数组里的每个元素与 x 的绝对值不超过 10^4
     *
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> answer = new ArrayList<>();
        int left = 0, right = arr.length-1, mid = 0;
        while(left <= right){
            mid = left + (right-left)/2;
            if(arr[mid] == x) {
                break;
            }
            else if(arr[mid] < x) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        left = mid;
        right = mid+1;
        while(right - left <= k){
            if(left < 0) {
                //answer.add(arr[right++]);
                right++;
            } else if(right > arr.length-1){
                // Don't insert to front of list, it is very slow
                //answer.add(0, arr[left--]);
                left--;
            } else{
                if(Math.abs(x-arr[left]) <= Math.abs(x-arr[right])){
                    //answer.add(0, arr[left--]);
                    left--;
                } else{
                    //answer.add(arr[right++]);
                    right++;
                }
            }
        }
        while(++left < right) {
            answer.add(arr[left]);
        }
        return answer;
    }
}
