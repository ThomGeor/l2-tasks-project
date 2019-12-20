package exceptions;

// Exception when the amount of the payer's wallet isn't enough

public class MissAmountException extends Exception {
    private int missingAmount, walletAmount;

    public MissAmountException(String message, int missingAmount, int walletAmount) {
        super(message);
        this.missingAmount = missingAmount;
        this.walletAmount = walletAmount;
    }

    public int getMissingAmount() {
        return missingAmount;
    }

    public int getWalletAmount() {
        return walletAmount;
    }
}
