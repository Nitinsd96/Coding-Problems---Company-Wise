package Codesignal;

import java.util.*;

public class Codesignal_segment {
    public static void main(String args[])
    {

        int[] arr = { 2, 3, 1, 7 };
        int[] arr1 = { 1,1,1 };
        int[] arr2 = { 1,2,0 };
        int[] arr3 = {1,2,2,2,5,0};
        Codesignal_segment obj = new Codesignal_segment();

        System.out.println(obj.findCount(arr));
        System.out.println(obj.findCount(arr1));
        System.out.println(obj.findCount(arr2));
        System.out.println(obj.findCount(arr3));

    }
    static int findCount(int arr[]) {
        int n = arr.length;
        // Stores the prefix sums
        int[] prefix_sum = new int[n];

        prefix_sum[0] = arr[0];

        for (int i = 1; i < n; i++)
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];

        // Stores the suffix sums
        int[] suffix_sum = new int[n];

        suffix_sum[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--)
            suffix_sum[i] = suffix_sum[i + 1] + arr[i];

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(prefix_sum));
        System.out.println(Arrays.toString(suffix_sum));
        int start = 1, end = 1;
        int curr_subarray_sum = 0, count = 0;

        // Traverse the given array
        while (start < n - 1 && end < n - 1) {
            while(curr_subarray_sum < prefix_sum[start-1]){
                curr_subarray_sum = curr_subarray_sum + arr[end++];
                if(prefix_sum[start-1]<=curr_subarray_sum && curr_subarray_sum<=suffix_sum[end+1]){
                    count++;
                }
                if(curr_subarray_sum>suffix_sum[end+1] || end == arr.length-2){
                    curr_subarray_sum = curr_subarray_sum - arr[start++];
                    while(curr_subarray_sum >= prefix_sum[start-1]){
                        curr_subarray_sum =curr_subarray_sum - arr[end--];
                    }
                }
            }
        }

        // Return count
        return count;
    }
}
