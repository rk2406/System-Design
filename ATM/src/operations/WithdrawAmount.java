package operations;

import models.ATM;
import models.Card;
import models.Note;
import java.util.Map;

public class WithdrawAmount implements Operation{
    private static  Operation operation;

    private WithdrawAmount(){
        super();
    }

    public static synchronized Operation getInstance()
    {
        if (operation == null){
            operation = new WithdrawAmount();
        }

        return operation;
    }

    @Override
    public void start() {
        System.out.println("Withdrawing amount");
    }

    @Override
    public void execute(Card card) {

    }

    @Override
    public void execute(Card card, String pin) {

    }

    public void execute(Card card, ATM atm, int amount) {
        int totalAmount = amount;
        if(card.getBalance() < amount){
            System.out.println("Insufficient funds in account");
        }
        else if(atm.totalBalance() <amount){
            System.out.println("Insufficient funds in ATM");
        }
        else{
            Map<Integer, Note> notes = atm.getNotes();
            for (Map.Entry<Integer, Note> me : notes.entrySet()) {
                if(amount > 0){
                    Note note = me.getValue();
                    if(notes.get(note.getDenomination()).getNumberOfNote()> 0){
                        int amountWithdrawn = Math.min(note.getNumberOfNote()* note.getDenomination(), note.getDenomination()*(amount/ note.getDenomination()));
                        note.setNumberOfNote(note.getNumberOfNote() - amountWithdrawn/note.getDenomination());
                        notes.put(note.getDenomination(), note);
                        amount-= amountWithdrawn;
                    }
                }
                else break;
            }

            atm.setTotalBalance(notes);
            card.setBalance(card.getBalance()-totalAmount);

        }
    }
}
