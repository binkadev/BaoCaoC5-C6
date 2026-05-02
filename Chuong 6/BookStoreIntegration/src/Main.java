import singleton.ConfigurationManager;
import singleton.DatabaseConnectionPool;
import factory.PaymentFactory;
import factory.PaymentFactoryProvider;
import model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * ===================================================================
 *  HỆ THỐNG BÁN SÁCH ONLINE - BOOKSTORE SYSTEM
 *  Tích hợp: Singleton Pattern + Factory Method Pattern
 * ===================================================================
 *
 *  Các chức năng cơ bản của hệ thống bán sách online:
 *  1. Quản lý sách: thêm, sửa, xóa, tìm kiếm sách theo danh mục
 *  2. Quản lý tài khoản người dùng: đăng ký, đăng nhập
 *  3. Giỏ hàng: thêm sách vào giỏ, cập nhật số lượng
 *  4. Đặt hàng: tạo đơn hàng từ giỏ hàng
 *  5. Thanh toán: hỗ trợ nhiều phương thức (COD, Ví điện tử, Chuyển khoản)
 *  6. Quản lý kho: cập nhật tồn kho khi có đơn hàng
 *  7. Quản lý đơn hàng: theo dõi trạng thái đơn hàng
 *
 *  Áp dụng Design Pattern:
 *  - Singleton: Quản lý kết nối CSDL (DatabaseConnectionPool)
 *              và cấu hình hệ thống (ConfigurationManager)
 *              → Đảm bảo chỉ có DUY NHẤT một kết nối pool trong toàn hệ thống
 *  - Factory Method: Khởi tạo phương thức thanh toán (PaymentFactory)
 *              → Dễ dàng mở rộng thêm phương thức thanh toán mới
 * ===================================================================
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=========================================================");
        System.out.println("     HỆ THỐNG BÁN SÁCH ONLINE - BOOKSTORE SYSTEM");
        System.out.println("=========================================================");
        System.out.println();

        // ==========================================
        // BƯỚC 1: KHỞI TẠO HỆ THỐNG (SINGLETON)
        // ==========================================
        System.out.println("--- BƯỚC 1: Khởi tạo hệ thống (Singleton Pattern) ---");
        System.out.println();

        // Lấy ConfigurationManager - Singleton
        System.out.println("[1.1] Lấy cấu hình hệ thống (ConfigurationManager):");
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();
        System.out.println("  → config1 hashCode: " + System.identityHashCode(config1));
        System.out.println("  → config2 hashCode: " + System.identityHashCode(config2));
        System.out.println("  → Cùng một instance? " + (config1 == config2) + " ✓ SINGLETON!");
        System.out.println();
        config1.printConfig();
        System.out.println();

        // Lấy DatabaseConnectionPool - Singleton
        System.out.println("[1.2] Kết nối Cơ sở dữ liệu (DatabaseConnectionPool):");
        DatabaseConnectionPool dbPool1 = DatabaseConnectionPool.getInstance();
        DatabaseConnectionPool dbPool2 = DatabaseConnectionPool.getInstance();
        System.out.println("  → dbPool1 hashCode: " + System.identityHashCode(dbPool1));
        System.out.println("  → dbPool2 hashCode: " + System.identityHashCode(dbPool2));
        System.out.println("  → Cùng một instance? " + (dbPool1 == dbPool2) + " ✓ SINGLETON!");
        System.out.println("  → Trạng thái pool: " + (dbPool1.isActive() ? "ĐANG HOẠT ĐỘNG" : "ĐÃ ĐÓNG"));
        System.out.println();

        // ==========================================
        // BƯỚC 2: KHÁCH HÀNG DUYỆT VÀ CHỌN SÁCH
        // ==========================================
        System.out.println("--- BƯỚC 2: Khách hàng duyệt và chọn sách ---");
        System.out.println();

        // Tạo danh sách sách mô phỏng (giả lập lấy từ DB qua Singleton)
        List<Book> danhSachSach = new ArrayList<>();
        danhSachSach.add(new Book(1, "BK001", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 75000, "Văn học", 100));
        danhSachSach.add(new Book(2, "BK002", "Nhà Giả Kim", "Paulo Coelho", 89000, "Tiểu thuyết", 50));
        danhSachSach.add(new Book(3, "BK003", "Clean Code", "Robert Martin", 420000, "Công nghệ", 30));
        danhSachSach.add(new Book(4, "BK004", "Đắc Nhân Tâm", "Dale Carnegie", 99000, "Kỹ năng", 80));
        danhSachSach.add(new Book(5, "BK005", "Harry Potter", "J.K. Rowling", 250000, "Tiểu thuyết", 45));

        System.out.println("  Danh sách sách có trong hệ thống:");
        System.out.println("  +----+--------+---------------------------+----------------+----------+");
        System.out.println("  | ID | Mã     | Tên sách                  | Giá            | Tồn kho  |");
        System.out.println("  +----+--------+---------------------------+----------------+----------+");
        for (Book book : danhSachSach) {
            System.out.printf("  | %2d | %-6s | %-25s | %14s | %8d |%n",
                    book.getId(), book.getBookCode(), book.getTitle(),
                    book.getFormattedPrice(), book.getStock());
        }
        System.out.println("  +----+--------+---------------------------+----------------+----------+");
        System.out.println();

        // Khách chọn mua sách
        Book sachDuocChon = danhSachSach.get(2); // Clean Code
        int soLuong = 1;
        double tongTien = sachDuocChon.getPrice() * soLuong;

        System.out.println("  → Khách hàng chọn mua: " + sachDuocChon.getTitle());
        System.out.println("  → Tác giả: " + sachDuocChon.getAuthor());
        System.out.println("  → Số lượng: " + soLuong);
        System.out.println("  → Thành tiền: " + sachDuocChon.getFormattedPrice());
        System.out.println();

        // ==========================================
        // BƯỚC 3: CHỌN PHƯƠNG THỨC THANH TOÁN (FACTORY)
        // ==========================================
        System.out.println("--- BƯỚC 3: Chọn phương thức thanh toán (Factory Pattern) ---");
        System.out.println();

        System.out.println("  Các phương thức thanh toán hỗ trợ:");
        System.out.println("  [1] COD     - Thanh toán khi nhận hàng");
        System.out.println("  [2] EWALLET - Thanh toán qua ví điện tử");
        System.out.println("  [3] BANK    - Chuyển khoản ngân hàng");
        System.out.println();

        // Khách chọn thanh toán qua ví điện tử
        String luaChon = "EWALLET";
        System.out.println("  → Khách hàng chọn: " + luaChon);
        System.out.println();

        // Sử dụng Factory Pattern để tạo phương thức thanh toán
        PaymentFactory factory = PaymentFactoryProvider.getFactory(luaChon);
        System.out.print("  → ");
        factory.processPayment(tongTien);
        System.out.println();

        // ==========================================
        // BƯỚC 4: HOÀN TẤT ĐƠN HÀNG
        // ==========================================
        System.out.println("--- BƯỚC 4: Hoàn tất đơn hàng ---");
        System.out.println();
        System.out.println("  ╔═══════════════════════════════════════════╗");
        System.out.println("  ║           HÓA ĐƠN MUA HÀNG              ║");
        System.out.println("  ╠═══════════════════════════════════════════╣");
        System.out.printf("  ║  Sách: %-35s ║%n", sachDuocChon.getTitle());
        System.out.printf("  ║  Tác giả: %-32s ║%n", sachDuocChon.getAuthor());
        System.out.printf("  ║  Số lượng: %-31d ║%n", soLuong);
        System.out.printf("  ║  Đơn giá: %-31s ║%n", sachDuocChon.getFormattedPrice());
        System.out.printf("  ║  Thanh toán: %-29s ║%n", luaChon);
        System.out.println("  ╠═══════════════════════════════════════════╣");
        System.out.printf("  ║  TỔNG TIỀN: %-29s ║%n", String.format("%,.0f VND", tongTien));
        System.out.println("  ╚═══════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  ✓ Đặt hàng thành công!");
        System.out.println();

        // Đóng kết nối
        dbPool1.closePool();

        System.out.println("=========================================================");
        System.out.println("              KẾT THÚC MÔ PHỎNG HỆ THỐNG");
        System.out.println("=========================================================");
    }
}
