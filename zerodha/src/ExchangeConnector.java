import models.Order;

class ExchangeConnector {
    private static ExchangeConnector exchangeConnectorInstance = null;
    private static Object mutex = new Object();
    private ExchangeConnector(){

    }

     public static ExchangeConnector getExchangeConnectorInstance(){
        if(exchangeConnectorInstance == null){
            synchronized (mutex){
                exchangeConnectorInstance = new ExchangeConnector();
            }
        }
        return exchangeConnectorInstance;
    }

    public static void sendOrderToExchange(String userId, Order order){
        System.out.println("Sending it to exchange");
    }
}
