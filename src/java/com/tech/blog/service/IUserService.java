/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.service;

import com.tech.blog.dto.User;

/**
 *
 * @author kali
 */
public interface IUserService {
    public boolean saveUser(User user) ;
    public User getUserByEmailAndPassword(String email, String password);
     public boolean updateUser(User user);
     public User getUserByUserId(Integer userId);
}
