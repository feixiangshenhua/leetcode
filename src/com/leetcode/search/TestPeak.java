/**
 * Project Name: 邮乐支付系统
 * File Name: TestPeak
 * Package Name: com.leetcode.search
 * Date: 2019/5/17 17:25
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package com.leetcode.search;

/**
 * ClassName: TestPeak <br>
 * Function: . <br>
 * Date: 2019/5/17 17:25 <br>
 */
public class TestPeak {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        int[] nums2 = {1,2,3,4,5};
        //int[] nums3 = {1,2,1,1};
        System.out.println(findPeakElement2(nums2));
    }

    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }

        if (nums.length > 1 ) {
            if (nums[0] > nums[1]) // if first element is peak
                return 0;
            else if (nums[nums.length - 1] > nums[nums.length - 2]) // if last element is peak
                return nums.length - 1;
        }
        // check if the peak in between the boundary elements

        int left = 1;
        int right = nums.length-1;

        while (left < right){
            int m = left + (right-left)/2;

            if (nums[m]> nums [m-1] && nums[m] > nums[m+1])
                return m;
            else if (nums[m] <= nums[m-1])
                right= m-1;
            else
                left= m+1;
        }

        // if the peak is last but one

        if (left != nums.length-1 && left > 0
                && nums[left] > nums[left-1]
                && nums[left] > nums[left+1])
            return left;

        return -1;

    }

    public static int findPeakElement2(int[] nums) {
        int i=0;
        int j=1;
        int[] result = new int[nums.length+2];
        System.arraycopy(nums, 0, result, 1, nums.length);
        result[0] = Integer.MIN_VALUE;
        result[result.length-1] = Integer.MIN_VALUE;
        while(j<result.length) {
            if(result[i]<result[j] && result[j]>result[j+1]) {
                return j-1;
            }
            i++;
            j++;
        }
        return 0;





    }

}
