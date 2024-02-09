public interface TransactionManager {
    public boolean transferFunds(String senderWalletId,
     String receiverWalletId, double amount) throws SimpleTransactionManager.InvalidTransactionException;
    public double getBalance(String walletId);
    public boolean isValidWallet(String walletId);

}