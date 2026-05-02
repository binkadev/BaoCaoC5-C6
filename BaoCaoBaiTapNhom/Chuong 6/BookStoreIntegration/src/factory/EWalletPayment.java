package factory;

public class EWalletPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + String.format("%,.0f", amount) + " VND qua ví điện tử.");
    }

    @Override
    public String getPaymentName() {
        return "Thanh toán qua ví điện tử";
    }
}
