package factory;

public class EWalletFactory extends PaymentFactory {

    @Override
    public Payment createPayment() {
        return new EWalletPayment();
    }
}
