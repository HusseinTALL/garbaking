<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en" dir="auto">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.rtl.min.css"
          integrity="sha384-OXTEbYDqaX2ZY/BOaZV/yFGChYHtrXH2nyXJ372n2Y8abBhrqacCEe+3qhSHtLjy" crossorigin="anonymous">

    <title>GarbaKing Login</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        body {
            background: #bdbdbd;
        }

        .row {
            background: white;
            border-radius: 30px;
            box-shadow: 12px 12px 22px grey;
        }

        img {
            border-top-left-radius: 30px;
            border-bottom-left-radius: 30px;

        }

        .btn1 {
            border: none;
            outline: none;
            height: 50px;
            width: 100%;
            background-color: black;
            color: white;
            border-radius: 4px;
            font-weight: bold;
        }

        .btn1:hover {
            background-color: white;
            border: 1px solid;
            color: black;
        }

        .custom {
            min-width: 1600px;
        }

        .loginform {
        }
    </style>
</head>
<body>

<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">

<section class="form my-4 mx-5 p-5">
    <div class="container d-flex custom">
        <div class="row g-0">
            <div class="col-lg-5">
                <img src=" ./GarbaKing.jpg" class="img-fluid" alt="GarbaKing">
            </div>
            <div class="col-lg-7 px-5 pt-5  loginform">
                <h1>Logo</h1>
                <h5>Veuillez vous connecter</h5>
                <form action="RegistrationServlet" method="post">
                    <div class="form-row">
                        <div class="col-lg-7 p-2">
                            <input type="text"  required="required" name="username" id="username" class="form-control"
                                   placeholder="Username">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-lg-7 p-2">
                            <input type="email"  required="required" name="email" id="email" class="form-control"
                                   placeholder="email address">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-lg-7 p-2">
                            <input type="password"  required="required" name="password" id="password" class="form-control"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-lg-7 p-2">
                            <input type="password"  required="required" name="re_password" id="re_password" class="form-control"
                                   placeholder="re_password">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-lg-7 p-2">
                            <input type="text"  required="required" name="contact" id="contact" class="form-control" placeholder="contact">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-lg-7 my-3 p-4">
                            <p><input type="checkbox" required="required" class="agreements">
                                I agree all statements in <a href="#">Terms of Service</a></p>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-lg-7 my-3 p-4">
                            <input type="submit" value="Register" class="btn1">
                        </div>
                    </div>

<%--                    <a href="#">Mot de passe oublie</a>--%>
                    <p></p>
                </form>

            </div>
        </div>
    </div>
</section>


<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
    var status = document.getElementById("status").value;
    if(status =="success"){
        swal("Success","Account created Successfully","success");
    }
    if(status =="invalidUsername"){
        swal("Sorry","Please fill the username field","error");
    }
    if(status =="invalidPassword"){
        swal("Sorry","Please fill the password field","error");
    }
    if(status =="invalidContact"){
        swal("Sorry","Please fill the contact field","error");
    }
    if(status =="invalidContactLength"){
        swal("Sorry","Please fill a contact with a correct length field","error");
    }
    if(status =="differentPasswords"){
        swal("Sorry","Please double check the password fields they have to match","error");
    }
    if(status =="invalidEmail"){
        swal("Sorry","Please double check the password fields they have to match","error");
    }
    if(status =="DuplicateEmail"){
        swal("Sorry","This email already has an account!!!","error");
    }

</script>
<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
-->




</body>
</html>