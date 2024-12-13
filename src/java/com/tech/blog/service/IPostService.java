/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.service;

import com.tech.blog.dto.Category;
import com.tech.blog.dto.Post;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kali
 */
public interface IPostService {
     public ArrayList<Category> getAllCategory();
     public boolean savePost(Post p) ;
     public List<Post> getAllPosts();
      public List<Post> getPostByCatId(Integer catId);
      public Post getPostByPostId(Integer postId);
}
