package factory;

public class BankTransferPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + String.format("%,.0f", amount) + " VND bằng chuyển khoản ngân hàng.");
    }

    @Override
    public String getPaymentName() {
        return "Chuyển khoản ngân hàng";
    }
}
