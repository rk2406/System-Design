package models;

public class Balance {
    private int amount;
    private int numberOfNotes;

    public Balance(int amount, int numberOfNotes) {
        this.amount = amount;
        this.numberOfNotes = numberOfNotes;
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfNotes() {
        return numberOfNotes;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setNumberOfNotes(int numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
    }
}
