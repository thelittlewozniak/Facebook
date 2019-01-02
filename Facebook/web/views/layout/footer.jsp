<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/2/2019
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
