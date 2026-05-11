package org.example.gym_managment_system.dao;

import org.example.gym_managment_system.model.Payment;
import org.example.gym_managment_system.util.DBConnection;
import org.springframework.ui.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DashbordDAO {

    public void getData(Model model) {

        try (

                Connection conn = DBConnection.getConnection()

        ) {

            // Admin Count
            int adminCount = 0;

            String query = "SELECT COUNT(*) FROM admins";

            try(
                    PreparedStatement ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
            ){

                if(rs.next()){
                    adminCount = rs.getInt(1);
                }
            }

            model.addAttribute("adminCount", adminCount);


            // Trainer Count
            int trainerCount = 0;

            String query2 = "SELECT COUNT(*) FROM trainers";

            try(
                    PreparedStatement ps2 = conn.prepareStatement(query2);
                    ResultSet rs2 = ps2.executeQuery();
            ){

                if(rs2.next()){
                    trainerCount = rs2.getInt(1);
                }
            }

            model.addAttribute("trainerCount", trainerCount);


            // Member Count
            int memberCount = 0;

            String query3 = "SELECT COUNT(*) FROM member";

            try(
                    PreparedStatement ps3 = conn.prepareStatement(query3);
                    ResultSet rs3 = ps3.executeQuery();
            ){

                if(rs3.next()){
                    memberCount = rs3.getInt(1);
                }
            }

            model.addAttribute("memberCount", memberCount);


            // Payment Sum
            double payment = 0;

            String query4 = "SELECT SUM(amount) FROM payments";

            try(
                    PreparedStatement ps4 = conn.prepareStatement(query4);
                    ResultSet rs4 = ps4.executeQuery();
            ){

                if(rs4.next()){
                    payment = rs4.getDouble(1);
                }
            }

            model.addAttribute("payment", payment);


            // Paid Members
            int paid = 0;

            List<Payment> payments = new ArrayList<>();

            String query5 =
                    "SELECT p.*, m.memberName AS Mname " +
                            "FROM payments p " +
                            "JOIN member m ON m.id = p.member_id";

            try(
                    PreparedStatement ps5 = conn.prepareStatement(query5);
                    ResultSet rs5 = ps5.executeQuery();
            ){

                while(rs5.next()){

                    Payment p = new Payment();

                    p.setPaymentDate(
                            rs5.getDate("payment_date")
                    );

                    p.setMemberName(
                            rs5.getString("Mname")
                    );

                    payments.add(p);

                    paid++;
                }
            }

            model.addAttribute("paidmember", paid);

            model.addAttribute("payments", payments);

        } catch (Exception e){

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Database Error"
            );
        }
    }
}

