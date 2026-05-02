package interface_approach;

/**
 * Nhân viên tư vấn - implements IEmployee.
 * Thu nhập = Số giờ làm việc x Đơn giá mỗi giờ.
 */
public class Consultant implements IEmployee {
    private String id;
    private String name;
    private int hoursWorked;    // Số giờ làm việc trong tháng
    private double hourlyRate;  // Đơn giá mỗi giờ

    public Consultant(String id, String name, int hoursWorked, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
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

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateMonthlySalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getEmployeeType() {
        return "Nhan vien tu van (Consultant)";
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
