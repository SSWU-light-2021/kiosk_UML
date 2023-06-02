package kiosk_class;

public class CardReader {
    private long cardNumber;
    private int  cardExpirationDate;
    private boolean isCardInsertion;
    private String errorStatus = "카드 읽기 실패";
    private String successStatus = "카드 읽기 성공";
    public long getCardNumber() {
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
    public String inputCardInfo(boolean isCardInsertion) {
        if (this.isCardInsertion = isCardInsertion) {
            this.cardNumber = 1234567891021098l;
            this.cardExpirationDate = 0426;
            return successStatus;
        }
        else {
            return errorStatus;
        }
    }
}
