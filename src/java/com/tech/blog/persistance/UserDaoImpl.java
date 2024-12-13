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

    
  Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

   

    // to insert user to data base:
    public boolean saveUser(User user) {
         
        boolean f = false;
        try {
            con = JdbcUtil.getJdbcConnection();
            String query = "insert into users(name, email, password, gender, about) values(?,?,?,?,?)";
            ps =con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getAbout());
            ps.executeUpdate();
            f = true;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
            JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
        return f;
    }

    // get user by email and password
    public User getUserByEmailAndPassword(String email, String password) {
        
        User user = null;
        try {
             con = JdbcUtil.getJdbcConnection();
            String query = "select * from users where email=? and password=?";

            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                String name = rs.getString("name");
                user.setName(name);
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setAbout(rs.getString("about"));
                user.setGender(rs.getString("gender"));
                user.setPassword(rs.getString("password"));
                user.setProfile(rs.getString("profile"));
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
            JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
        return user;
    }

    // Update user by userId
    public boolean updateUser(User user) {
         

        boolean f = false;
        try {
            con = JdbcUtil.getJdbcConnection();
            String query = "update users set name=?, email=?, password=?, gender=?, about=?, profile=? where id=?";
            ps = con.prepareStatement(query);
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
        }finally{
            try{
            JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
        return f;
    }

    public User getUserByUserId(Integer userId) {
         
        User user = null;
        try {
            con = JdbcUtil.getJdbcConnection();
            String query = "select * from users where id=?";
             ps =con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                String name = rs.getString("name");
                user.setName(name);
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setAbout(rs.getString("about"));
                user.setGender(rs.getString("gender"));
                user.setPassword(rs.getString("password"));
                user.setProfile(rs.getString("profile"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
            JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
        return user;
    }
}
