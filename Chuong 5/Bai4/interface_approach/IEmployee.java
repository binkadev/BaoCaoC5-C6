package interface_approach;

/**
 * Interface IEmployee - định nghĩa các phương thức cho nhân viên.
 * Tất cả các phương thức đều là abstract (mặc định trong interface).
 */
public interface IEmployee {
    // Truy nhập thuộc tính
    String getId();
    String getName();
    void setId(String id);
    void setName(String name);

    // Hiển thị dữ liệu nhân viên
    void displayInfo();

    // Tính thu nhập hàng tháng
    double calculateMonthlySalary();

    // Trả về loại nhân viên
    String getEmployeeType();
}
