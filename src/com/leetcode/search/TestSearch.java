/**
 * Project Name: 邮乐支付系统
 * File Name: TestSearch
 * Package Name: com.example.demo
 * Date: 2019/5/15 13:38
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.leetcode.search;

import java.util.Arrays;

/**
 * ClassName: TestSearch <br>
 * Function: . <br>
 * Date: 2019/5/15 13:38 <br>
 */
public class TestSearch {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        /*System.out.println(search(nums, target));
        System.out.println(climbStairs(4));*/
        System.out.println(Arrays.toString(searchRange(nums, target)));
            System.out.println(Arrays.toString(searchRecursionRange(nums, target)));
    }

    /**
     * 查找符合条件的区间
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRecursionRange(int[] nums, int target) {
        return recSearch(nums, target, 0, nums.length-1);
    }

    public static int[] recSearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return new int[]{-1,-1};
        }
        int middle = (left + right) / 2;
        int middleNum = nums[middle];
        if (middleNum < target) {
            return recSearch(nums, target, middle + 1, right);
        }
        if (middleNum > target) {
            return recSearch(nums, target, left , middle - 1);
        }
        int head = middle,tail = middle;
        while (left<head){
            int a = (left+head-1)/2;
            if (nums[a]<target){
                left = a+1;
            } else {
                head = a;
            }
        }
        while (right>tail){
            int a = (right+tail+1)/2;
            if (nums[a]>target){
                right = a-1;
            }
            else {
                tail = a;
            }
        }
        return new int[]{head,tail};

    }

    /**
     * 查找符合条件的区间
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        int mid = end / 2;
        int fisrtLocation = -1;
        int lastLocation = -1;
        // 先查找前面的位置
        while (start <= end) {
            mid = (start + end)/2;
            if (target == nums[mid]){
                fisrtLocation = mid;
                end = mid - 1;
            }else if (target > nums[mid]) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(fisrtLocation);
        // 再找后面的位置
        end = nums.length - 1;
        start = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) {
                start = mid + 1;
                lastLocation = mid;
            }else if (target > nums[mid]) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(lastLocation);

        return new int[]{fisrtLocation, lastLocation};
    }

    public static int search(int[] nums, int target) {
        int end = nums.length - 1;
        int mid;
        int start = 0;
        while(start <= end) {
            mid = (start+end)/2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        while (n >= 3) {
            int temp = a + b;
            a = b;
            b = temp;
            n--;
        }
        return b;
    }


}
