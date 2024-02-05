import models.Order;

public class OrderExecutioner {
    OrderExecutioner(){

    }
    public void placeOrder(String userId, Order order){
//        ExchangeConnector exchangeConnector= ExchangeConnector.getExchangeConnectorInstance();
        ExchangeConnector.sendOrderToExchange(userId,order);
    }
}
