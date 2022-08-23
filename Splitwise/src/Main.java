import constants.ExpenseTypes;
import models.Expenses;
import models.User;
import models.UserPassbook;
import services.ExpenseCalculator;
import services.ShowPassbook;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to splitwise");
        System.out.println("1 for SHOW");
        System.out.println("2 for SHOW USER ID");
        System.out.println("3 for EXPENSE");

        Map<Integer, UserPassbook> userPassbookMap= new HashMap<>();
        Map<Integer,User> users= new HashMap<>();
        ExpenseCalculator expenseCalculator= new ExpenseCalculator(users,userPassbookMap);
        ExpenseCalculator.transactionMap= new HashMap<>();

        boolean flag=true;
        Scanner sc=new Scanner(System.in);
        while(flag){
            System.out.println("Enter choice");
            int choice= sc.nextInt();
            switch (choice) {
                case 1 -> {
                    if(ExpenseCalculator.transactionMap.size()==0)System.out.println("Empty transaction history");
                    else ShowPassbook.showTransaactions();
                }
                case 2 -> {
                    if(ExpenseCalculator.userPassbookmap.size()==0)System.out.println("Empty passbook");
                    else {
                        System.out.println("Please enter the user id for which you want to show balances");
                        int userIdDisplayed = sc.nextInt();
                        ShowPassbook.showForAll(ExpenseCalculator.userPassbookmap, userIdDisplayed);
                    }
                }
                case 3 -> {
                    System.out.println("Please enter the user id who paid");
                    int userId = sc.nextInt();
                    System.out.println("Enter total amount paid");
                    Double totalAmount = sc.nextDouble();

                    Utils.setUsers(sc,expenseCalculator);

                    System.out.println("Type of expense");
                    String type = sc.next();

                    if (ExpenseTypes.valueOf(type) == ExpenseTypes.EQUAL) {
                        expenseCalculator.calculateBalances(new Expenses(totalAmount, userId, ExpenseTypes.valueOf(type)));
                    } else if (ExpenseTypes.valueOf(type) == ExpenseTypes.EXACT || ExpenseTypes.valueOf(type) == ExpenseTypes.PERCENT) {
                        if(Utils.setExactOrPercentBalances(sc,type,totalAmount,userId)){
                            expenseCalculator.calculateBalances(new Expenses(totalAmount, userId, ExpenseTypes.valueOf(type)));
                        }
                        else {
                            System.out.println("The amount owed is greater than total amount");
                        }
                    }
                }
                default -> flag = false;
            }
        }

    }
}