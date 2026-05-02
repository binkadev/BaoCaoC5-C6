package factory;

public abstract class PaymentFactory {

    public abstract Payment createPayment();

    public void processPayment(double amount) {
        Payment payment = createPayment();
        System.out.println("Phương thức được chọn: " + payment.getPaymentName());
        payment.pay(amount);
    }
}
