package factory;

public class CashOnDeliveryFactory extends PaymentFactory {

    @Override
    public Payment createPayment() {
        return new CashOnDeliveryPayment();
    }
}
