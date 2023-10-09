public class Player implements Comparable<Player>  {


    /**
     *  Declaring class variables
     *
     **/
    private int bank; // Stores the player's current bank amount
    private String name;// Stores the player's name

    private int bet;// Stores the player's bet amount
    private int bankPrevious;//  Stores the player's  previous


    /**
     *  Player class constructor  is  initializing all instance variables
     **/
    public Player(String name, int bank) {
        this.name = name;
        this.bank = bank;
        this.bet = 0;
        this.bankPrevious = 0;
    }

    /***
     *  this method adds an amount to the player's bank
     *
     */
    public void addToBank(int amount) {
        this.bank += amount;
    }


    /**
     *
     * This method compares player class objects and sort them base
     */
    @Override
    public int compareTo(Player player) {
        return Integer.compare(this.bank, player.getBank());
    }

    /**
     * The getters and setters
     *
     */


    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {

        this.bet = bet;
        this.bankPrevious = bank;
        this.bank = this.bank - bet;
    }

    public int getBankPrevious() {
        return bankPrevious;
    }



    public int getBank() {
        return bank;
    }



    public void setBank(int bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }


}
