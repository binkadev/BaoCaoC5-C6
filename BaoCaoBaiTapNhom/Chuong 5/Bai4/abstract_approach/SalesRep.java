package abstract_approach;

/**
 * Nhân viên đại diện bán hàng.
 * Thu nhập = Lương cơ bản + Hoa hồng (tỷ lệ % x doanh số bán hàng).
 */
public class SalesRep extends Employee {
    private double baseSalary;       // Lương cơ bản
    private double salesAmount;      // Doanh số bán hàng
    private double commissionRate;   // Tỷ lệ hoa hồng (VD: 0.05 = 5%)

    public SalesRep(String id, String name, double baseSalary, double salesAmount, double commissionRate) {
        super(id, name);
        this.baseSalary = baseSalary;
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculateMonthlySalary() {
        return baseSalary + (salesAmount * commissionRate);
    }

    @Override
    protected String getEmployeeType() {
        return "Nhan vien dai dien ban hang (SalesRep)";
    }
}
