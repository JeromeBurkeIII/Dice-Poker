import javax.swing.*;
import java.util.LinkedList;

public class ResultList {

    /**
     *  Declaring class variables
     *
     **/

    private LinkedList<Results> resultsList = new LinkedList<>(); //

    /**
     *  ResultList class constructor
     **/
    public ResultList() {

    }

    /**
     *
     * This Method adds a result class to the resultList linked list
     */
    public void addResults(Results results) {
        this.resultsList.addLast(results);

    }

    /**
     * This method prints the result at the end of the game
     * which is round 5.
     */
    public void printResultList() {
        String output = "";
        int bankAmountRemaining = 0;

        //
        for (Results r : resultsList) {
            output = output + "Round: " + r.getRound() + " Bet Amount: £" + r.getBetAmount() + " Dice 1: " + r.getDice1Value() + " Dice 2: " + r.getDice2Value() + "  " + r.getResult() + "\n";

            bankAmountRemaining = r.getBankAmountRemaining();
        }

        output = output + "\n" + "Players remaining money is: £" + bankAmountRemaining;


        JOptionPane.showMessageDialog(null, output, "Results", JOptionPane.INFORMATION_MESSAGE);


    }


}
