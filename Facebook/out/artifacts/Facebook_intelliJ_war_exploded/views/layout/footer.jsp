    <%--
      Created by IntelliJ IDEA.
      User: natha
      Date: 1/2/2019
      Time: 4:47 PM
      To change this template use File | Settings | File Templates.
    --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            <div class="col-sm-3">
            <div class="well">
            <div class="panel panel-default">
            <div class="panel-thumbnail"><img src="http://lh3.googleusercontent.com/OS6fHdRPAxpnB2PruNN0cGxC1txcI1zmG9bsZkmuF0AB-0pl0NivFPkTPPbEQ5WY7HGA6GPEZQAuVD_zCv0Y6xLj7mq611g5fFo=s1412-nu" class="img-responsive"></div>
            <div class="panel-body">
            <p class="lead">Google is hiring!</p>
            <p><a href="https://careers.google.com/">Join us!</a></p>
            </div>
            </div>
            <div class="panel panel-default">
            <div class="panel-thumbnail"><img src="https://research.fb.com/wp-content/uploads/2016/11/og_careers.jpg" class="img-responsive"></div>
            <div class="panel-body">
            <p class="lead">Facebook is hiring!</p>
            <p><a href="https://www.facebook.com/careers/">Join us!</a></p>
            </div>
            </div>
            </div>
            </div>

            </div><!--/row-->

            <div class="row">
        <div class="col-sm-6">
        <a href="#">Nathan Pire</a> <small class="text-muted">|</small> <a href="#">Raphael Dispaux</a>
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
