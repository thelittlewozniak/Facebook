<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/2/2019
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Facebook</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/Facebook_intelliJ_war_exploded/css/bootstrap.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="/Facebook_intelliJ_war_exploded/css/facebook.css" rel="stylesheet">
    </head>

    <body>

    <div class="wrapper">
    <div class="box">
    <div class="row row-offcanvas row-offcanvas-left">

    <!-- sidebar -->
    <!-- /sidebar -->

    <!-- main right col -->
    <div class="column col-sm-12 col-xs-11" id="main">

    <!-- top nav -->
    <div class="navbar navbar-blue navbar-static-top">
    <div class="navbar-header">
    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
    <span class="sr-only">Toggle</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    </button>
    <a href="http://usebootstrap.com/theme/facebook" class="navbar-brand logo">f</a>
    </div>
    <nav class="collapse navbar-collapse" role="navigation">
    <form class="navbar-form navbar-left">
    <div class="input-group input-group-sm" style="max-width:360px;">
    <input class="form-control" placeholder="Search" name="srch-term" id="srch-term" type="text">
    <div class="input-group-btn">
    <button class="btn btn-default" type="submit">Search</button>
    </div>
    </div>
    </form>
    <ul class="nav navbar-nav">
    <li>
    <a href="#">Home</a>
    </li>
    <li>
    <a href="#postModal" role="button" data-toggle="modal"></i>Make a Post</a>
    </li>
    </ul>
    <form class="navbar-form navbar-right" action="/Facebook_intelliJ_war_exploded/Login/" method="post">
    <div class="input-group input-group-sm" style="max-width:311px;">
    <input class="form-control form-horizontal" placeholder="your email..." name="email" type="email" style="max-width:130px;">
    <input class="form-control form-horizontal" placeholder="your password..." name="password" type="password" style="max-width:130px;">
    <div class="input-group-btn" style="max-width:51px;">
    <button type="submit" class="btn btn-default" data-toggle="dropdown" value="submit" name="submit">Login</button>
    </div>
    </div>
    </form>
    </nav>
    </div>

