import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Black Jack!");
        System.out.println("Ready? Press anything to begin!");
        
        scan.nextLine(); //Wait for the user to press a key to begin

        int yourCard1 = drawRandomCard();
        int yourCard2 = drawRandomCard();

        //Displaying the players cards
       System.out.println("\nYou get a\n" + cardString(yourCard1) + "\n and a \n" + cardString(yourCard2));
       
       //Face value cards get a total of 10
       int yourTotal = Math.min(yourCard1, 10) + Math.min(yourCard2, 10);
       System.out.println("Your total is: " + yourTotal); //Displaying the total of players cards
         
        
        //Get two random cards for the dealer.
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();

        System.out.println("The dealer shows \n" + cardString(dealerCard1) + "\nand has a card facing down \n"
        + faceDown());
       //Getting the dealer total but it is hidden
        int dealerTotal = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);
        System.out.println("\nThe dealer's total is hidden");

       
        //Keep asking the player to hit or stay
        while(true){
            String usersOption = hitOrStay();
            if (usersOption.equalsIgnoreCase("hit")){
               int newCard = drawRandomCard();
               yourTotal += Math.min(newCard, 10);

               System.out.println("\nYou get a\n" + cardString(newCard));
               System.out.println("Your new total is: " + yourTotal);
               
               //Check to see if player loses
               if (yourTotal > 21){
                   System.out.println("Bust! Player loses.");
                   System.exit(0);
               }
            } else{
                break;
            }
        }

        //Dealers turn
        System.out.println("\nDealer's turn");
        System.out.println("\nDealer's cards are\n" + cardString(dealerCard1) + "\n and a\n" + 
        cardString(dealerCard2));
        System.out.println("\nDealer's total is: " + dealerTotal);

        //Dealer keeps hitting until total gets to 17
        while(dealerTotal < 17){
            int dealerNewCard = drawRandomCard();

            System.out.println("\nDealer gets a\n" + cardString(dealerNewCard));
            dealerTotal += Math.min(dealerNewCard, 10);
            System.out.println("\nDealer's total is: " + dealerTotal);
        }

        //Dealer loses if dealers total is over 21
        if(dealerTotal > 21){
            System.out.println("Bust! Dealer loses");
            System.exit(0);
        }

        //Check to see who wins
        if(yourTotal > dealerTotal){
            System.out.println("Player wins!");
        }
        else if (yourTotal < dealerTotal){
            System.out.println("Dealer wins!");
        }
        else{
            System.out.println("Draw!");
        }

        
         scan.close();

    }

    //Function that returns a random number between 1 and 13
    public static int drawRandomCard(){
        double cardNumber = Math.random() * 13;
        cardNumber += 1;
        return (int) cardNumber; 
    }

    /**Function that returns a String drawing of the card.
     * @param cardNumber (int)
     * @return (String)
     */
    public static String cardString(int cardNumber){
     switch(cardNumber){
         case 1: 
         return "   _____\n"+
                "  |A _  |\n"+ 
                "  | ( ) |\n"+
                "  |(_'_)|\n"+
                "  |  |  |\n"+
                "  |____V|\n";

         case 2:
         return "   _____\n"+              
                "  |2    |\n"+ 
                "  |  o  |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____Z|\n";

         case 3:
         return "   _____\n" +
                "  |3    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  |  o  |\n"+
                "  |____E|\n";

         case 4:
         return "   _____\n" +
                "  |4    |\n"+
                "  | o o |\n"+
                "  |     |\n"+
                "  | o o |\n"+
                "  |____h|\n";

         case 5:
         return "   _____ \n" +
                "  |5    |\n" +
                "  | o o |\n" +
                "  |  o  |\n" +
                "  | o o |\n" +
                "  |____S|\n";

        case 6:
        return  "   _____ \n" +
                "  |6    |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  |____6|\n";

        case 7:
        return  "   _____ \n" +
                "  |7    |\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |____7|\n";

        case 8:
        return  "   _____ \n" +
                "  |8    |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  |____8|\n";

        case 9:
        return  "   _____ \n" +
                "  |9    |\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |____9|\n";

        case 10:
        return  "   _____ \n" +
                "  |10  o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |___10|\n";

        case 11:
        return  "   _____\n" +
                "  |J  ww|\n"+ 
                "  | o {)|\n"+ 
                "  |o o% |\n"+ 
                "  | | % |\n"+ 
                "  |__%%[|\n";

        case 12:
        return  "   _____\n" +
                "  |Q  ww|\n"+ 
                "  | o {(|\n"+ 
                "  |o o%%|\n"+ 
                "  | |%%%|\n"+ 
                "  |_%%%O|\n";

        case 13:
        return  "   _____\n" +
                "  |K  WW|\n"+ 
                "  | o {)|\n"+ 
                "  |o o%%|\n"+ 
                "  | |%%%|\n"+ 
                "  |_%%%>|\n";
        
        default:
        return ""; //impossible
     }
    }

    //Function for getting a face down card
    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /**Function that asks the user to hit or stay.
     * @return (String)
     */
    public static String hitOrStay(){
        System.out.println("Would you like to hit or stay? ");
        String hitStay = scan.nextLine();

        while(!(hitStay.equalsIgnoreCase("hit") || hitStay.equalsIgnoreCase("stay"))){
          System.out.println("Please write 'hit' or 'stay' ");
          hitStay = scan.nextLine();
        }
        return hitStay;
    }
    }