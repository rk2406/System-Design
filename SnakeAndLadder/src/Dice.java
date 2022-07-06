public class Dice {
    private int numberOfDice;

    Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice; // we can have 2 dices, 3 dices in the game and so on...
    }
    static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    int rollDice(){
        //for 4 dices , the max value we can get is 24 and min value we can get is 4
        return getRandomInteger(numberOfDice*6,numberOfDice*1);
    }
}
