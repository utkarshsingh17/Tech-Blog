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

   Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    public boolean insertLike(Integer pid, Integer uid) {
       
        boolean f = false;
        try {
             con = JdbcUtil.getJdbcConnection();
            String q = "insert into liked(pid,uid) values(?,?)";
            ps = con.prepareStatement(q);
            // Insertin values;
            ps.setInt(1, pid);
            ps.setInt(2, uid);

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

    public Integer countLikeOnPost(Integer pid) {
       
        
        Integer count = 0;
        String q = "SELECT COUNT(*) AS count FROM liked WHERE pid=?";
        try {
             con = JdbcUtil.getJdbcConnection();
             ps = con.prepareStatement(q);
            ps.setInt(1, pid);

             rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
            JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
        return count;
    }

    public boolean isLikeByUser(Integer pid, Integer uid) {
       
        boolean f = false;
        try {
             con = JdbcUtil.getJdbcConnection();
            ps =con.prepareStatement("select * from liked where pid=? and uid=?");
            ps.setInt(1, pid);
            ps.setInt(2, uid);
            rs = ps.executeQuery();
            if (rs.next()) {
                f = true;
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
        return f;
    }

    public boolean deleteLike(Integer pid, Integer uid) {
        
        boolean f = false;
        try {
             con = JdbcUtil.getJdbcConnection();
            ps =con.prepareStatement("delete from liked where pid=? and uid=?");
            ps.setInt(1, pid);
            ps.setInt(2, uid);
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
}
