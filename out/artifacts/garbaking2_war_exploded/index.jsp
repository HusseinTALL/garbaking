<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/9/2022
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  if(session.getAttribute("name") == null){
    response.sendRedirect("login.jsp");
  }
%>
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
<%--  <style>--%>
<%--    * {--%>
<%--      padding: 0;--%>
<%--      margin: 0;--%>
<%--      box-sizing: border-box;--%>
<%--    }--%>

<%--    body {--%>
<%--      background: #bdbdbd;--%>
<%--    }--%>

<%--    .row {--%>
<%--      background: white;--%>
<%--      border-radius: 30px;--%>
<%--      box-shadow: 12px 12px 22px grey;--%>
<%--    }--%>

<%--    img {--%>
<%--      border-top-left-radius: 30px;--%>
<%--      border-bottom-left-radius: 30px;--%>
<%--    }--%>

<%--    .btn1 {--%>
<%--      border: none;--%>
<%--      outline: none;--%>
<%--      height: 50px;--%>
<%--      width: 100%;--%>
<%--      background-color: black;--%>
<%--      color: white;--%>
<%--      border-radius: 4px;--%>
<%--      font-weight: bold;--%>
<%--    }--%>

<%--    .btn1:hover {--%>
<%--      background-color: white;--%>
<%--      border: 1px solid;--%>
<%--      color: black;--%>
<%--    }--%>

<%--    .custom {--%>
<%--      min-width: 1600px;--%>
<%--    }--%>

<%--    .loginform {--%>
<%--    }--%>
  </style>
</head>
  <body>
  <div class="container-fluid d-flex custom">



  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Dropdown
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="LogoutServlet">logout</a>
        </li>
        <li class="nav-item bg-danger">
          <a class="nav-link " href="#"><%=session.getAttribute("name")%>></a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2 disabled" type="search" placeholder="Search" aria-label="Search">
<%--        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>

      </form>
    </div>
  </nav>
    <br>
    <p>
      Logged in successfully
    </p>

  </div>


  <!-- Optional JavaScript; choose one of the two! -->

  <!-- Option 1: Bootstrap Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
          crossorigin="anonymous"></script>


<%--  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>--%>
<%--  <link rel="stylesheet" href="alert/dist/sweetalert.css">--%>

<%--  <script type="text/javascript">--%>
<%--    var status = document.getElementById("status").value;--%>
<%--    if(status =="failed"){--%>
<%--      swal("Sorry","Wrong credentials","error ");--%>
<%--    }--%>

<%--  </script>--%>

  <!-- Option 2: Separate Popper and Bootstrap JS -->
  <!--
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>
  -->
  </body>
</html>