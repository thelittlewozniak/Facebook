    <%@ page import="model.pojo.User" %><%--
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
        <a href="/Facebook_intelliJ_war_exploded/Index" class="navbar-brand logo">f</a>
        </div>
        <nav class="collapse navbar-collapse" role="navigation">
        <form class="navbar-form navbar-left" method="post" action="/Facebook_intelliJ_war_exploded/Search/">
        <div class="input-group input-group-sm" style="max-width:360px;">
        <input class="form-control" placeholder="Search" name="keyword" id="srch-term" type="text">
        <div class="input-group-btn">
        <button class="btn btn-default" name="submit" value="submit" type="submit">Search</button>
        </div>
        </div>
        </form>
        <ul class="nav navbar-nav">
        <li>
        <a href="/Facebook_intelliJ_war_exploded/Index">Home</a>
        </li>
            <% if(session.getAttribute("user")!=null){
        User u=(User)session.getAttribute("user");
        out.println("<li><a href=\"/Facebook_intelliJ_war_exploded/Profile\" role=\"button\"></i>"+u.getFirstname()+"</a></li></ul>");
        out.println("<ul class=\"nav navbar-nav navbar-right\"><li><a href=\"/Facebook_intelliJ_war_exploded/LogOut\">Log out</a></li></ul>");
         out.println("</li></ul>");
    }
    else{
        out.println("</li></ul>");
        out.println("<form class=\"navbar-form navbar-right\" action=\"/Facebook_intelliJ_war_exploded/Login/\" method=\"post\">\n" +
"    <div class=\"input-group input-group-sm\" style=\"max-width:311px;\">\n" +
"    <input class=\"form-control form-horizontal\" placeholder=\"your email...\" name=\"email\" type=\"email\" style=\"max-width:130px;\">\n" +
"    <input class=\"form-control form-horizontal\" placeholder=\"your password...\" name=\"password\" type=\"password\" style=\"max-width:130px;\">\n" +
"    <div class=\"input-group-btn\" style=\"max-width:51px;\">\n" +
"    <button type=\"submit\" class=\"btn btn-default\" data-toggle=\"dropdown\" value=\"submit\" name=\"submit\">Login</button>\n" +
"    </div>\n" +
"    </div>\n" +
"    </form>");
    }
    %>

        </nav>
        </div>
            <div class="padding">
            <div class="full col-sm-12">
            <!-- content -->
            <div class="row">
            <div class="col-sm-3">
            <div class="panel panel-info">
            <div class="panel-body">
            <div class="clearfix"></div>
            <ul class="list-group list-unstyled">
                <li><a href="/Facebook_intelliJ_war_exploded/Profile/">Your Profile</a></li>
                <li><a href="/Facebook_intelliJ_war_exploded/Index/">Your news feed</a></li>
                <li><a href="/Facebook_intelliJ_war_exploded/FriendRequests/">Your friend requests</a> </li>
            </ul>
            </div>
            </div>
            </div>
