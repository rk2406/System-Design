package operations;

import models.ATM;
import models.Card;

public interface Operation {
     public void start();
     public void execute(Card card);
     public void execute(Card card, String pin);
     public void execute(Card card, ATM atm, int amount);
}
