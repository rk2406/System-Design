import models.Order;

public class OrderManager {
    OrderExecutioner orderExecutioner;

    OrderManager(OrderExecutioner orderExecutioner){
        this.orderExecutioner = orderExecutioner;
    }

    public void placeOrder(String userId, Order order){
        if(OrderValidator.validateOrder(userId,order)){
            orderExecutioner.placeOrder(userId,order);
        }
    }
}
