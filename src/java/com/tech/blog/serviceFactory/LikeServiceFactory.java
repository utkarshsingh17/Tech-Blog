/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.serviceFactory;

import com.tech.blog.service.ILikeService;
import com.tech.blog.service.LikeServiceImpl;

/**
 *
 * @author kali
 */
public class LikeServiceFactory {
    
     private LikeServiceFactory(){

    }
    private static ILikeService likeService=null;
    public static ILikeService getLikeService(){
        if(likeService==null) {
            likeService = new LikeServiceImpl();
        }
        return likeService;

    }
    
}
