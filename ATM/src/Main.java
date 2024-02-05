import models.*;
import operations.ChangePin;
import operations.Operation;
import operations.ShowBalance;
import operations.WithdrawAmount;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Location location = new Location("Bengaluru","560100");

        Note thousand = new Note(10,1000);
        Note fiveHundred = new Note(20,500);
        Note oneHundred = new Note(10,100);

        Map<Integer, Note> notes = new TreeMap<>(Comparator.reverseOrder());
        notes.put(thousand.getDenomination(),thousand);
        notes.put(fiveHundred.getDenomination(),fiveHundred);
        notes.put(oneHundred.getDenomination(),oneHundred);

        Balance balance = new Balance(0,0);

        ATM atm = new ATM(location, notes,balance);

        Card card = new Card(10000,"560100","1212","RUPASA");

        Operation changePin = ChangePin.getInstance();
        changePin.start();
        changePin.execute(card,"2424");
        System.out.println(card.getPin());

        Operation showBalance = ShowBalance.getInstance();
        showBalance.start();
        showBalance.execute(card);

        System.out.println(atm.totalBalance());
        Operation withdrawBalance = WithdrawAmount.getInstance();
        withdrawBalance.start();
        withdrawBalance.execute(card,atm,7500);
        showBalance.execute(card);
        System.out.println(atm.totalBalance());

        withdrawBalance.start();
        withdrawBalance.execute(card,atm,2400);
        showBalance.execute(card);
        System.out.println(atm.totalBalance());
    }
}