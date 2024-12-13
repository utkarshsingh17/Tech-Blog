/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.persistance;

import com.tech.blog.dto.Contact;
import com.tech.blog.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author kali
 */
public class ContactDaoImpl implements IContactDao {

    Connection con=null;

    

    @Override
    public boolean saveContact(Contact c) {
        con = JdbcUtil.getJdbcConnection();
        boolean b = false;
        try {
            String query = "insert into contact(cName,cEmail,cNumber) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, c.getcName());
            ps.setString(2, c.getcEmail());
            ps.setString(3, c.getcContact());
            ps.executeUpdate();
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }
        return b;
    }
}
