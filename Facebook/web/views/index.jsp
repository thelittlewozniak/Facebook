<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 12/12/2018
  Time: 8:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 12/16/2018
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <title>Facebook Theme Demo</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="../css/bootstrap.css" rel="stylesheet">
  <!--[if lt IE 9]>
  <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
  <link href="../css/facebook.css" rel="stylesheet">
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
            <a href="http://usebootstrap.com/theme/facebook" class="navbar-brand logo">b</a>
          </div>
          <nav class="collapse navbar-collapse" role="navigation">
            <form class="navbar-form navbar-left">
              <div class="input-group input-group-sm" style="max-width:360px;">
                <input class="form-control" placeholder="Search" name="srch-term" id="srch-term" type="text">
                <div class="input-group-btn">
                  <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
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
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Login</a>
                <ul class="dropdown-menu">
                </ul>
              </li>
            </ul>
          </nav>
        </div>
        <!-- /top nav -->

        <div class="padding">
          <div class="full col-sm-12">

            <!-- content -->
            <div class="row">
              <div class="col-sm-6">
                <div class="panel panel-default">
                  <div class="panel-heading">Connect with friends and the world around you on Facebook.</div>
                  <div class="panel-body">
                    <img src="https://scontent.fbru2-1.fna.fbcdn.net/v/t1.0-9/29512165_10216053466270970_8307976904525516907_n.jpg?_nc_cat=107&_nc_ht=scontent.fbru2-1.fna&oh=df283284cb7daf7f0828c55a70403bc2&oe=5CCE1544" class="img-circle pull-left">
                    <span class="pull">See photos and updates from friends in News Feed.</span>
                  </div>
                  <div class="panel-body">
                    <img src="https://scontent.fbru2-1.fna.fbcdn.net/v/t1.0-9/65711_10200499693363719_1241543246_n.jpg?_nc_cat=102&_nc_ht=scontent.fbru2-1.fna&oh=b9fd9f8fc96586a56396e710bdfecb68&oe=5CC825C9" class="img-circle pull-left">
                    <span>Share what's new in your life on your Timeline.</span>

                  </div>
                  <div class="panel-body">
                    <img src="https://scontent.fbru2-1.fna.fbcdn.net/v/t1.0-9/10300965_1445273082428150_7310414669714928221_n.jpg?_nc_cat=104&_nc_ht=scontent.fbru2-1.fna&oh=67f85bccb98fb4b246410a210ebfed3a&oe=5C91BB8B" class="img-circle pull-left">
                    <span>Find more of what you're looking for with Facebook Search.</span>
                  </div>
                </div>
              </div>
              <!-- main col right -->
              <div class="col-sm-6">
                <div class="panel panel-default">
                  <div class="panel-heading"><a href="#" class="pull-right">Le Christ Cosmique</a> <h4>Facebook fait peau neuve!</h4></div>
                  <div class="panel-body">
                    et ouais les nullos, Raph le bg et moi on dev facebook!
                  </div>
                </div>
                <div class="well">
                  <form class="form">
                    <h4>Sign-up</h4>
                    <div class="input-group text-center">
                      <div class="input-group-lg form-group">
                        <label class="control-label pull-left">Enter your email address:</label>
                        <input class="form-control input-lg pull-right" placeholder="Enter your email address" type="text">
                      </div>
                      <div class="input-group-lg form-group">
                        <label class="control-label pull-left">Enter your firstname:</label>
                        <input class="form-control input-lg pull-right" placeholder="Enter your Firstname" type="text">
                      </div>
                      <div class="input-group-lg form-group">
                        <label class="control-label pull-left">Enter your lastname:</label>
                        <input class="form-control input-lg pull-right" placeholder="Enter your Lastname" type="text">
                      </div>
                      <input class="form-control input-lg" placeholder="Enter your birthday" type="date">
                      <input class="form-control input-lg" placeholder="Enter your phone number" type="number">
                      <button class="btn btn-lg btn-primary pull-right" type="button">Register you!</button>
                    </div>
                  </form>
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
