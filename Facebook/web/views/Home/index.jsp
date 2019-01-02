<%@ page import="model.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/2/2019
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User u=null;
    if(request.getSession(false)!=null){
        session=request.getSession();
        u=(User)session.getAttribute("user");
    }
    else{
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
    }
%>
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
                            <div class="input-group input-group-sm" style="max-width:271px;">
                                <input class="form-control form-horizontal" placeholder="your email..." name="email" type="email" style="max-width:110px;">
                                <input class="form-control form-horizontal" placeholder="your password..." name="password" type="password" style="max-width:110px;">
                                <div class="input-group-btn" style="max-width:51px;">
                                    <button type="submit" class="btn btn-default" data-toggle="dropdown" value="submit" name="submit">Login</button>
                                </div>
                            </div>
                        </form>
                    </nav>
                </div>
                <!-- /top nav -->

                <div class="padding">
                    <div class="full col-sm-12">
                        <!-- content -->
                        <div class="row">
                            <div class="col-sm-10">
                                <div class="well">
                                    <form class="form-horizontal" role="form">
                                        <h4>What's New</h4>
                                        <div class="form-group" style="padding:14px;">
                                            <textarea class="form-control" placeholder="Update your status"></textarea>
                                        </div>
                                        <button class="btn btn-primary pull-right" type="button">Post</button>
                                        <ul class="list-inline"><li><a href=""></a></li><li><a href=""></a></li><li><a href=""></a></li></ul>
                                    </form>
                                </div>
                                <%
                                    if(u.getPostOfYourFriends()!=null){
                                        if(u.getPostOfYourFriends().size()>=1){
                                            for (int i = 0; i < u.getPostOfYourFriends().size(); i++) {
                                                out.println("<div class=\"panel panel-default\"><div class=\"panel-heading\"><a href=\"#\" class=\"pull-right\">"+u.getPostOfYourFriends().get(i).getUser().getFirstname()+"</a> "+u.getPostOfYourFriends().get(i).getPostDate()+"</div>");
                                                out.println("<div class=\"panel-body\"><div class=\"clearfix\"></div>");
                                                out.println("<p>"+u.getPostOfYourFriends().get(i).getData()+"</p>");
                                                out.println("<hr><form><div class=\"input-group\"><div class=\"input-group-btn\"><button class=\"btn btn-default\">Send-it!</i></button></div><input class=\"form-control\" placeholder=\"Add a comment..\" type=\"text\"></div></form></div></div>");
                                            }
                                        }
                                    }
                                %>
                            </div>
                            <!-- main col right -->
                            <div class="col-sm-2">
                                <div class="well">

                                </div>
                            </div>
                        </div><!--/row-->

                        <div class="row">
                            <div class="col-sm-6">
                                <a href="#">Nathan Pire</a> <small class="text-muted">|</small> <a href="#">le BG</a> <small class="text-muted">|</small> <a href="#">Raphael Dispaux</a>
                            </div>
                        </div>

                        <div class="row" id="footer">
                            <div class="col-sm-6">

                            </div>
                            <div class="col-sm-6">
                                <p>
                                    <a href="#" class="pull-right">Copyright 2018-2019 RPZ</a>
                                </p>
                            </div>
                        </div>

                        <hr>

                    </div><!-- /col-9 -->
                </div><!-- /padding -->
            </div>
            <!-- /main -->

        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/bootstrap.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('[data-toggle=offcanvas]').click(function() {
            $(this).toggleClass('visible-xs text-center');
            $(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
            $('.row-offcanvas').toggleClass('active');
            $('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
            $('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
            $('#btnShow').toggle();
        });
    });
</script>
</body></html>
