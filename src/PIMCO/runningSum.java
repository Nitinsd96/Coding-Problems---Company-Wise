public class runningSum {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 1, 3, 7, -3};
        int[] arr2 = {-68, -79, 9, 99, 84, 92, -67, -78};
        int[] arr3 = {3,-5};
        runningSum obj = new runningSum();
        System.out.println(obj.sum(arr1,2));
        //System.out.println(obj.sum(arr2,2));
        //System.out.println(obj.sum(arr3,1));
    }
    public long sum(int[] arr, int k){
        long max = Long.MIN_VALUE; int j =0; long sum = 0; int mid = arr.length/2;
        for(int i=0;i<arr.length/2+k-1;i++){
            sum = (long)sum + (long)arr[i] + (long)arr[(i+mid)%arr.length];
            if(i>=k)
                sum = (long)sum  - (long)arr[(j+mid)%arr.length] - (long)arr[j++];
            max = Math.max(sum,max);
        }
        return max;
    }
}

