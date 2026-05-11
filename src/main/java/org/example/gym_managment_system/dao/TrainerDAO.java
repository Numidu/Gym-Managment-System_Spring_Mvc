package org.example.gym_managment_system.dao;

import org.example.gym_managment_system.model.Trainer;
import org.example.gym_managment_system.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO {

    public void saveTrainer(Trainer trainer){

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO trainers " +
                    "(name,specialty,phone,experience) " +
                    "VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, trainer.getName());
            ps.setString(2, trainer.getSpecialty());
            ps.setString(3, trainer.getPhone());
            ps.setInt(4, trainer.getExperience());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public List<Trainer> getAllTrainers(){

        List<Trainer> trainers = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM trainers";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Trainer t = new Trainer();

                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setSpecialty(rs.getString("specialty"));
                t.setPhone(rs.getString("phone"));
                t.setExperience(rs.getInt("experience"));

                trainers.add(t);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return trainers;
    }

    public void deleteTrainer(int id){

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM trainers WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Deleted Trainer");

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public Trainer findById(int id){

        try {

            Connection con = DBConnection.getConnection();

            Trainer t = new Trainer();

            String sql = "SELECT * FROM trainers WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setSpecialty(rs.getString("specialty"));
                t.setPhone(rs.getString("phone"));
                t.setExperience(rs.getInt("experience"));
            }

            return t;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void update(Trainer trainer){

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "UPDATE trainers SET " +
                            "name=?," +
                            "specialty=?," +
                            "phone=?," +
                            "experience=? " +
                            "WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, trainer.getName());
            ps.setString(2, trainer.getSpecialty());
            ps.setString(3, trainer.getPhone());
            ps.setInt(4, trainer.getExperience());
            ps.setInt(5, trainer.getId());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
