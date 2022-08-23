import constants.ExpenseTypes;
import models.User;
import models.UserPassbook;
import services.ExpenseCalculator;

import java.util.Map;
import java.util.Scanner;

public class Utils {

    public static int noOfUsers;


    public static void setUsers(Scanner sc, ExpenseCalculator expenseCalculator){
        System.out.println("Please enter the total no of users involved in transaction");
        int noOfUsers = sc.nextInt();
        Utils.noOfUsers=noOfUsers;
        Map<Integer,User> users= expenseCalculator.getUsers();
        Map<Integer,UserPassbook> userPassbookMap= ExpenseCalculator.userPassbookmap;
        while (noOfUsers > 0) {
            System.out.println("user ID");
            int id = sc.nextInt();
            if (!users.containsKey(id)) {
                System.out.println("user name");
                String name = sc.next();
                User user = new User(id, name);
                users.put(id, user);
                UserPassbook userPassbook = new UserPassbook(user, (double) 0);
                userPassbookMap.put(id, userPassbook);
            }
            noOfUsers--;
        }
        expenseCalculator.setUsers(users);
    }

    public static boolean setExactOrPercentBalances(Scanner sc, String type, Double totalAmount, int userId){
        int n = Utils.noOfUsers;
        Double amountOwed= (double) 0;
        while (n > 1) {
            System.out.println("user id");
            int id = sc.nextInt();
            Double exactAmount;
            if (ExpenseTypes.valueOf(type) == ExpenseTypes.EXACT) {
                System.out.println("Exact amount");
                exactAmount = sc.nextDouble();
                amountOwed+= exactAmount;
            } else {
                System.out.println("Percent amount");
                Double percentAmount = sc.nextDouble();
                exactAmount = (percentAmount / 100) * totalAmount;
                amountOwed+=exactAmount;
            }
            if(amountOwed>totalAmount) return false;
            ExpenseCalculator.amountOwed=amountOwed;
            UserPassbook userPassbook = ExpenseCalculator.userPassbookmap.get(id);
            userPassbook.setAmount(userPassbook.getAmount() - exactAmount);
            ExpenseCalculator.userPassbookmap.put(id, userPassbook);

            String key= ExpenseCalculator.userPassbookmap.get(id).getUser().getName()+" owes "+ ExpenseCalculator.userPassbookmap.get(userId).getUser().getName();
            if (ExpenseCalculator.transactionMap.containsKey(key)){
                Double value= ExpenseCalculator.transactionMap.get(key);
                ExpenseCalculator.transactionMap.put(key,value+exactAmount);
            }
            else{
                ExpenseCalculator.transactionMap.put(key,exactAmount);
            }

            n--;
        }
        return true;
    }
}
