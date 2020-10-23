package Codesignal;

public class Codesignal_sumOfreversed {
    public static void main(String[] args) {
        int[] arr = { 7,234,58100};
        Codesignal_sumOfreversed obj = new Codesignal_sumOfreversed();
        System.out.println(obj.sumOfReversed(arr));
    }
    public long sumOfReversed(int[] arr){
        int num =0; int result = 0;
        for(int i=0;i<arr.length;i++){
            int number = arr[i]; int newNum = 0;
            while(number!=0){
                num = number%10;
                number=number/10;
                newNum = 10*newNum + num;
            }
            result = result + newNum;
        }
        return result;
    }
}
