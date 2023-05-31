package kiosk_class;

public class CardReader {
    private int cardNumber;
    private int cardExpirationDate;
    private int isCardInsertion;
    private int errorStatus;

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCardExpirationDate() {
        return cardExpirationDate;
    }

    public int readCardData(int cardNumber, int cardExpirationDate){
        return 0;
    }
    public int handleError(){
        return 0;
    }
}
