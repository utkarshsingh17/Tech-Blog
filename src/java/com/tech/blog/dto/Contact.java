/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dto;
import java.io.Serializable;
/**
 *
 * @author kali
 */
public class Contact implements Serializable{
    private Integer cId;
    private String cName;
    private String cEmail;
    private String cContact;

    public Contact() {
    }

    public Contact(Integer cId, String cName, String cEmail, String cContact) {
        this.cId = cId;
        this.cName = cName;
        this.cEmail = cEmail;
        this.cContact = cContact;
    }

    public Contact(String cName, String cEmail, String cContact) {
        this.cName = cName;
        this.cEmail = cEmail;
        this.cContact = cContact;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcContact() {
        return cContact;
    }

    public void setcContact(String cContact) {
        this.cContact = cContact;
    }
    
}
