package org.example.gym_managment_system.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Payment {

    private int id;
    private int memberId;
    private double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date paymentDate;
    private String memberName;

    public Payment() {
    }

    public Payment(int id, int memberId, double amount, Date paymentDate) {
        this.id = id;
        this.memberId = memberId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
