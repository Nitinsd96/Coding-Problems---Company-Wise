package dp.src;

public class blackjackAcehandling {
    public static void main(String[] args) {
        blackjackAcehandling obj = new blackjackAcehandling();
        System.out.println(obj.handleAces(1,21));
    }
    public int handleAces(int Aces, int sum){
        if(Aces==0)
            return 0;
        int sum1 = 0;
        if(1<=sum){
            sum1 = 1+ handleAces(Aces-1,sum-1);
        }
        int sum2 = 0;
        if(11<=sum){
             sum2 = 11 + handleAces(Aces-1,sum-11);
        }
        return Math.max(sum1,sum2);
    }
}
