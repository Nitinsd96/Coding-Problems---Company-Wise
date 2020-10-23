package Freenome;

import java.util.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Blackjack {

    List<String> Deck = new ArrayList<>();
    Map<String,Integer> score = new HashMap<>();
    public Blackjack(){
        createDeck();
    }
    public void createDeck(){
        List<String> CardTypes = new ArrayList(Arrays.asList("SPADES","DIAMONDS","HEARTS","CLUBS"));

        List<String> CardNumbers = new ArrayList<String>(Arrays.asList("Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","King","Queen"));
        for(int i=0;i<13;i++){
            if(i>9)
                score.put(CardNumbers.get(i),10);
            else
                score.put(CardNumbers.get(i),i+1);
        }

        for(String cardtype : CardTypes){
            for(String cardnumber : CardNumbers){
                Deck.add(cardtype+"-"+cardnumber);
            }
        }
        System.out.println(Deck.size());
    }

    public String getCard(){
        int size = this.Deck.size();
        Random r = new Random();
        int getrandomindex =  r.nextInt(size);
        String card = Deck.get(getrandomindex);
        Deck.remove(getrandomindex);
        return card;
    }
    public int getScore(String card){
        String[] cardValue = card.trim().split(" ");
        int points = 0; int countAces = 0;
        for(int i =0; i<cardValue.length;i++){
            String cardNumber = cardValue[i].split("-")[1];
            if(cardNumber.equals("Ace")){
                countAces++;
            }
            else{
                points = points + score.get(cardNumber);
            }
        }

        return points + handleAces(countAces, Math.abs(21 - points));
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

    public static void main(String[] args) throws InterruptedException {

        boolean play = true;
        while(play){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Wanna play Blackjack (yes/no) : ");
            String yes = myObj.nextLine();
            if(yes.equals("yes"))
                play = true;
            else
                play = false;

            while(play == true){
                System.out.println("Enter player name :");
                String player = myObj.nextLine();  // Read user input
                Blackjack game = new Blackjack();

                StringBuilder dealer_cards = new StringBuilder();

                String cardout = game.getCard();
                dealer_cards.append(" "+cardout);
                int dealerScore = game.getScore(dealer_cards.toString());
                System.out.println("Dealer has : "+cardout+"  ?  "+"=  ?");

                int playerScore = 0;
                System.out.println("-----------"+player+"turn------------");
                StringBuilder player_cards = new StringBuilder();
                boolean Stand = false; boolean conclusion = false;
                while(true){
                    String cardup = game.getCard();
                    player_cards.append(" "+cardup);
                    playerScore = game.getScore(player_cards.toString());
                    System.out.println(player+" has"+player_cards+"=  "+playerScore);
                    if(playerScore>21){
                        System.out.println(player+" bust with "+ playerScore);
                        System.out.println("Dealer wins");
                        conclusion = true;
                        break;
                    }
                    if(playerScore==21){
                        System.out.println(player +" wins");
                        System.out.println("Blackjack");
                        conclusion = true;
                        break;
                    }
                    System.out.println("Would you like to (H)it or (S)tand : ");
                    String Action = myObj.nextLine();
                    if(Action.equals("H") || Action.equals("h"))
                        continue;
                    Stand = true;
                    break;
                }

                while(Stand){
                    Thread.sleep(3000);
                    String cardup = game.getCard();
                    dealer_cards.append(" "+cardup);
                    dealerScore = game.getScore(dealer_cards.toString());
                    System.out.println("Dealer has"+dealer_cards+"=  "+dealerScore);

                    if(dealerScore>21){
                        System.out.println(player +" wins");
                        conclusion = true;
                        break;
                    }

                    else if(dealerScore>playerScore){
                        System.out.println("dealer wins");
                        conclusion = true;
                        break;
                    }
                    else if(dealerScore<=17)
                        continue;
                    else
                        break;
                }
                if(!conclusion){
                    if(playerScore == dealerScore)
                        System.out.println("Game Draw");
                    if(playerScore>dealerScore)
                        System.out.println(player +" wins");
                    else
                        System.out.println("dealer wins");
                }
                break;
            }
        }
        System.out.println("Thanks for playing blackjack");

    }

}
