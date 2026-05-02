package com.salarymanagement;

/**
 * Class CategoryB - Loai nhan vien B
 *
 * - Dai dien ban hang, quan ly ban hang, ke toan, kiem chung
 * - Luong co ban: 1500 USD
 * - Tang gio: 10 USD/gio
 *
 * @author phupv
 */
public class CategoryB implements SalaryCalculator {

    private static final double BASIC_SALARY = 1500;
    private static final double OVERTIME_RATE = 10;

    private double overtimeHours;

    public CategoryB() {
        this.overtimeHours = 0;
    }

    public CategoryB(double overtimeHours) {
        this.overtimeHours = overtimeHours >= 0 ? overtimeHours : 0;
    }

    @Override
    public double getSalary() {
        return BASIC_SALARY + (overtimeHours * OVERTIME_RATE);
    }

    public double getBasicSalary() {
        return BASIC_SALARY;
    }

    public double getOvertimeRate() {
        return OVERTIME_RATE;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("So gio tang ca khong the am!");
        }
        this.overtimeHours = hours;
    }

    public String getCategoryType() {
        return "B";
    }
}