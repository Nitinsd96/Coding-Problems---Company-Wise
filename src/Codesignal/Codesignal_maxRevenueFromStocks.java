package Codesignal;

public class Codesignal_maxRevenueFromStocks {
    public static void main(String[] args) {
        int[] arr = {2,4,1,5,2,6,7};
        int[] bs = {0,1,0,0,1,0,0};
        Codesignal_maxRevenueFromStocks obj = new Codesignal_maxRevenueFromStocks();
        System.out.println(obj.maxRev(arr,bs,4));
    }
    public int maxRev(int[] arr,int[] bs, int k){
        int sum = 0;int result = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(bs[i]==0)
                sum = sum - arr[i];
            else
                sum = sum + arr[i];
        }
        System.out.println(sum);
        int back = sum;
        for(int i=0;i<arr.length;i++){
            if(bs[i]==0){
                back = back + 2*arr[i];
            }
            System.out.println("1   "+back);
            if(i>=k-1){
                result =  Math.max (back,result);
                if(i>=k && arr[i-k]==0 ){
                    back = back - 2*arr[i-k];
                }
                System.out.println("2  "+back);
            }
        }
        return Math.max(result,sum);
    }
}
