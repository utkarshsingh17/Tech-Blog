<%-- 
    Author     : kali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <link href="css/contact.css" rel="stylesheet" type="text/css"/>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

    </head>
    <body>
        <%@include file="normal_navbar.jsp" %>
        <section class="main-contact-section py-5">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-10">
                        <div class="card py-5 card-body border-0 shadow">
                            <div class="row">
                                <div class="col-lg-5">
                                    <div class="card card-body card-contact bg-theme">
                                        <h1>Contact Us</h1>
                                        <div class="media mb-5 align-items-center">
                                            <div class="icon-part mr-3">
                                                <i class="fas fa-location-arrow " style="color: white"></i>
                                            </div>

                                            <div class="media-body">
                                                <h5 class="mt-0 text-white">Khatri Mohalla Umerkot</h5>

                                            </div>
                                        </div>
                                        <div class="media mb-5 align-items-center">
                                            <div class="icon-part mr-3">
                                                <i class="fas fa-phone " style="color: white"></i>
                                            </div>

                                            <div class="media-body">
                                                <h5 class="mt-0 text-white">+92 3351035477</h5>

                                            </div>
                                        </div>
                                        <div class="media mb-5 align-items-center">
                                            <div class="icon-part mr-3">
                                                <i class="fas fa-envelope " style="color: white"></i>
                                            </div>

                                            <div class="media-body">
                                                <h5 class="mt-0 text-white">kumarjatender0@gmail.com</h5>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-7">
                                    <form id="add-contact-form" action="AddContentServlet" method="POST" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Name</label>
                                            <input name="name" required type="text" class="form-control" name="name" aria-describedby="emailHelp" placeholder="Enter Name"  >
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Mobile Number</label>
                                            <input  required type="number" class="form-control" name="number"  placeholder="Enter Number" >
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Email</label>
                                            <input  required type="email" class="form-control" name="email" placeholder="Enter Email" >
                                        </div>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#add-contact-form").on("submit", function (event) {
                    // this code gets called when form is submitted
                    event.preventDefault();
                    console.log("You hava clicked on submit..")
                    let form = new FormData(this);
                    //now requesting to server
                    $.ajax({
                        url: "AddContentServlet",
                        type: 'POST',
                        data: form,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            if (data.trim() == 'Done')
                            {
                                swal("Saved Successfully!", "Reply Back Inshallah", "success");
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
    </body>
</html>
