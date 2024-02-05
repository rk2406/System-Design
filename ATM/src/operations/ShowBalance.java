package operations;

import models.ATM;
import models.Card;

public class ShowBalance implements Operation{
    private static  Operation operation;

        private ShowBalance(){
        super();
    }

    public static synchronized Operation getInstance()
    {
        if (operation == null)
            operation = new ShowBalance();

        return operation;
    }
    @Override
    public void start() {
        System.out.println("Showing Balance");
    }

    public void execute(Card card) {
        System.out.println("Current balance "+ card.getBalance());
    }

    @Override
    public void execute(Card card, String pin) {

    }

    @Override
    public void execute(Card card, ATM atm, int amount) {

    }
}
