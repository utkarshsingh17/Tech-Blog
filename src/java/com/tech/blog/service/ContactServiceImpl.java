/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.service;

import com.tech.blog.daoFactory.ContactDaoFactory;
import com.tech.blog.dto.Contact;
import com.tech.blog.persistance.IContactDao;

/**
 *
 * @author kali
 */
public class ContactServiceImpl implements IContactService {
    IContactDao contactDao=null;
    public boolean saveContact(Contact c){
        contactDao=ContactDaoFactory.getContactDao();
        return contactDao.saveContact(c);
        
        
    }
    
}
