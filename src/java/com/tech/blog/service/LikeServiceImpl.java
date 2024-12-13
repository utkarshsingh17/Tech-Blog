/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.service;

import com.tech.blog.daoFactory.LikeDaoFactory;
import com.tech.blog.persistance.ILikeDao;

/**
 *
 * @author kali
 */
public class LikeServiceImpl implements ILikeService{
    ILikeDao likeDao=null;
    public boolean insertLike(Integer pid, Integer uid){
        likeDao=LikeDaoFactory.getLikeDao();
        return likeDao.insertLike(pid, uid);
        
        
    }
    public Integer countLikeOnPost(Integer pid){
        likeDao=LikeDaoFactory.getLikeDao();
        return likeDao.countLikeOnPost(pid);
        
    }
    public boolean isLikeByUser(Integer pid, Integer uid){
        likeDao=LikeDaoFactory.getLikeDao();
        return likeDao.isLikeByUser(pid, uid);
        
    }
    public boolean deleteLike(Integer pid, Integer uid){
        likeDao=LikeDaoFactory.getLikeDao();
        return likeDao.deleteLike(pid, uid);
        
    }
}
