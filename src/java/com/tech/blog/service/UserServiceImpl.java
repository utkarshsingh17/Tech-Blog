/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.service;

import com.tech.blog.daoFactory.UserDaoFactory;
import com.tech.blog.dto.User;
import com.tech.blog.persistance.IUserDao;

/**
 *
 * @author kali
 */
public class UserServiceImpl implements IUserService {
    IUserDao userDao=null;
    public boolean saveUser(User user) {
        userDao=UserDaoFactory.getUserDao();
        return userDao.saveUser(user);
        
    }
    public User getUserByEmailAndPassword(String email, String password){
          userDao=UserDaoFactory.getUserDao();
        return userDao.getUserByEmailAndPassword(email,password);
        
    }
     public boolean updateUser(User user){
         userDao=UserDaoFactory.getUserDao();
        return userDao.updateUser(user); 
         
     }
     public User getUserByUserId(Integer userId){
          userDao=UserDaoFactory.getUserDao();
        return userDao.getUserByUserId(userId);
     }
}
