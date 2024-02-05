package models;

public class Note {
    private int numberOfNote;
    private int denomination;

    public Note(int numberOfNote, int denomination) {
        this.numberOfNote = numberOfNote;
        this.denomination = denomination;
    }

    public int getNumberOfNote() {
        return numberOfNote;
    }

    public void setNumberOfNote(int numberOfNote) {
        this.numberOfNote = numberOfNote;
    }

    public int getDenomination() {
        return denomination;
    }
}
