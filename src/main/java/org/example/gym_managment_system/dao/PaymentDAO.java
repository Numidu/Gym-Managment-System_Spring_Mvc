package org.example.gym_managment_system.dao;

import org.example.gym_managment_system.model.Payment;
import org.example.gym_managment_system.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    public List<Payment> getAllPayment(){

        List<Payment> payments = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT p.*, m.memberName AS mname FROM payments AS p JOIN member AS m ON m.id = p.member_id";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Payment p = new Payment();

                p.setId(rs.getInt("id"));
                p.setAmount(rs.getDouble("amount"));
                p.setPaymentDate(rs.getDate("payment_date"));
                p.setMemberName(rs.getString("mname"));

                payments.add(p);
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return payments;
    }

    public void insertPayment(Payment p){

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO payments(member_id, amount, payment_date) VALUES (?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, p.getMemberId());

            ps.setDouble(2, p.getAmount());

            ps.setDate(
                    3,
                    new java.sql.Date(
                            p.getPaymentDate().getTime()
                    )
            );

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void deletePayment(int id){

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "DELETE FROM payments WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public Payment findById(int id){

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM payments WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            Payment p = new Payment();

            while(rs.next()){

                p.setId(rs.getInt("id"));
                p.setMemberId(rs.getInt("member_id"));
                p.setAmount(rs.getDouble("amount"));
                p.setPaymentDate(rs.getDate("payment_date"));
            }

            return p;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void updatePayment(Payment p){

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "UPDATE payments SET member_id=? ,amount=? ,payment_date=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, p.getMemberId());

            ps.setDouble(2, p.getAmount());

            ps.setDate(
                    3,
                    new java.sql.Date(
                            p.getPaymentDate().getTime()
                    )
            );

            ps.setInt(4, p.getId());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}
