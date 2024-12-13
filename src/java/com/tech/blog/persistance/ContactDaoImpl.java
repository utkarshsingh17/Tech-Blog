/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.persistance;

import com.tech.blog.dto.Contact;
import com.tech.blog.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kali
 */
public class ContactDaoImpl implements IContactDao {

    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;

    @Override
    public boolean saveContact(Contact c) {
        con = JdbcUtil.getJdbcConnection();
        boolean b = false;
        try {
            String query = "insert into contact(cName,cEmail,cNumber) values(?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, c.getcName());
            pstmt.setString(2, c.getcEmail());
            pstmt.setString(3, c.getcContact());
            pstmt.executeUpdate();
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
            JdbcUtil.cleanUp(con, pstmt, rs);
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
        return b;
    }
}
