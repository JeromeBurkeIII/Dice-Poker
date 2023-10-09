import java.util.Random;

public class Dice {


    private int diceValue;//stores the face value of the dice

    /**
     * Constructor used to initializing the diceValue
     */

    public Dice() {

        this.diceValue = 0;
    }


    /**
     * This method creates an instance of the Random class.
     * The random instance was used to set diceValue to a random number for 1 to 6
     */
    public void roll() {


        Random random = new Random();

        this.diceValue = random.nextInt(7 - 1) + 1;


    }


    /**
     * This method gets the dice value
     */
    public int getDiceValue() {
        return diceValue;
    }


}
