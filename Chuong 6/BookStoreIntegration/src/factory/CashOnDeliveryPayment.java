package factory;

public class CashOnDeliveryPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + String.format("%,.0f", amount) + " VND khi nhận hàng.");
    }

    @Override
    public String getPaymentName() {
        return "Thanh toán khi nhận hàng (COD)";
    }
}
