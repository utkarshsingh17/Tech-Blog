<%@page import="com.tech.blog.dto.Category"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.tech.blog.serviceFactory.PostServiceFactory"%>
<%@page import="com.tech.blog.service.IPostService"%>
<%@page import="com.tech.blog.dto.Message"%>
<%@page import="com.tech.blog.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>
<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        
        <style>
             body{
                background: url(img/bg.jpeg);
                background-size: cover;
                background-attachment: fixed;
            }   
        </style>
    </head>
    <body>
        <!--navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark primay_background">
            <a class="navbar-brand" href="home.jsp"><span class ="fa fa-asterisk"></span> Tech Blog</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home.jsp"><span class="fa fa-bell-o"></span> Learn code with Jatender</a>
                    </li>
                    <li class="nav-item active dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="fa fa-check-square-o"></span> Categories
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Programming Language
                                <a class="dropdown-item" href="#">Programming Implementation</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Data Structure</a>
                        </div>
                    </li>    
                    <li class="nav-item active">
                        <a href="#!" class="nav-link" data-toggle="modal" data-target="#add-post-model"><span class="fa fa-asterisk"> Do Post</span></a>
                    </li>
                </ul>
                <ul class="navbar-nav mr-right">
                    <li class="nav-item">
                        <a class="nav-link active" href="#!" data-toggle="modal" data-target="#profile-model"><span class="fa fa-user-circle"></span> <%= user.getName()%> </a>
                    </li> 
                    <li class="nav-item">
                        <a class="nav-link active" href="LogoutServlet"><span class="fa fa-user"></span> Logout</a>
                    </li> 
                </ul>
            </div>
        </nav>
        <!--end navbar-->

        <%
            Message m = (Message) session.getAttribute("msg");
            if (m != null) {
        %>
        <div class="alert <%= m.getCssClass()%>" role="alert">
            <%= m.getContent()%>
        </div>  
        <%
                session.removeAttribute("msg");
            }
        %>
        <!--main body of the page-->
        <main>
            <br>
            <div class="container">
                <!--first col-->
                <div class="row">
                    <div class="col-md-4">
                        <!--categories-->
                        <ul class="list-group">
                            <a href="#" onclick="getPosts(0),this" class="c-link list-group-item list-group-item-action active">All Posts</a>
                            <!--categories-->
                            <%
                                IPostService postService=PostServiceFactory.getPostService();
                                
                                ArrayList<Category> list = postService.getAllCategory();
                                for (Category category : list) {


                            %>
                            <a href="#" onclick="getPosts(<%= category.getcId()%>,this)" class="c-link list-group-item list-group-item-action "><%= category.getName()%></a>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                    <div class="col-md-8">
                        <!--post-->
                        <div class="container text-center" id="loader">
                            <i class="fa fa-refresh fa-4x fa-spin"></i>
                            <h3 class="mt-2">Loading...</h3>
                        </div>
                        <div class="container-fluid" id="post-container">

                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!--end main body of the page-->

        <!--profile model-->

        <!-- Button trigger modal -->


        <!-- Modal -->
        <div class="modal fade" id="profile-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header primay_background text-white">
                        <h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
                        <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div  class="container text-center">
                            <img src="pics/<%= user.getProfile()%>" style="max-width: 150px">
                            <h5 class="modal-title mt-3" id="exampleModalLabel"><%= user.getName()%></h5>

                            <!--details-->
                            <div id="profile-details">
                                <table class="table table-striped">
                                    <tbody>
                                        <tr>
                                            <th scope="row">User Id : </th>
                                            <td><td><%= user.getId()%></td></td>                                       
                                        </tr>
                                        <tr>
                                            <th scope="row">Email :</th>
                                            <td><td><%= user.getEmail()%></td></td>                                       
                                        </tr>
                                        <tr>
                                            <th scope="row">Gender :</th>
                                            <td><td><%= user.getGender()%></td></td>                                       
                                        </tr>
                                        <tr>
                                            <th scope="row">About :</th>
                                            <td><td><%= user.getAbout()%></td></td>                                      
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!--profile edir-->
                            <div id="profile-edit" style="display: none">
                                <h3 class="mt-2">Please Edit Carefully</h3>
                                <form action="EditServlet" method="POST" enctype="multipart/form-data">
                                    <table class="table">
                                        <tr>
                                            <td><b>User ID : </b></td>
                                            <td><%= user.getId()%></td>
                                        </tr>
                                        <tr>
                                            <td><b>Name : </b></td>
                                            <td><input class="form-control" type="text" name="user_name" value="<%= user.getName()%>"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Email : </b></td>
                                            <td><input class="form-control" type="email" name="user_email" value="<%= user.getEmail()%>"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Password : </b></td>
                                            <td><input class="form-control" type="password" name="user_password" value="<%= user.getPassword()%>"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Gender : </b></td>
                                            <td><%= user.getGender().toUpperCase()%></td>
                                        </tr>
                                        <tr>
                                            <td><b>About : </b></td>
                                            <td>
                                                <textarea rows="3" class="form-control" name="user_about" ><%= user.getAbout()%></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><b>New Profile : </b></td>
                                            <td>
                                                <input type="file" name="image" class="form-control">
                                            </td>
                                        </tr>
                                    </table>
                                    <div class="container">
                                        <button type="submit" class="btn btn-outline-primary">Save</button>
                                    </div>
                                </form>
                            </div>
                        </div>         
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button id="edit-profile-button" type="button" class="btn btn-primary">EDIT</button>
                    </div>
                </div>
            </div>
        </div>
        <!--end of profile model-->

        <!--add post model-->
        <!-- Button trigger modal -->

        <!-- Modal -->
        <div class="modal fade" id="add-post-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Provide the Post Details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="add-post-form" action="AddPostServlet" method="POST" enctype='multipart/form-data'>
                            <div class="form-group">
                                <select class="form-control" name="cid">
                                    <option selected disabled>---- Select Category ----</option>
                                    <%
                                         IPostService postService2=PostServiceFactory.getPostService();
                                        ArrayList<Category> list1 = postService2.getAllCategory();
                                        for (Category c : list1) {
                                    %>
                                    <option value="<%= c.getcId()%>"><%= c.getName()%></option>

                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="form-group">
                                <input name="pTitle"  type="text" placeholder="Enter Post Title" class="form-control" />
                            </div>
                            <div class="form-group">
                                <textarea name="pContent" class="form-control"  placeholder="Enter your Content" style="height: 200px"></textarea>
                            </div>
                            <div class="form-group">
                                <textarea name="pCode" class="form-control"  placeholder="Enter your Program (if any)" style="height: 200px"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Select Your Picture</label><br>
                                <input type="file" name="pic" />
                            </div>
                            <div class="container text-center">
                                <button type="submit" class="btn btn-outline-primary">POST</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <!--end of the post model-->
        <!--javascript-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script>
                                $(document).ready(function () {
                                    let editStatus = false;


                                    $('#edit-profile-button').click(function () {
                                        if (editStatus == false) {
                                            $("#profile-details").hide()
                                            $("#profile-edit").show();
                                            editStatus = true;
                                            $(this).text("Back")
                                        } else {
                                            $("#profile-details").show()
                                            $("#profile-edit").hide();
                                            editStatus = false;
                                            $(this).text("Edit")
                                        }
                                    });
                                });
        </script>

        <!--now add post js-->
        <script>
            $(document).ready(function () {
                $("#add-post-form").on("submit", function (event) {
                    // this code gets called when form is submitted
                    event.preventDefault();
                    console.log("You hava clicked on submit..")
                    let form = new FormData(this);
                    //now requesting to server
                    $.ajax({
                        url: "AddPostServlet",
                        type: 'POST',
                        data: form,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            if (data.trim() == 'Done')
                            {
                                swal("Good job!", "Saved Successfully", "success");
                            } else {
                                 swal("Oops", "Something went wrong!", "error");
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            swal("Oops", "Something went wrong!", "error");
                        },
                        processData: false,
                        contentType: false
                    });
                });
            });
        </script>

        <!--loading page through ajax-->
        <script>

            function getPosts(catId,temp) {
                $("#loader").hide();
                $("#post-container").hide();
                $(".c-link").removeClass('active')
                $.ajax({
                    url: "load_posts.jsp",
                    data: {cId: catId},
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        $("#loader").hide();
                        $("#post-container").show();
                        $("#post-container").html(data);
                        $(temp).addClass('active');
                    }
                });
            }
            $(document).ready(function (e) {
                let allPostRef = $('.c-link')[0]
                getPosts(0,allPostRef);
            });
        </script>
        <script>
            function doLike(pid, uid)
{
    console.log(pid + " " + uid);
    const  d = {
        uid: uid,
        pid: pid,
        operation: 'like'
    }
    $.ajax({
        url: "LikeServlet",
        data: d,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            if(data.trim() == 'true')
            {
                let c = $(".like-counter").html();
                c++;
                $('.like-counter').html(c);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(data);
        }
    })    
}
    </script>
</html>
