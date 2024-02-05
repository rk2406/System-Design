import models.Order;
import models.Stock;
import models.User;
import models.UserSystem;
import models.common.*;

public class Main {
    public static void main(String[] args) {
        User user = new User(10000,"Rajat");
        UserSystem.addUser("Rajat", user);
        Stock stock = new Stock(EXCHANGE.NSE,"TCS",100);
        Order order = new Order(ORDER_TYPE.LIMIT,TXN_TYPE.BUY,stock, 100, 100);
        OrderManager orderManager = new OrderManager(new OrderExecutioner());
        orderManager.placeOrder(user.getUserId(), order);
    }
}