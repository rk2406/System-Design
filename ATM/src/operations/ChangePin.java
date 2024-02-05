package operations;

import models.ATM;
import models.Card;

public class ChangePin implements Operation{
    private static volatile Operation operation;

    private ChangePin(){
        super();
    }

    public static Operation getInstance()
    {
        if (operation == null){
            synchronized (Operation.class){
                if(operation == null){
                    operation = new ChangePin();
                }
            }
        }

        return operation;
    }

    @Override
    public void start() {
        System.out.println("Changing PIN");
    }

    @Override
    public void execute(Card card) {

    }

    public void execute(Card card, String pin) {
        card.setPin(pin);
    }

    @Override
    public void execute(Card card, ATM atm, int amount) {

    }
}
