package org.example.gym_managment_system.dao;

import org.example.gym_managment_system.model.Member;
import org.example.gym_managment_system.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public void saveMember(Member member) {

        String sql = "INSERT INTO member " +
                "(memberName,memberAddress,memberAge,memberGender,memberDiseases) " +
                "VALUES(?,?,?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, member.getMemberName());
            ps.setString(2, member.getMemberAddress());
            ps.setInt(3, member.getMemberAge());
            ps.setString(4, member.getMemberGender());
            ps.setString(5, member.getMemberDiseases());

            ps.executeUpdate();
            System.out.println("Member saved Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public List<Member> getAllMembers() {

        List<Member> members = new ArrayList<>();

        String sql = "SELECT * FROM member";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Member m = new Member();

                m.setId(rs.getInt("id"));
                m.setMemberName(rs.getString("memberName"));
                m.setMemberAddress(rs.getString("memberAddress"));
                m.setMemberAge(rs.getInt("memberAge"));
                m.setMemberGender(rs.getString("memberGender"));
                m.setMemberDiseases(rs.getString("memberDiseases"));

                members.add(m);
            }
            System.out.println("All Member saved Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return members;
    }

    public void deleteMember(int id) {

        String sql = "DELETE FROM member WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Deleted Member");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Member findById(int id) {

        String sql = "SELECT * FROM member WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                Member m = new Member();

                while (rs.next()) {

                    m.setId(rs.getInt("id"));
                    m.setMemberName(rs.getString("memberName"));
                    m.setMemberAddress(rs.getString("memberAddress"));
                    m.setMemberAge(rs.getInt("memberAge"));
                    m.setMemberGender(rs.getString("memberGender"));
                    m.setMemberDiseases(rs.getString("memberDiseases"));
                }
                System.out.println("Member found Successfully");
                return m;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public void update(Member member) {

        String sql =
                "UPDATE member SET " +
                        "memberName=?," +
                        "memberAddress=?," +
                        "memberAge=?," +
                        "memberGender=?," +
                        "memberDiseases=? " +
                        "WHERE id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, member.getMemberName());
            ps.setString(2, member.getMemberAddress());
            ps.setInt(3, member.getMemberAge());
            ps.setString(4, member.getMemberGender());
            ps.setString(5, member.getMemberDiseases());
            ps.setInt(6, member.getId());

            ps.executeUpdate();
            System.out.println("Member updated Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}