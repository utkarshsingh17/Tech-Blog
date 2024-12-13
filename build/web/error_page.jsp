<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry ! Something went wrong...</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        
        <style>
            .banner-background{
                clip-path: polygon(50% 0%, 100% 0, 100% 35%, 100% 100%, 80% 90%, 50% 100%, 20% 89%, 0 100%, 0% 35%, 0 0);
            }
        </style>
    </head>
    <body>
        <div class="container text-center">
            <img src="img/error.png" class="img-fluid" style="height: 480px">
            <h3 class="display-3">Sorry ! Something went wrong .... </h3>
            <a href="home.jsp" class="btn btn-primary btn-lg text-white mt-3">Home</a>
        </div>
    </body>
</html>
