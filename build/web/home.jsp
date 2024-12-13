<%-- 
    Author     : kali
--%>

<%@page import="com.tech.blog.dto.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.dto.Post"%>
<%@page import="com.tech.blog.persistance.IPostDao"%>
<%@page import="com.tech.blog.daoFactory.PostDaoFactory"%>
<%@page import="com.tech.blog.serviceFactory.PostServiceFactory"%>
<%@page import="com.tech.blog.service.IPostService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <!-- css -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="normal_navbar.jsp" %>

        <div class="container-fluid  p-0 m-0">
            <div class="jumbotron primay_background text-white">
                <div class="container">
                    <h3 class="display-3">Welcome to TechBlog</h3>

                    <p>People from different walks of life are intrigued by the way technology is progressing at a profuse rate, shaping our lives into the digital world!</p>
                    <p>With new tech trends being introduced every quarter and information becoming obsolete as technology evolves, it’s now an obligation to stay relevant and learn about the newest technologies, digital industry, social media, and the web in general!</p>
                    <a href="signup.jsp" class="btn btn-outline-light btn-lg"> <span class="fa fa-user-plus"></span> Start ! it's Free</a>
                    <a href="login.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin"></span> Login</a>
                </div>
            </div>
        </div>

        <!-- card -->

        <div class="container">
            <div class="row mb-2">
                <%
                    IPostService d=PostServiceFactory.getPostService();
                    
                    
                    List<Category> posts = null;
                    posts = d.getAllCategory();
                    for (Category c : posts) {
                %>
                <div class="col-md-4 mt-2">
                    <div class="card">

                        <div class="card-body">
                            <h5 class="card-title"><%= c.getName()%></h5>
                            <p class="card-text"><%= c.getDescription()%></p>
                            <a href="#" class="readmore-btn btn primay_background text-white">Read more</a>
                        </div>
                    </div>

                </div>
                <%
                    }
                %>
            </div></div>






        <!--javascript-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
