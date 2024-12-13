/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.persistance;

/**
 *
 * @author kali
 */
public interface ILikeDao {
     public boolean insertLike(Integer pid, Integer uid);
    public Integer countLikeOnPost(Integer pid);
    public boolean isLikeByUser(Integer pid, Integer uid);
    public boolean deleteLike(Integer pid, Integer uid);
    
}
