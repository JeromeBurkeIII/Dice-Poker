public class Results {

    /**
     *  Declaring class variables
     *
     **/
    private int betAmount;
    private int dice1Value;
    private int dice2Value;
    private String result;

    private int bankAmountRemaining;

    private int round;


    /**
     *  Results class constructor  is  initializing all instance variables
     **/
    public Results() {
        this.betAmount = 0;
        this.dice1Value = 0;
        this.dice2Value = 0;
        this.result = "";
        this.round = 0;
        this.bankAmountRemaining = 0;
    }

    /**
     *
     * This method Stores the results of each round of the game in this result class
     *
     *
     *
     */

    public void addResults(Player player, Dice dice1, Dice dice2, int count) {
        int value ;
        this.betAmount = player.getBet();// betAmount stores the players bet amount
        this.dice1Value = dice1.getDiceValue();// dice1Value stores the face value of first dice
        this.dice2Value = dice2.getDiceValue();// dice2Value stores the face value of the second dice
        this.round = count; // round stores the current game round
        this.bankAmountRemaining = player.getBank(); // bankAmountRemaining stores the current player bank amount


        /**The if condition below compares the player's current bank balance to the previous bank balance
         * if the current bank balance is greater than the previous bank balance  the player won that round
         * would be stored in the result variable string with the amount won from that round
         */

        if (player.getBank() > player.getBankPrevious()) {
            value = Math.abs(player.getBank()) - Math.abs(player.getBankPrevious());
            result = "Player has won: £" + Math.abs(value);
        } else {

            value = Math.abs(player.getBank()) - Math.abs(player.getBankPrevious());
            result = "Player has loss: £" + Math.abs(value);
        }


    }
    /**
     *
     *   Getter's
     */

    public int getBankAmountRemaining() {
        return bankAmountRemaining;
    }



    public int getRound() {
        return round;
    }


    public int getBetAmount() {
        return betAmount;
    }



    public int getDice1Value() {
        return dice1Value;
    }



    public int getDice2Value() {
        return dice2Value;
    }



    public String getResult() {
        return result;
    }


}
