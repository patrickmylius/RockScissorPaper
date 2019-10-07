import java.util.Scanner;


public class RockScissorPaper {

    public static void startGame() {
        RockScissorPaper round1 = new RockScissorPaper();

        int count = 1;
        while (count >= 1) {

            // Players hand input
            Scanner input = new Scanner(System.in);
            System.out.println("Round" + count + " - choose between (stone, scissor or paper) ?");
            Hand playersHand = null;
            String playersString = input.next();

            if (playersString.equalsIgnoreCase("stone")) { playersHand = Hand.STONE; }
            if (playersString.equalsIgnoreCase("scissor")) { playersHand = Hand.SCISSOR; }
            if (playersString.equalsIgnoreCase("paper")) { playersHand = Hand.PAPER; }
            //Input endgame to stop playing new hands.
            if (playersString.equalsIgnoreCase("endgame")) { break; }

            System.out.println("Player picked " + playersHand);

            // Computers hand
            Hand computersHand = null;
            int handInt = (int) (Math.random() * 3+1);
            //Computers hand values
            if (handInt == 1) { computersHand = Hand.STONE; }
            if (handInt == 2) { computersHand = Hand.SCISSOR; }
            if (handInt == 3) { computersHand = Hand.PAPER; }
            System.out.println("Computer chooses " + computersHand);

            //Compare picks method ()
            int result = round1.choice(playersHand, computersHand);

            // Call the winner out
            if (result == 1) { System.out.println("You've WON! "); }
            if (result == 2) { System.out.println("You've LOST! "); }
            if (result == 0) { System.out.println("It's a tie! "); }
            if (result == -1) { System.out.println("MEH, try again! "); }

            count++;
                    }
                }
                /** If the first hand wins, 1 will be returned
                 * If the second hand wins, 2 will be returned
                 * If its a tie, 0 will be returned
                 * If an erroe occurs, -1 will be returned **/
                int choice(Hand a, Hand b) {

                    int result = -1;

                    //First hand is STONE.
                    if (a == Hand.STONE) {
                    //Second hand is STONE
                    if (b == Hand.STONE) { result = 0; }
                    //Second hand is SCISSOR
                    if (b == Hand.SCISSOR) { result = 1; }
                    //Second hand is PAPER
                    if (b == Hand.PAPER) { result = 2; }

            }
                   //First hand is SCISSOR
                    if (a == Hand.SCISSOR) {
                        //Second hands below
                        if (b == Hand.STONE) { result = 2; }
                        if (b == Hand.SCISSOR) { result = 0; }
                        if (b == Hand.PAPER) { result = 1; }
                    }
                    //First hand is PAPER
                    if (a == Hand.PAPER) {
                        //Second hands below.
                        if (b == Hand.STONE) { result = 1; }
                        if (b == Hand.SCISSOR) { result = 2; }
                        if (b == Hand.PAPER) { result = 0; }
                    }

                    return  result;
        }
    }

