package org.tests.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
@Slf4j
public class BubbleSorting {
    void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (nums[j] > nums[j + 1]) {
                    // swap temp and nums[i]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
    }

    // Method to test above
    public static void main(String[] args) {
        BubbleSorting ob = new BubbleSorting();
        int[] nums = {7, -5, 3, 2, 1, 0, 45};
        log.info("Original Array:");
        log.info(Arrays.toString(nums));
        ob.bubbleSort(nums);
        log.info("Sorted Array");
        log.info(Arrays.toString(nums));
    }
}
