import java.util.*;

public class Blackjack{

    public static void main(String[] args){
        Random r = new Random();
        Scanner console = new Scanner(System.in);
        ArrayList<Integer> playerHand = new ArrayList<Integer>();
        ArrayList<Integer> dealerHand = new ArrayList<Integer>();
        //merge totals and hands into the same array later with different indexes
        int[] playerTotal = new int[1];
        int[] dealerTotal = new int[1];
        System.out.print("Deal or no deal? ");
        String gameStart = console.nextLine();
        while((!gameStart.equalsIgnoreCase("deal")) && (!gameStart.equalsIgnoreCase("quit"))){
            System.out.print("Deal or no deal? ");
            gameStart = console.nextLine();
            System.out.println();
        }
        if(gameStart.equalsIgnoreCase("deal")){
            playerHand.clear();
            dealerHand.clear();
            playerTotal[0] = playerStart(playerHand, r);
            dealerTotal[0] = dealerStart(dealerHand, r);
            System.out.println();
        }
        else{
            return;
        }
        System.out.print("Hit or Stand? ");
        String deal = console.nextLine();
        System.out.println();
        while((!deal.equalsIgnoreCase("hit")) && (!deal.equalsIgnoreCase("stand"))){
            System.out.print("Hit or Stand? ");
            deal = console.nextLine();
            System.out.println();
        }
        while(deal.equalsIgnoreCase("hit") && playerTotal[0] < 21){
            if((!deal.equalsIgnoreCase("hit")) && (!deal.equalsIgnoreCase("stand"))){
                System.out.println("Please type in either \"hit\" or \"stand\".");
            }
            hit(playerTotal, playerHand, r);
            if(playerTotal[0] > 21){
                System.out.println("Bust! Cards: " + playerHand+ " Hand: " + playerTotal[0]);
            }
            else if(playerTotal[0] == 21){
                System.out.println("Blackjack! You win! Cards: " + playerHand+ " Hand: " + playerTotal[0]);
            }
            else{
                System.out.println("Your cards are: " + playerHand);
                System.out.println("Your hand total: " + playerTotal[0]);
                System.out.println("Dealer's cards are: " + dealerHand);
                System.out.println("Dealer's hand total: " + dealerTotal[0]);
                System.out.print("Hit or Stand? ");
                deal = console.nextLine();
            }
            System.out.println();
        }
        if(deal.equalsIgnoreCase("stand")){
            while(dealerTotal[0] <= 17){
                int dealerCards = randomCard(r);
                dealerHand.add(dealerCards);
                dealerTotal[0] += dealerCards;
            }
            if(dealerTotal[0] > playerTotal[0] && dealerTotal[0] <= 21){
                System.out.println("Dealer Wins!");
            }
            else if(playerTotal[0] == dealerTotal[0]){
                System.out.println("Push");
            }
            else{
                System.out.println("You Win!");
            }
            System.out.println();
            System.out.println("Your cards are: " + playerHand);
            System.out.println("Your hand total: " + playerTotal[0]);
            System.out.println("Dealer's cards are: " + dealerHand);
            System.out.println("Dealer's hand total: " + dealerTotal[0]);
        }

    }

    public static int dealerStart(ArrayList dealerHand, Random r){
        int dealerCard = randomCard(r);
        dealerHand.add(dealerCard);
        System.out.println("Dealer's card is: " + dealerHand);
        System.out.println("Dealer's hand total: " + dealerCard);
        return dealerCard;
    }

    //randomCard method returns a random number between 1-11

    public static int randomCard(Random r){
        return r.nextInt(11) + 1;
    }

    // playerStart starts an instance of a new Blackjack game
    public static int playerStart(ArrayList playerHand, Random r){
        int playerTotal= 0;
        for(int i = 0; i < 2; i++){
            int cardDealt = randomCard(r);
            playerTotal += cardDealt;
            playerHand.add(cardDealt);
        }
        System.out.println("Your cards are: " + playerHand);
        System.out.println("Your hand total: " + playerTotal);
        return playerTotal;
    }

    // hit method adds a new random card to the players hand and totals the sum of the cards
    public static void hit(int[] playerTotal, ArrayList playerHand, Random r){
        int cardDealt = randomCard(r);
        playerTotal[0] += cardDealt;
        playerHand.add(cardDealt);
    }

    public static boolean game(){
        Random r = new Random();
        int total = 0;
        while(total <= 17){
            int num = r.nextInt(10)+1;
            total += num;
            System.out.print(num + " ");
        }
        System.out.println(" = " + total);
        if(total > 21){
            System.out.println("Lose");
            return false;
        }
        else if(total == 21){
            System.out.println("Blackjack!");
            return true;
        }
        else{
            System.out.println("Win");
            return true;
        }
    }
}