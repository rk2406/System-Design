package models;

import constants.ExpenseTypes;
import lombok.Data;

@Data
public class Expenses {
    private Double amount;
    private int userId;
    private ExpenseTypes type;

    public Expenses(Double amount, int userId, ExpenseTypes type) {
        this.amount = amount;
        this.userId = userId;
        this.type = type;
    }
}
