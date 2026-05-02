package com.salarymanagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class MainApp
 *
 *
 * @author phupv
 */
public class MainApp {

    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printHeader();
        createSampleData();

        int choice;
        do {
            showMenu();
            choice = getIntInput("   Chon chuc nang (1-6): ");

            switch (choice) {
                case 1:
                    displayAllEmployees();
                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    updateOvertimeHours();
                    break;
                case 4:
                    calculateTotalSalary();
                    break;
                case 5:
                    searchEmployeeByName();
                    break;
                case 6:
                    System.out.println("\n   Cam on ban da su dung chuong trinh!");
                    System.out.println("   =========================================");
                    System.out.println("   Tham khao sach: Design Patterns - GoF");
                    System.out.println("   Giao trinh: Chuong 5 - Kien truc va mau thiet ke");
                    System.out.println("   =========================================\n");
                    break;
                default:
                    System.out.println("   Lua chon khong hop le! Vui long chon 1-6");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void printHeader() {
        System.out.println("\n");
        System.out.println("+=================================================+");
        System.out.println("|   QUAN LY LUONG NHAN VIEN PHAN MEM             |");
        System.out.println("|   =========================================    |");
        System.out.println("|   Giao trinh: Chuong 5 - Kien truc va mau thiet ke |");
        System.out.println("|   Bai tap 1: Tinh luong nhan vien              |");
        System.out.println("+=================================================+");
    }

    private static void showMenu() {
        System.out.println("\n+---------------------------------------------------+");
        System.out.println("|                    MENU CHINH                      |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("|   1. Hien thi tat ca nhan vien                    |");
        System.out.println("|   2. Them nhan vien moi                           |");
        System.out.println("|   3. Cap nhat gio tang ca                         |");
        System.out.println("|   4. Tong ket luong cong ty                       |");
        System.out.println("|   5. Tim kiem nhan vien                           |");
        System.out.println("|   6. Thoat                                        |");
        System.out.println("+---------------------------------------------------+");
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("   Vui long nhap so nguyen hop le!");
                scanner.nextLine();
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = scanner.nextDouble();
                if (value < 0) {
                    System.out.println("   Vui long nhap so khong am!");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("   Vui long nhap so hop le!");
                scanner.nextLine();
            }
        }
    }

    /**
     * Tao du lieu mau theo bang phan loai
     *
     */
    private static void createSampleData() {
        System.out.println("\n   Dang tao du lieu mau theo bang phan loai (giao trinh trang 42)...");

        // LOAI A - Luong co ban 2000, tang gio 15/gio
        Employee emp1 = new Employee("Nguyen Van An", "Lap trinh vien", "A", 2000, 15);
        emp1.setOvertimeHours(10);
        employees.add(emp1);

        Employee emp2 = new Employee("Tran Thi Binh", "Thiet ke phan mem", "A", 2000, 15);
        emp2.setOvertimeHours(8);
        employees.add(emp2);

        Employee emp3 = new Employee("Le Van Cuong", "Tu van giai phap", "A", 2000, 15);
        emp3.setOvertimeHours(6);
        employees.add(emp3);

        // LOAI B - Luong co ban 1500, tang gio 10/gio
        Employee emp4 = new Employee("Pham Thi Dung", "Dai dien ban hang", "B", 1500, 10);
        emp4.setOvertimeHours(5);
        employees.add(emp4);

        Employee emp5 = new Employee("Hoang Van Em", "Ke toan truong", "B", 1500, 10);
        emp5.setOvertimeHours(6);
        employees.add(emp5);

        Employee emp6 = new Employee("Vu Thi Phuong", "Nhan vien kiem chung", "B", 1500, 10);
        emp6.setOvertimeHours(4);
        employees.add(emp6);

        // LOAI C - Luong co ban 800, tang gio 5/gio
        Employee emp7 = new Employee("Do Van Hung", "Nhan vien ban hang", "C", 800, 5);
        emp7.setOvertimeHours(12);
        employees.add(emp7);

        Employee emp8 = new Employee("Mai Thi Lan", "Nhan vien tiep thi", "C", 800, 5);
        emp8.setOvertimeHours(15);
        employees.add(emp8);

        System.out.println("   Da tao " + employees.size() + " nhan vien mau");
    }

    /**
     * Hien thi tat ca nhan vien
     */
    private static void displayAllEmployees() {
        System.out.println("\n   =================================================");
        System.out.println("   DANH SACH TAT CA NHAN VIEN");
        System.out.println("   =================================================");

        if (employees.isEmpty()) {
            System.out.println("   Chua co nhan vien nao!");
            return;
        }

        for (int i = 0; i < employees.size(); i++) {
            System.out.println("\n   Nhan vien #" + (i + 1));
            employees.get(i).display();
        }

        System.out.println("\n   Tong so nhan vien: " + employees.size());
    }

    /**
     * Them nhan vien moi
     */
    private static void addNewEmployee() {
        System.out.println("\n   =================================================");
        System.out.println("   THEM NHAN VIEN MOI");
        System.out.println("   =================================================");

        scanner.nextLine(); // clear buffer

        System.out.print("   Ho ten: ");
        String name = scanner.nextLine();

        System.out.print("   Chuc vu: ");
        String position = scanner.nextLine();

        System.out.println("\n   +-------------------------------------------------+");
        System.out.println("   |          BANG PHAN LOAI NHAN VIEN                 |");
        System.out.println("   +-------------------------------------------------+");
        System.out.println("   | A - Lap trinh, thiet ke, tu van                  |");
        System.out.println("   |     Luong CB: $2000, Tang gio: $15/gio           |");
        System.out.println("   | B - Dai dien ban hang, quan ly, ke toan...       |");
        System.out.println("   |     Luong CB: $1500, Tang gio: $10/gio           |");
        System.out.println("   | C - Nhan vien ban hang, tiep thi                 |");
        System.out.println("   |     Luong CB: $800, Tang gio: $5/gio             |");
        System.out.println("   +-------------------------------------------------+");

        String category;
        double basicSalary;
        double overtimeRate;

        while (true) {
            System.out.print("   Chon loai (A/B/C): ");
            category = scanner.nextLine().toUpperCase();

            switch (category) {
                case "A":
                    basicSalary = 2000;
                    overtimeRate = 15;
                    break;
                case "B":
                    basicSalary = 1500;
                    overtimeRate = 10;
                    break;
                case "C":
                    basicSalary = 800;
                    overtimeRate = 5;
                    break;
                default:
                    System.out.println("   Loai khong hop le! Vui long chon A, B hoac C");
                    continue;
            }
            break;
        }

        Employee newEmp = new Employee(name, position, category, basicSalary, overtimeRate);

        double overtimeHours = getDoubleInput("   So gio tang ca: ");
        newEmp.setOvertimeHours(overtimeHours);

        employees.add(newEmp);
        System.out.println("\n   Da them nhan vien thanh cong!");
        newEmp.display();
    }

    /**
     * Cap nhat so gio tang ca cho nhan vien
     */
    private static void updateOvertimeHours() {
        System.out.println("\n   =================================================");
        System.out.println("   CAP NHAT GIO TANG CA");
        System.out.println("   =================================================");

        scanner.nextLine();

        System.out.print("   Nhap ten nhan vien can cap nhat: ");
        String name = scanner.nextLine();

        Employee foundEmp = null;
        for (Employee emp : employees) {
            if (emp.getName().toLowerCase().contains(name.toLowerCase())) {
                foundEmp = emp;
                break;
            }
        }

        if (foundEmp == null) {
            System.out.println("   Khong tim thay nhan vien: " + name);
            return;
        }

        System.out.println("\n   Thong tin hien tai:");
        foundEmp.display();

        double newHours = getDoubleInput("\n   Nhap so gio tang ca moi: ");
        foundEmp.setOvertimeHours(newHours);

        System.out.println("\n   Da cap nhat thanh cong!");
        System.out.println("   Thong tin sau khi cap nhat:");
        foundEmp.display();
    }

    /**
     * Tinh tong ket luong toan cong ty
     */
    private static void calculateTotalSalary() {
        System.out.println("\n   =================================================");
        System.out.println("   TONG KET LUONG CONG TY");
        System.out.println("   =================================================");

        double totalSalary = 0;
        double totalA = 0, totalB = 0, totalC = 0;
        int countA = 0, countB = 0, countC = 0;

        for (Employee emp : employees) {
            double salary = emp.getSalary();
            totalSalary += salary;

            switch (emp.getCategory()) {
                case "A":
                    totalA += salary;
                    countA++;
                    break;
                case "B":
                    totalB += salary;
                    countB++;
                    break;
                case "C":
                    totalC += salary;
                    countC++;
                    break;
            }
        }

        System.out.println("\n   +-------------------------------------------------+");
        System.out.println("   |              BANG TONG KET LUONG                 |");
        System.out.println("   +-------------------------------------------------+");
        System.out.printf("   | Loai A (%2d nhan vien)   | $%12.2f              |\n", countA, totalA);
        System.out.printf("   | Loai B (%2d nhan vien)   | $%12.2f              |\n", countB, totalB);
        System.out.printf("   | Loai C (%2d nhan vien)   | $%12.2f              |\n", countC, totalC);
        System.out.println("   +-------------------------------------------------+");
        System.out.printf("   | TONG CONG (%2d nhan vien) | $%12.2f              |\n", employees.size(), totalSalary);
        System.out.println("   +-------------------------------------------------+");

        double avgSalary = totalSalary / employees.size();
        System.out.printf("\n   Luong trung binh: $%.2f\n", avgSalary);

        if (!employees.isEmpty()) {
            Employee maxEmp = employees.get(0);
            Employee minEmp = employees.get(0);
            for (Employee emp : employees) {
                if (emp.getSalary() > maxEmp.getSalary()) maxEmp = emp;
                if (emp.getSalary() < minEmp.getSalary()) minEmp = emp;
            }
            System.out.printf("   Luong cao nhat : $%.2f (Nhan vien: %s)\n",
                    maxEmp.getSalary(), maxEmp.getName());
            System.out.printf("   Luong thap nhat: $%.2f (Nhan vien: %s)\n",
                    minEmp.getSalary(), minEmp.getName());
        }
    }

    /**
     * Tim kiem nhan vien theo ten
     */
    private static void searchEmployeeByName() {
        System.out.println("\n   =================================================");
        System.out.println("   TIM KIEM NHAN VIEN");
        System.out.println("   =================================================");

        scanner.nextLine();

        System.out.print("   Nhap ten can tim: ");
        String keyword = scanner.nextLine().toLowerCase();

        ArrayList<Employee> results = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getName().toLowerCase().contains(keyword)) {
                results.add(emp);
            }
        }

        if (results.isEmpty()) {
            System.out.println("   Khong tim thay nhan vien nao voi tu khoa: " + keyword);
            return;
        }

        System.out.println("\n   Tim thay " + results.size() + " nhan vien:");
        for (Employee emp : results) {
            emp.display();
        }
    }
}