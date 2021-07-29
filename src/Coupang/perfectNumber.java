package Coupang;

public class perfectNumber {
    public static void main(String[] args) {
        perfectNumber obj = new perfectNumber();
        System.out.println(obj.perNum(16));
        System.out.println(obj.perNum(1000));
    }
    public int perNum(int n){
        if(n==2) return 1;
        if(n==5) return 2;
        int count=0;int flag=0;
        for(int i=6;i<=n;i++){
            for(int j=1;j<=n;j++){
                flag=0;
                for(int k=n;k>=j;k--){
                    if(i==(j+k) && isPower(j) && isPower(k)) {
                        System.out.println(i);
                        count++;
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                    break;
            }
        }
        return count+2;

    }
    public boolean isPower(int n)
    {
        for (int x = 2; x <= Math.sqrt(n); x++) {
            int y = 2;

            double p = Math.pow(x, y);

            while (p <= n && p > 0) {
                if (p == n)
                    return true;
                y++;
                p = Math.pow(x, y);
            }
        }
        return false;
    }
}
