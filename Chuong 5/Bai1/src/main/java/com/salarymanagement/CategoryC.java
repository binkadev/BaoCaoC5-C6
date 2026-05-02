package com.salarymanagement;

/**
 * Class CategoryC - Loai nhan vien C
 *
 * - Nhan vien ban hang, nhan vien tiep thi
 * - Luong co ban: 800 USD
 * - Tang gio: 5 USD/gio
 *
 * @author phupv
 */
public class CategoryC implements SalaryCalculator {

    private static final double BASIC_SALARY = 800;
    private static final double OVERTIME_RATE = 5;

    private double overtimeHours;

    public CategoryC() {
        this.overtimeHours = 0;
    }

    public CategoryC(double overtimeHours) {
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
        return "C";
    }
}