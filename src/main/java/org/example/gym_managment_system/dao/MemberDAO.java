package org.example.gym_managment_system.dao;

import org.example.gym_managment_system.model.Member;
import org.example.gym_managment_system.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public void saveMember(Member member){

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO member " +
                    "(memberName,memberAddress,memberAge,memberGender,memberDiseases) " +
                    "VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, member.getMemberName());
            ps.setString(2, member.getMemberAddress());
            ps.setInt(3, member.getMemberAge());
            ps.setString(4, member.getMemberGender());
            ps.setString(5, member.getMemberDiseases());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public List<Member> getAllMembers(){

        List<Member> members = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM member";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Member m = new Member();

                m.setId(rs.getInt("id"));
                m.setMemberName(rs.getString("memberName"));
                m.setMemberAddress(rs.getString("memberAddress"));
                m.setMemberAge(rs.getInt("memberAge"));
                m.setMemberGender(rs.getString("memberGender"));
                m.setMemberDiseases(rs.getString("memberDiseases"));

                members.add(m);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return members;
    }

    public void deleteMember(int id){
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM member WHERE id = ?";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deleted Member");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Member findById(int id){
        try {
            Connection con = DBConnection.getConnection();
            Member m = new Member();
            String sql = "SELECT * FROM member WHERE id = ?";
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                m.setId(rs.getInt("id"));
                m.setMemberName(rs.getString("memberName"));
                m.setMemberAddress(rs.getString("memberAddress"));
                m.setMemberAge(rs.getInt("memberAge"));
                m.setMemberGender(rs.getString("memberGender"));
                m.setMemberDiseases(rs.getString("memberDiseases"));

            }
            return m;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public void update(Member member) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =

                    "UPDATE member SET " + "memberName=?," + "memberAddress=?," + "memberAge=?," + "memberGender=?," + "memberDiseases=? " + "WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(
                    1,
                    member.getMemberName());

            ps.setString(
                    2,
                    member.getMemberAddress());

            ps.setInt(
                    3,
                    member.getMemberAge());

            ps.setString(
                    4,
                    member.getMemberGender());

            ps.setString(
                    5,
                    member.getMemberDiseases());

            ps.setInt(
                    6,
                    member.getId());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
