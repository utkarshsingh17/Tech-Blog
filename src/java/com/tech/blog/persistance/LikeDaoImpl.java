/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.persistance;

import com.tech.blog.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kali
 */
public class LikeDaoImpl implements ILikeDao{

    Connection con;

    

    public boolean insertLike(Integer pid, Integer uid) {
        con = JdbcUtil.getJdbcConnection();
        boolean f = false;
        try {
            String q = "insert into liked(pid,uid) values(?,?)";
            PreparedStatement ps = con.prepareStatement(q);
            // Insertin values;
            ps.setInt(1, pid);
            ps.setInt(2, uid);

            ps.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return f;
    }

    public Integer countLikeOnPost(Integer pid) {
        con = JdbcUtil.getJdbcConnection();
        
        Integer count = 0;
        String q = "SELECT COUNT(*) AS count FROM liked WHERE pid=?";
        try {
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, pid);

            ResultSet set = ps.executeQuery();
            if (set.next()) {
                count = set.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean isLikeByUser(Integer pid, Integer uid) {
        con = JdbcUtil.getJdbcConnection();
        boolean f = false;
        try {
            PreparedStatement ps = this.con.prepareStatement("select * from liked where pid=? and uid=?");
            ps.setInt(1, pid);
            ps.setInt(2, uid);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return f;
    }

    public boolean deleteLike(Integer pid, Integer uid) {
        con = JdbcUtil.getJdbcConnection();
        boolean f = false;
        try {
            PreparedStatement ps = this.con.prepareStatement("delete from liked where pid=? and uid=?");
            ps.setInt(1, pid);
            ps.setInt(2, uid);
            ps.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return f;
    }
}
