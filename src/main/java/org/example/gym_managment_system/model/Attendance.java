package org.example.gym_managment_system.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Attendance {

    private int id;
    private int memberId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkIn;
    private String memberName;

    public Attendance() {
    }

    public Attendance(int id, int memberId, Date checkIn) {
        this.id = id;
        this.memberId = memberId;
        this.checkIn = checkIn;

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

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
