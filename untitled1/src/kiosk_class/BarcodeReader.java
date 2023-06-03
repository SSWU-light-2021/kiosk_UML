package kiosk_class;

public class BarcodeReader {
    private int barcodeNum;
    private boolean isBarcodeScanned;
    private int barcodeExpirationDate;
    private int barcodePrice;
    private String  errorStatus = "바코드 읽기 실패";
    private String successStatus = "바코드 읽기 성공";
    public int getBarcodeNumber(){
        return barcodeNum;
    }

    public int getBarcodeExpirationDate() {
        return barcodeExpirationDate;
    }

    public int getBarcodePrice() {
        return barcodePrice;
    }

    public String getErrorStatus() { //없길래일단추가
        return errorStatus;
    }
    public int readBarcode(){
        return barcodeNum;
    }
    public int handleError;
    public String inputBarcodeInfo(boolean isBarcodeScanned) {
        if(this.isBarcodeScanned == isBarcodeScanned) {
            this.barcodeNum = 12345678;
            this.barcodePrice = 5000;
            this.barcodeExpirationDate = 240608;
            return successStatus;
        }
        return errorStatus;
    }

}
