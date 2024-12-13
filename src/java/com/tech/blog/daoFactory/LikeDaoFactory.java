/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.daoFactory;

import com.tech.blog.persistance.ILikeDao;
import com.tech.blog.persistance.LikeDaoImpl;



/**
 *
 * @author kali
 */
public class LikeDaoFactory {
        private  LikeDaoFactory(){

    }
    private static ILikeDao likeDao=null;
     public static ILikeDao getLikeDao(){
        if(likeDao==null){
            likeDao=new LikeDaoImpl();
        }
        return likeDao;

    }
}
