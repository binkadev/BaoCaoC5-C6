package com.salarymanagement;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Lop Employee
 *
 *
 * @author phupv
 */
public class Employee implements SalaryCalculator {

    private String name;
    private String position;
    private String category;
    private double basicSalary;
    private double overtimeRate;
    private double overtimeHours;

    public Employee(String name, String position, String category,
                    double basicSalary, double overtimeRate) {
        this.name = name;
        this.position = position;
        this.category = category;
        this.basicSalary = basicSalary;
        this.overtimeRate = overtimeRate;
        this.overtimeHours = 0;
    }


    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getCategory() {
        return category;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setOvertimeHours(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("So gio tang ca khong the am!");
        }
        this.overtimeHours = hours;
    }

    @Override
    public double getSalary() {
        return basicSalary + (overtimeHours * overtimeRate);
    }

    public void display() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

        System.out.println("+-----------------------------------------+");
        System.out.println("|         THONG TIN NHAN VIEN             |");
        System.out.println("+-----------------------------------------+");
        System.out.printf("| Ho ten      : %-25s |\n", name);
        System.out.printf("| Chuc vu     : %-25s |\n", position);
        System.out.printf("| Loai        : %-25s |\n", category);
        System.out.printf("| Luong co ban: %-26s |\n", currencyFormat.format(basicSalary));
        System.out.printf("| Gio tang ca : %-23.1f |\n", overtimeHours);
        System.out.printf("| Don gia     : %-26s |\n", currencyFormat.format(overtimeRate));
        System.out.println("+-----------------------------------------+");
        System.out.printf("| TONG LUONG  : %-26s |\n", currencyFormat.format(getSalary()));
        System.out.println("+-----------------------------------------+");
    }
}