package services;

import models.UserPassbook;

import java.util.Map;

public class ShowPassbook {
    public static void showForAll(Map<Integer, UserPassbook> userPassbookMap){
        for(Map.Entry<Integer, UserPassbook> user: userPassbookMap.entrySet()){
            System.out.println("User "+user.getKey());
            System.out.println("Balance "+user.getValue().getAmount());
        }
    }

    public static void showForAll(Map<Integer, UserPassbook> userPassbookMap,int userId){
            System.out.println("User "+userId);
            System.out.println("Balance "+userPassbookMap.get(userId).getAmount());
    }

    public static  void showTransaactions(){
        for(Map.Entry<String, Double> user: ExpenseCalculator.transactionMap.entrySet()){
            System.out.println(user.getKey());
            System.out.println(user.getValue());
        }
    }
}
