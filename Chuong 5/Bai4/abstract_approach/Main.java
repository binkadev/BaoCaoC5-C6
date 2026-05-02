package abstract_approach;

/**
 * Chương trình demo cách a) - Sử dụng lớp trừu tượng (abstract class).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  CACH a) SU DUNG LOP TRUU TUONG (ABSTRACT)");
        System.out.println("============================================\n");

        // Tạo nhân viên đại diện bán hàng
        // Lương cơ bản: 8,000,000 VND, Doanh số: 100,000,000 VND, Hoa hồng: 5%
        SalesRep sr = new SalesRep("NV001", "Nguyen Van A", 8000000, 100000000, 0.05);

        // Tạo nhân viên tư vấn
        // Số giờ: 160 giờ/tháng, Đơn giá: 150,000 VND/giờ
        Consultant cs = new Consultant("NV002", "Tran Thi B", 160, 150000);

        // Hiển thị thông tin - sử dụng tính đa hình
        Employee[] employees = {sr, cs};
        for (Employee emp : employees) {
            emp.displayInfo();
        }

        // Demo truy nhập thuộc tính
        System.out.println("--- Truy nhap thuoc tinh ---");
        System.out.println("Ten nhan vien 1: " + sr.getName());
        System.out.println("ID nhan vien 2:  " + cs.getId());
        System.out.println("Thu nhap NV1:    " + String.format("%,.0f", sr.calculateMonthlySalary()) + " VND");
        System.out.println("Thu nhap NV2:    " + String.format("%,.0f", cs.calculateMonthlySalary()) + " VND");
    }
}
