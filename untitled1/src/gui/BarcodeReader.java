package gui;

public class BarcodeReader {
    private int scannedBarcode;
    private int barcodeExpirationDate;
    private int barcodePrice;
    private int errorStatus;

    public int getBarcodeNumber(){
        return scannedBarcode;
    }

    public int getBarcodeExpirationDate() {
        return barcodeExpirationDate;
    }

    public int getBarcodePrice() {
        return barcodePrice;
    }

    public int getErrorStatus() { //없길래일단추가
        return errorStatus;
    }
    public void readBarcode(int barcodeNumber){
        this.scannedBarcode=barcodeNumber;
    }
    public int handleError;
}
