/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.daoFactory;

import com.tech.blog.persistance.ContactDaoImpl;
import com.tech.blog.persistance.IContactDao;

/**
 *
 * @author kali
 */
public class ContactDaoFactory {
    
     private  ContactDaoFactory(){

    }
    private static IContactDao contactDao=null;
     public static IContactDao getContactDao(){
        if(contactDao==null){
            contactDao=new ContactDaoImpl();
        }
        return contactDao;

    }
    
}
