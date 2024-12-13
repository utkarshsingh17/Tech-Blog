/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.persistance;

import com.tech.blog.dto.Category;
import com.tech.blog.dto.Post;
import com.tech.blog.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kali
 */
public class PostDaoImpl implements IPostDao{

  Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    public ArrayList<Category> getAllCategory() {
         
        ArrayList<Category> list = new ArrayList<>();
        try {
            con = JdbcUtil.getJdbcConnection();
            String query = " SELECT * FROM categories";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Integer cId = rs.getInt("cid");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Category c = new Category(cId, name, description);
                list.add(c);
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
        return list;
    }

    public boolean savePost(Post p) {
         
        boolean f = false;
        try {
            con = JdbcUtil.getJdbcConnection();
            String query = "insert into posts(pTitle,pContent,pCode,pPic,catId,userId) values(?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, p.getpTitle());
            ps.setString(2, p.getpContent());
            ps.setString(3, p.getpCode());
            ps.setString(4, p.getpPic());
            ps.setInt(5, p.getCatId());
            ps.setInt(6, p.getUserId());
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

//    get all posts
    public List<Post> getAllPosts() {
         
        List<Post> list = new ArrayList<>();
        // fetch all the posts
        try {
            con = JdbcUtil.getJdbcConnection();
             ps = con.prepareStatement("select * from posts order by pid desc");
             rs = ps.executeQuery();
            while (rs.next()) {
                Integer pId = rs.getInt("pid");
                String pTitle = rs.getString("pTitle");
                String pContent = rs.getString("pContent");
                String pCode = rs.getString("pCode");
                String pPic = rs.getString("pPic");
                Integer cId = rs.getInt("catId");
                Integer uId = rs.getInt("userId");

                Post p = new Post(pId, pTitle, pContent, pCode, pPic, cId, uId);
                list.add(p);
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
        return list;
    }

    // get posts by category
    public List<Post> getPostByCatId(Integer catId) {
        
        List<Post> list = new ArrayList<>();
        // fetch all post by category
        try {
             con = JdbcUtil.getJdbcConnection();
             ps = con.prepareStatement("select * from posts where catId = ?");
            ps.setInt(1, catId);
             rs = ps.executeQuery();
            while (rs.next()) {
                Integer pId = rs.getInt("pid");
                String pTitle = rs.getString("pTitle");
                String pContent = rs.getString("pContent");
                String pCode = rs.getString("pCode");
                String pPic = rs.getString("pPic");
                Integer uId = rs.getInt("userId");
                Post p = new Post(pId, pTitle, pContent, pCode, pPic, catId, uId);
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        } finally{
            try{
            JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
        return list;
    }

    public Post getPostByPostId(Integer postId) {
        
        Post post = null;
        try {
             con = JdbcUtil.getJdbcConnection();
            String query = "select * from posts where pid=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, postId);

            ResultSet set = ps.executeQuery();
            while (set.next()) {
                Integer pId = set.getInt("pid");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode = set.getString("pCode");
                String pPic = set.getString("pPic");
                Integer uId = set.getInt("userId");
                Integer catId = set.getInt("catId");
                post = new Post(pId, pTitle, pContent, pCode, pPic, catId, uId);
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
        return post;
    }
    
    
}
