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
  <link href="css/bootstrap.css" rel="stylesheet">
  <!--[if lt IE 9]>
  <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
  <link href="css/facebook.css" rel="stylesheet">
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
                <a href="#"><i class="glyphicon glyphicon-home"></i> Home</a>
              </li>
              <li>
                <a href="#postModal" role="button" data-toggle="modal"><i class="glyphicon glyphicon-plus"></i> Post</a>
              </li>
              <li>
                <a href="#"><span class="badge">badge</span></a>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i></a>
                <ul class="dropdown-menu">
                  <li><a href="">More</a></li>
                  <li><a href="">More</a></li>
                  <li><a href="">More</a></li>
                  <li><a href="">More</a></li>
                  <li><a href="">More</a></li>
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

              <!-- main col right -->
              <div class="col-sm-12"
                <div class="well">
                  <form class="form">
                    <h4>Sign-up</h4>
                    <div class="input-group text-center">
                      <input class="form-control input-lg" placeholder="Enter your email address" type="text">
                      <span class="input-group-btn"><button class="btn btn-lg btn-primary" type="button">OK</button></span>
                    </div>
                  </form>
                </div>

                <div class="panel panel-default">
                  <div class="panel-heading"><a href="#" class="pull-right">Le Christ Cosmique</a> <h4>Facebook fait peau neuve!</h4></div>
                  <div class="panel-body">
                    et ouais les nullos, Raph le bg et moi on dev facebook!
                  </div>
                </div>
              </div>
            </div><!--/row-->

            <div class="row">
              <div class="col-sm-6">
                <a href="#">Twitter</a> <small class="text-muted">|</small> <a href="#">Facebook</a> <small class="text-muted">|</small> <a href="#">Google+</a>
              </div>
            </div>

            <div class="row" id="footer">
              <div class="col-sm-6">

              </div>
              <div class="col-sm-6">
                <p>
                  <a href="#" class="pull-right">ʃopyright 2013</a>
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


<!--post modal-->
<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">׼/button>
          Update Status
      </div>
      <div class="modal-body">
        <form class="form center-block">
          <div class="form-group">
            <textarea class="form-control input-lg" autofocus="" placeholder="What do you want to share?"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <div>
          <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">Post</button>
          <ul class="pull-left list-inline"><li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
        </div>
      </div>
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
