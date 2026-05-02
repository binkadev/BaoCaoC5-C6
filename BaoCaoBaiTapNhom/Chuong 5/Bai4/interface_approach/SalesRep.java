package interface_approach;

/**
 * Nhân viên đại diện bán hàng - implements IEmployee.
 * Thu nhập = Lương cơ bản + Hoa hồng (tỷ lệ % x doanh số bán hàng).
 */
public class SalesRep implements IEmployee {
    private String id;
    private String name;
    private double baseSalary;       // Lương cơ bản
    private double salesAmount;      // Doanh số bán hàng
    private double commissionRate;   // Tỷ lệ hoa hồng (VD: 0.05 = 5%)

    public SalesRep(String id, String name, double baseSalary, double salesAmount, double commissionRate) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public String getEmployeeType() {
        return "Nhan vien dai dien ban hang (SalesRep)";
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Thong tin nhan vien ===");
        System.out.println("ID:   " + id);
        System.out.println("Ten:  " + name);
        System.out.println("Loai: " + getEmployeeType());
        System.out.println("Thu nhap hang thang: " + String.format("%,.0f", calculateMonthlySalary()) + " VND");
        System.out.println();
    }
}
