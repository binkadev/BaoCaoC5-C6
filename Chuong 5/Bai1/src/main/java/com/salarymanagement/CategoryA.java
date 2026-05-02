package com.salarymanagement;

/**
 * Class CategoryA - Loai nhan vien A
 *
 * - Lap trinh, thiet ke, tu van
 * - Luong co ban: 2000 USD
 * - Tang gio: 15 USD/gio
 *
 * @author phupv
 */
public class CategoryA implements SalaryCalculator {

    private static final double BASIC_SALARY = 2000;
    private static final double OVERTIME_RATE = 15;

    private double overtimeHours;

    public CategoryA() {
        this.overtimeHours = 0;
    }

    public CategoryA(double overtimeHours) {
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
        return "A";
    }
}