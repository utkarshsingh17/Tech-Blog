/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.serviceFactory;

import com.tech.blog.service.IPostService;
import com.tech.blog.service.PostServiceImpl;

/**
 *
 * @author kali
 */
public class PostServiceFactory {
     
     private PostServiceFactory(){

    }
    private static IPostService postService=null;
    public static IPostService getPostService(){
        if(postService==null) {
            postService = new PostServiceImpl();
        }
        return postService;

    }
}
