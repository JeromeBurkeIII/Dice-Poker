import javax.swing.*;
import java.util.*;

/**
 * Code creator Jerome Burke III , StudentNumber: 40603291
 * This game is called dice Poker.
 * Game summary:
 * it is played with two dice. where the player makes a bet. The computer rolls the two dice.
 * if the dices are in a sequential order  the player's bet amount doubles. If both dices have the same value the bet amount is then tripled.
 *if none of these conditions are met the player loses there bet amount.
 * the game end if the player bank balance is zero or five rounds have been played.
 * at the end of the game the result of each round would be displayed.
 * after the result display is closed the high score table would be shown
 */
public class Main {

    /**
     *
     * Main calls the Start Game class
     */

    public static void main(String[] args) {


        startGame();

    }

    /**
     * the startGame method  Welcomes the user to the game
     * It would then would the user for their name.
     *
     */
    public static void startGame() {
        int bank = 6;//player starting bank balance
        int count = 1;// round count
        String name;// store's player's name
        String output = "Welcome to Dice Poker, please push Ok to start"; // store's output statements

        List<Player> list = new ArrayList<>();// high score table list
        boolean gameControlLoop = true;//condition used to determine if the player wants to play again
        int userInput;// save the user yes or no response

        //loop control how many times the game is played
        while (gameControlLoop) {

            // Welcome, Prompt
            JOptionPane.showMessageDialog(null, output, "Welcome", JOptionPane.INFORMATION_MESSAGE);

            // changing the output message
            output = "Please enter you name ";

            // asking user to enter their name
            name = JOptionPane.showInputDialog(null, output, "Follow the instructions ", JOptionPane.INFORMATION_MESSAGE);

            // creating an instances of the player
            Player player = new Player(name, bank);

            //creating an instances of the ResultList class
            ResultList resultList = new ResultList();

            // loop controls the end game condition if player's bank amount is 0 the game ends or if five turns has been
            while ((player.getBank() > 0) && (count < 6)) {

                //the results of the round is being added to the resultList object
                resultList.addResults(diceRoll(player, count));

                //keeping a count of the number of rounds played
                count++;


            }//end loop

            // displaying the results of each round
            resultList.printResultList();

            // adding player to highs-core list
            list.add(player);

            // displaying the high-score table
            displayHighScore( list);



            //asking user if they would like to play again with a yes or no option
            userInput = JOptionPane.showConfirmDialog(null, "Would you like to play again", "Game Over ? ", JOptionPane.YES_NO_OPTION);

            // if yes the game would being again if no the loop would end
            if (userInput == JOptionPane.YES_OPTION) {
                count = 1;
                output = "Welcome to Dice Poker, please push Ok to start";
            } else if (userInput == JOptionPane.NO_OPTION) {
                gameControlLoop = false;
            }

        }
        //The end game message
        JOptionPane.showMessageDialog(null, "Thank you for playing good bye", "Game Over", JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * This Method allows the player to enter a bet amount 1-4 pounds inclusive.
     * after the computer rolls two dice  if the dices are  isSequential the bet amount is double
     * if the dices have the same value the bet amount is tripled.
     * if none of these win conditions are met the player loses their bet amount
     *
     */
    public static Results diceRoll(Player player, int count) {
        Dice dice1 = new Dice();// creating the first instance of the dice class
        Dice dice2 = new Dice();//creating the second instance of the dice class
        String output; // hold the output statement
        int betAmount = 0;// holds player bet amount
        int rewardAmount;// hold the player bet amount winnings
        boolean control = true;
        int isSequential;

        // creates an instance of the player class
        Results results = new Results();

        // output string storing information to be displayed
        output = "Your current bank amount is: £" + player.getBank();

        //outputs the player's current bank balance
        JOptionPane.showMessageDialog(null, output, "Player bank information", JOptionPane.INFORMATION_MESSAGE);
        // output string storing information to be displayed
        output = " Enter your bet amount of  £1, £2, £3 or £4";

        // loop that checks if the player entered a value bet amount. The bet amount can not be greater than the amount the player has in the bank, and it can be more than four
        while (control) {
            try {
                betAmount = Integer.parseInt(JOptionPane.showInputDialog(null, output, "Round " + count, JOptionPane.INFORMATION_MESSAGE));

                if ((betAmount > 4 || betAmount <= 0) || (player.getBank() < betAmount)) {
                    JOptionPane.showMessageDialog(null, "An invalid bet amount was entered", "Bet amount error", JOptionPane.ERROR_MESSAGE);
                } else {
                    control = false;
                }


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An invalid input was entered", "Bet amount error", JOptionPane.ERROR_MESSAGE);

            }
        }




        player.setBet(betAmount);//player Bet amount is being added to the player object

        dice1.roll();// dice one is calling the class method roll to get a random number from 1 to 6
        dice2.roll(); // dice one is calling the class method roll to get a random number from 1 to 6

        // storing the information to be displayed
        output = "Dice one rolled: " + dice1.getDiceValue() + "\n" + "Dice two rolled: " + dice2.getDiceValue();

        // displaying the result of the dice rolls
        JOptionPane.showMessageDialog(null, output, "Dice value", JOptionPane.INFORMATION_MESSAGE);
        // the absolute math function is used so that the result of-the operation would always be a non-negative value
        isSequential = Math.abs(dice1.getDiceValue() - dice2.getDiceValue());

        //if dice 1 and dice 2 are the same  the user bet is  tripled
        if (dice1.getDiceValue() == dice2.getDiceValue()) {

            output = "You have gotten a double your bet amount would be tripled";

            JOptionPane.showMessageDialog(null, output, "reward", JOptionPane.INFORMATION_MESSAGE);
            rewardAmount = betAmount * 3;
            player.addToBank(rewardAmount);

            results.addResults(player, dice1, dice2, count);


            return results;

            //if dice 1 is sequential to dice 2 they would be only a 1 value difference.this is why we need the absolute value
        } else if (isSequential == 1) {
            output = "You have gotten sequential numbers your bet amount would be double";

            JOptionPane.showMessageDialog(null, output, "reward", JOptionPane.INFORMATION_MESSAGE);
            rewardAmount = betAmount * 2;
            player.addToBank(rewardAmount);

            results.addResults(player, dice1, dice2, count);

            return results;
            // player lose their bet amount
        } else {

            output = "You lost your bet amount";

            JOptionPane.showMessageDialog(null, output, "reward", JOptionPane.INFORMATION_MESSAGE);

            results.addResults(player, dice1, dice2, count);// round results is added to the result object.

            return results;

        }

    }

    /**
     *
     * This method displays the high-score table in ascending order
     */
    public static void displayHighScore( List<Player> list) {
        String highScore = "";//use to hold the output results

        list.sort(Collections.reverseOrder());// sorts the player objects in the list in ascending order

        // loop iterates to the end of the List
        for (Player temp : list) {
            highScore = highScore + "\n" + temp.getName() + "  £" +temp.getBank();// the player name and bank amount store in high score string variable

        }
        JOptionPane.showMessageDialog(null, highScore, "High Score Table", JOptionPane.INFORMATION_MESSAGE);// High-score table is displayed


    }


}