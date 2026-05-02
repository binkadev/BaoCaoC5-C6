package factory;

public class PaymentFactoryProvider {

    public static PaymentFactory getFactory(String paymentType) {
        if (paymentType == null) {
            throw new IllegalArgumentException("Loại thanh toán không được để trống");
        }

        switch (paymentType.toUpperCase()) {
            case "COD":
                return new CashOnDeliveryFactory();
            case "EWALLET":
                return new EWalletFactory();
            case "BANK":
                return new BankTransferFactory();
            default:
                throw new IllegalArgumentException("Không hỗ trợ phương thức: " + paymentType);
        }
    }
}
