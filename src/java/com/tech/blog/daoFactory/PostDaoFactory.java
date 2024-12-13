/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.daoFactory;

import com.tech.blog.persistance.IPostDao;
import com.tech.blog.persistance.PostDaoImpl;

/**
 *
 * @author kali
 */
public class PostDaoFactory {
          private  PostDaoFactory(){

    }
    private static IPostDao postDao=null;
     public static IPostDao getPostDao(){
        if(postDao==null){
            postDao=new PostDaoImpl();
        }
        return postDao;

    }
}
