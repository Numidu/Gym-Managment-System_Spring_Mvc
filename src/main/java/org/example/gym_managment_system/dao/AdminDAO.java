package org.example.gym_managment_system.dao;

import org.example.gym_managment_system.model.Admin;
import org.example.gym_managment_system.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public void saveAdmin(Admin admin) {

        String sql = "INSERT INTO admins " + "(username,email,password,contactno,image) " + "VALUES(?,?,?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());
            ps.setString(4, admin.getContactno());
            ps.setString(5, admin.getImage());

            ps.executeUpdate();

            System.out.println("Admin Saved");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }



    public List<Admin> getAllAdmins() {

        List<Admin> admins = new ArrayList<>();

        String sql = "SELECT * FROM admins";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Admin a = new Admin();

                a.setId(rs.getInt("id"));
                a.setUsername(rs.getString("username"));
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("password"));
                a.setContactno(rs.getString("contactno"));
                a.setImage(rs.getString("image"));
                System.out.println(rs.getString("image"));
                admins.add(a);
            }
            System.out.println("All Admins Saved");
        } catch (Exception e) {

            e.printStackTrace();
        }

        return admins;
    }



    public void deleteAdmin(int id) {

        String sql = "DELETE FROM admins WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Admin Deleted");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }



    public Admin findById(int id) {

        String sql = "SELECT * FROM admins WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                Admin a = new Admin();

                while (rs.next()) {

                    a.setId(rs.getInt("id"));
                    a.setUsername(rs.getString("username"));
                    a.setEmail(rs.getString("email"));
                    a.setPassword(rs.getString("password"));
                    a.setContactno(rs.getString("contactno"));
                    a.setImage(rs.getString("image"));
                }
               System.out.println("Admin Found");
                return a;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }


    // UPDATE ADMIN
    public void update(Admin admin) {

        String sql = "UPDATE admins SET " +
                "username=?," +
                "email=?," +
                "password=?," +
                "contactno=?," +
                "image=? " +
                "WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());
            ps.setString(4, admin.getContactno());
            ps.setString(5, admin.getImage());
            ps.setInt(6, admin.getId());

            ps.executeUpdate();

            System.out.println("Admin Updated");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }



    public Admin login(String email, String password) {

        String sql = "SELECT * FROM admins WHERE email=? AND password=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Admin a = new Admin();

                    a.setId(rs.getInt("id"));
                    a.setUsername(rs.getString("username"));
                    a.setEmail(rs.getString("email"));
                    a.setImage(rs.getString("image"));

                    System.out.println("Login Succesfuuly");
                    return a;
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}