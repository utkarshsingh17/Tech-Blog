/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.service;

import com.tech.blog.daoFactory.PostDaoFactory;
import com.tech.blog.dto.Category;
import com.tech.blog.dto.Post;
import com.tech.blog.persistance.IPostDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kali
 */
public class PostServiceImpl implements IPostService{
    IPostDao postDao=null;
     public ArrayList<Category> getAllCategory(){
         IPostDao postDao= PostDaoFactory.getPostDao();
         return postDao.getAllCategory();
         
     }
     public boolean savePost(Post p){
          IPostDao postDao= PostDaoFactory.getPostDao();
         return postDao.savePost(p);
         
     }
     public List<Post> getAllPosts(){
          IPostDao postDao= PostDaoFactory.getPostDao();
         return postDao.getAllPosts();
     }
      public List<Post> getPostByCatId(Integer catId){
           IPostDao postDao= PostDaoFactory.getPostDao();
         return postDao.getPostByCatId(catId);
      }
      public Post getPostByPostId(Integer postId){
           IPostDao postDao= PostDaoFactory.getPostDao();
         return postDao.getPostByPostId(postId);
      }
    
}
