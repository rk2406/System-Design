package services;

import constants.ExpenseTypes;
import lombok.Data;
import models.Expenses;
import models.User;
import models.UserPassbook;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Data
public class ExpenseCalculator {
    private Map<Integer,User> users;

    public static Map<String, Double> transactionMap;

    public static Double amountOwed;
    public static Map<Integer,UserPassbook> userPassbookmap;

    private Map<Integer,Double> individualAmountOwed;

    public ExpenseCalculator(Map<Integer, User> users, Map<Integer, UserPassbook> userPassbookmap) {
        this.users = users;
        this.userPassbookmap = userPassbookmap;
    }

    public void calculateBalances(Expenses expenses){
        if(expenses.getType()== ExpenseTypes.EQUAL) splitEqually(expenses.getUserId(),expenses.getAmount());
        else splitExactly(expenses.getUserId(),expenses.getAmount());
    }

    private void splitEqually(int userId, Double amount) {
        DecimalFormat df = new DecimalFormat("####0.00");
        Double amountOwed= Double.valueOf(df.format(amount/users.size()));
        for(Map.Entry<Integer,User> user: users.entrySet()){
            UserPassbook userPassbook=userPassbookmap.get(user.getKey());

            if(userId==user.getKey()) {
                userPassbook.setAmount(userPassbook.getAmount()+amount-amountOwed);
            }
            else {
                userPassbook.setAmount(userPassbook.getAmount()-amountOwed);
                String key= user.getValue().getName()+" owes "+ users.get(userId).getName();
                if (transactionMap.containsKey(key)){
                    Double value= ExpenseCalculator.transactionMap.get(key).doubleValue();
                    ExpenseCalculator.transactionMap.put(key,value+amountOwed);
                }
                else{
                    ExpenseCalculator.transactionMap.put(key,amountOwed);
                }
            }
            userPassbookmap.put(user.getKey(),userPassbook);
        }
    }

    private void splitExactly(int userid, Double amount){
        UserPassbook userPassbook=userPassbookmap.get(userid);
        userPassbook.setAmount(userPassbook.getAmount()+ExpenseCalculator.amountOwed);
        userPassbookmap.put(userid,userPassbook);
    }
}
