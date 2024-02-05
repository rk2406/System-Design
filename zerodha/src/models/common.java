package models;

public class common {

    public enum TXN_TYPE{
        BUY,
        SELL
    };

    public enum ORDER_TYPE{
        MARKET,
        LIMIT
    };

    public enum EXCHANGE{
        NSE,
        BSE
    };

    enum ORDER_STATUS{
      DONE,
      PARTIALLY_DONE,
      CANCELLED,
      OPEN
    };

}
