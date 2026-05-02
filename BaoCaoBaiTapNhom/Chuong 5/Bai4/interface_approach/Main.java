package interface_approach;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Chương trình demo cách b) - Sử dụng interface.
 * Xuất kết quả so sánh abstract class vs interface ra file .txt
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  CACH b) SU DUNG INTERFACE                ");
        System.out.println("============================================\n");

        // Tạo nhân viên đại diện bán hàng
        // Lương cơ bản: 8,000,000 VND, Doanh số: 100,000,000 VND, Hoa hồng: 5%
        SalesRep sr = new SalesRep("NV001", "Nguyen Van A", 8000000, 100000000, 0.05);

        // Tạo nhân viên tư vấn
        // Số giờ: 160 giờ/tháng, Đơn giá: 150,000 VND/giờ
        Consultant cs = new Consultant("NV002", "Tran Thi B", 160, 150000);

        // Hiển thị thông tin - sử dụng tính đa hình qua interface
        IEmployee[] employees = {sr, cs};
        for (IEmployee emp : employees) {
            emp.displayInfo();
        }

        // Demo truy nhập thuộc tính
        System.out.println("--- Truy nhap thuoc tinh ---");
        System.out.println("Ten nhan vien 1: " + sr.getName());
        System.out.println("ID nhan vien 2:  " + cs.getId());
        System.out.println("Thu nhap NV1:    " + String.format("%,.0f", sr.calculateMonthlySalary()) + " VND");
        System.out.println("Thu nhap NV2:    " + String.format("%,.0f", cs.calculateMonthlySalary()) + " VND");

        // Xuất so sánh ra file .txt
        writeComparisonToFile("SoSanh_AbstractVsInterface.txt");
    }

    /**
     * Ghi nội dung so sánh Abstract Class vs Interface ra file .txt
     */
    private static void writeComparisonToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, false))) {

            writer.println("==========================================================");
            writer.println("  SO SANH 2 CACH CAI DAT: ABSTRACT CLASS vs INTERFACE     ");
            writer.println("==========================================================");
            writer.println();

            writer.println("1. KE THUA:");
            writer.println("   - Abstract Class: Chi ho tro don ke thua (1 lop cha duy nhat).");
            writer.println("   - Interface:      Ho tro da ke thua (1 lop co the implements nhieu interface).");
            writer.println();

            writer.println("2. THUOC TINH CHUNG (id, name):");
            writer.println("   - Abstract Class: Dinh nghia 1 lan trong lop cha, cac lop con ke thua va dung luon.");
            writer.println("   - Interface:      Khong the dinh nghia thuoc tinh instance.");
            writer.println("                     Moi lop phai tu khai bao lai cac thuoc tinh id, name.");
            writer.println();

            writer.println("3. PHUONG THUC CHUNG (displayInfo, getter/setter):");
            writer.println("   - Abstract Class: Cai dat san trong lop cha. Lop con khong can viet lai.");
            writer.println("                     => Tai su dung code tot, tranh lap lai.");
            writer.println("   - Interface:      Chi khai bao (khong co than phuong thuc).");
            writer.println("                     Moi lop con phai tu cai dat lai displayInfo() => Lap lai code.");
            writer.println();

            writer.println("4. PHUONG THUC KHAC NHAU (calculateMonthlySalary):");
            writer.println("   - Abstract Class: Khai bao la abstract, bat buoc lop con override.");
            writer.println("   - Interface:      Tuong tu, moi lop tu cai dat rieng.");
            writer.println("   => Ca 2 cach deu xu ly tot viec tinh luong khac nhau cho tung loai nhan vien.");
            writer.println();

            writer.println("5. CONSTRUCTOR:");
            writer.println("   - Abstract Class: Co constructor, lop con goi super() de khoi tao thuoc tinh chung.");
            writer.println("   - Interface:      Khong co constructor. Moi lop phai tu khoi tao thuoc tinh.");
            writer.println();

            writer.println("6. TINH LINH HOAT:");
            writer.println("   - Abstract Class: It linh hoat hon vi Java chi cho phep ke thua 1 lop.");
            writer.println("   - Interface:      Linh hoat hon, 1 lop co the implements nhieu interface.");
            writer.println("                     VD: Employee co the vua implements IEmployee, vua implements Serializable.");
            writer.println();

            writer.println("7. TAI SU DUNG CODE:");
            writer.println("   - Abstract Class: Tot hon. Code chung chi viet 1 lan o lop cha.");
            writer.println("   - Interface:      Kem hon. Code displayInfo() phai copy vao ca SalesRep va Consultant.");
            writer.println();

            writer.println("==========================================================");
            writer.println("  KET LUAN                                                ");
            writer.println("==========================================================");
            writer.println();
            writer.println("- Nen dung ABSTRACT CLASS khi cac lop co quan he 'la mot' (is-a),");
            writer.println("  co thuoc tinh va phuong thuc chung can tai su dung.");
            writer.println("  => Phu hop voi bai toan Employee vi SalesRep 'la mot' Employee.");
            writer.println();
            writer.println("- Nen dung INTERFACE khi can dinh nghia 'hanh vi' chung cho cac lop");
            writer.println("  khong lien quan ke thua, hoac khi can da ke thua.");
            writer.println();
            writer.println("=> Voi bai toan nhan vien nay, ABSTRACT CLASS la cach cai dat phu hop hon");
            writer.println("   vi no tranh lap lai code va the hien dung quan he ke thua.");

            System.out.println("\n=> Da xuat file so sanh: " + fileName);

        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }
}
