package models;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ATM {
    Location location;
    Map<Integer, Note>   notes ;

    Balance balance;

    public ATM(Location location, Map<Integer, Note>  notes, Balance balance) {
        this.location = location;
        this.notes = notes;
        this.balance = balance;
        setTotalBalance(notes);
    }

    public Map<Integer, Note>  getNotes() {
        return notes;
    }

    public void setNotes(Map<Integer, Note>  notes) {
        this.notes = notes;
    }

    public int totalBalance() {
        return balance.getAmount();
    }

    public void setTotalBalance(Map<Integer, Note>  notes) {
        AtomicInteger totalNotes = new AtomicInteger();
        AtomicInteger totalAmount = new AtomicInteger();

        for (Map.Entry<Integer, Note> me : notes.entrySet()) {
            totalAmount.addAndGet(me.getValue().getDenomination() * me.getValue().getNumberOfNote());
            totalNotes.addAndGet(me.getValue().getNumberOfNote());
        }

        this.balance.setAmount(totalAmount.get());
        this.balance.setNumberOfNotes(totalNotes.get());
    }
}
