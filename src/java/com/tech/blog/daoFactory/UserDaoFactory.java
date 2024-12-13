/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.daoFactory;

import com.tech.blog.persistance.IUserDao;
import com.tech.blog.persistance.UserDaoImpl;

/**
 *
 * @author kali
 */
public class UserDaoFactory {
           private  UserDaoFactory(){

    }
    private static IUserDao userDao=null;
     public static IUserDao getUserDao(){
        if(userDao==null){
            userDao=new UserDaoImpl();
        }
        return userDao;

    }
}
