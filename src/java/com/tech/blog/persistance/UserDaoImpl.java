/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.persistance;

import com.tech.blog.dto.User;
import com.tech.blog.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kali
 */
public class UserDaoImpl implements IUserDao {

    private Connection con=null;

   

    // to insert user to data base:
    public boolean saveUser(User user) {
         con = JdbcUtil.getJdbcConnection();
        boolean f = false;
        try {
            String query = "insert into users(name, email, password, gender, about) values(?,?,?,?,?)";
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getAbout());
            ps.executeUpdate();
            f = true;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return f;
    }

    // get user by email and password
    public User getUserByEmailAndPassword(String email, String password) {
         con = JdbcUtil.getJdbcConnection();
        User user = null;
        try {
            String query = "select * from users where email=? and password=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet set = ps.executeQuery();
            if (set.next()) {
                user = new User();
                String name = set.getString("name");
                user.setName(name);
                user.setId(set.getInt("id"));
                user.setEmail(set.getString("email"));
                user.setAbout(set.getString("about"));
                user.setGender(set.getString("gender"));
                user.setPassword(set.getString("password"));
                user.setProfile(set.getString("profile"));
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return user;
    }

    // Update user by userId
    public boolean updateUser(User user) {
         con = JdbcUtil.getJdbcConnection();

        boolean f = false;
        try {
            String query = "update users set name=?, email=?, password=?, gender=?, about=?, profile=? where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getAbout());
            ps.setString(6, user.getProfile());
            ps.setInt(7, user.getId());

            ps.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return f;
    }

    public User getUserByUserId(Integer userId) {
         con = JdbcUtil.getJdbcConnection();
        User user = null;
        try {
            String query = "select * from users where id=?";
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                user = new User();
                String name = set.getString("name");
                user.setName(name);
                user.setId(set.getInt("id"));
                user.setEmail(set.getString("email"));
                user.setAbout(set.getString("about"));
                user.setGender(set.getString("gender"));
                user.setPassword(set.getString("password"));
                user.setProfile(set.getString("profile"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return user;
    }
}
