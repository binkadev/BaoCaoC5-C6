package abstract_approach;

/**
 * Nhân viên tư vấn.
 * Thu nhập = Số giờ làm việc x Đơn giá mỗi giờ.
 */
public class Consultant extends Employee {
    private int hoursWorked;    // Số giờ làm việc trong tháng
    private double hourlyRate;  // Đơn giá mỗi giờ

    public Consultant(String id, String name, int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
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
    protected String getEmployeeType() {
        return "Nhan vien tu van (Consultant)";
    }
}
