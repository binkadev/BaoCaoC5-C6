package abstract_approach;

/**
 * Lớp trừu tượng Employee - lớp cơ sở cho các loại nhân viên.
 * 2 phương thức chung: displayInfo(), getter cho tên và id.
 * Phương thức tính thu nhập hàng tháng là abstract vì khác nhau cho từng loại nhân viên.
 */
public abstract class Employee {
    protected String id;
    protected String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Truy nhập thuộc tính nhân viên
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Lưu và hiển thị dữ liệu nhân viên - CHUNG cho tất cả nhân viên
    public void displayInfo() {
        System.out.println("=== Thong tin nhan vien ===");
        System.out.println("ID:   " + id);
        System.out.println("Ten:  " + name);
        System.out.println("Loai: " + getEmployeeType());
        System.out.println("Thu nhap hang thang: " + String.format("%,.0f", calculateMonthlySalary()) + " VND");
        System.out.println();
    }

    // Phương thức trừu tượng - KHÁC NHAU cho từng loại nhân viên
    public abstract double calculateMonthlySalary();

    // Trả về loại nhân viên (dùng cho hiển thị)
    protected abstract String getEmployeeType();
}
