package org.example.gym_managment_system.dao;

import org.example.gym_managment_system.model.Attendance;
import org.example.gym_managment_system.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public void saveAttendance(Attendance a){

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO attendance (member_id, check_in) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getMemberId());

            ps.setDate(2, new java.sql.Date(a.getCheckIn().getTime()
                    )
            );

            ps.executeUpdate();
            System.out.println("Attendance Saved Successfully");

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public List<Attendance> getAllAttendance(){

        List<Attendance> attendanceList =
                new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT a.*, m.memberName AS mname FROM attendance a JOIN member m ON m.id = a.member_id";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Attendance a = new Attendance();

                a.setId(rs.getInt("id"));
                a.setMemberId(rs.getInt("member_id"));
                a.setCheckIn(rs.getDate("check_in"));
                a.setMemberName(rs.getString("mname"));

                attendanceList.add(a);
                System.out.println("Attendance Saved Successfully");
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return attendanceList;
    }

    public void deleteAttendance(int id){

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "DELETE FROM attendance WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Attendance Deleted Successfully");

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public Attendance findById(int id){

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM attendance WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            Attendance a = new Attendance();

            while(rs.next()){

                a.setId(rs.getInt("id"));
                a.setMemberId(rs.getInt("member_id"));
                a.setCheckIn(rs.getDate("check_in"));
            }

            System.out.println("Attendance findById Successfully");
            return a;


        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void updateAttendance(Attendance a){

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE attendance SET " + "member_id=?," + "check_in=? " + "WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getMemberId());

            ps.setDate(2, new java.sql.Date(a.getCheckIn().getTime()
                    )
            );

            ps.setInt(3, a.getId());

            ps.executeUpdate();
            System.out.println("Attendance Updated Successfully");

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}