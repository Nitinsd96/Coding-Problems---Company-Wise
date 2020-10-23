package Annalys;

public class Annalys_River_Records {
    public static void main(String[] args) {
        int[] levels ={5,3,6,7,4};
        int[] levels1 = {4,3,2,1};
        int[] levels2 = {2,3,10,2,4,8,1};
        int[] levels3 = {7,9,5,6,3,2};
        int[] levels4 = {10,10,10,10,10,10};
        Annalys_River_Records obj = new Annalys_River_Records();
        System.out.println(obj.maxProfit(levels));
        System.out.println(obj.maxProfit(levels1));
        System.out.println(obj.maxProfit(levels2));
        System.out.println(obj.maxProfit(levels3));
        System.out.println(obj.maxProfit(levels4));
    }
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int min = prices[0];int res = -1;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-min>res)
                res = prices[i]-min;
            if(prices[i]<min)
                min = prices[i];
        }
        return res;
    }
}
