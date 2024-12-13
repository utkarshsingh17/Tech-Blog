/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.serviceFactory;
import com.tech.blog.service.ContactServiceImpl;
import com.tech.blog.service.IContactService;

/**
 *
 * @author kali
 */
public class ContactServiceFactory {
    
     private ContactServiceFactory(){

    }
    private static IContactService contactService=null;
    public static IContactService getContactService(){
        if(contactService==null) {
            contactService = new ContactServiceImpl();
        }
        return contactService;

    }
    
}
