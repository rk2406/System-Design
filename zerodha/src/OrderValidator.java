import models.Order;
import models.User;
import models.UserSystem;
import models.common.*;

class OrderValidator {
    public static boolean validateOrder(String userId, Order order){
        User user = UserSystem.getUser(userId);
        if(order.getTransactionType() == TXN_TYPE.BUY){
            System.out.println("Checking if user has enough funds");
            if(order.getPrice()*order.getQuantity() > user.getFunds()){
                System.out.println("Insufficient funds");
                return false;
            }
        }else{
            System.out.println("Checking if user has stocks to sell");
        }
        System.out.println("Assuming user has made valid request");
        return true;
    }
}
