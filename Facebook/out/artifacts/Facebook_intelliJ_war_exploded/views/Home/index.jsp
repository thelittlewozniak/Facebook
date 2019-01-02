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
    if(session.getAttribute("user")!=null){
        u=(User)session.getAttribute("user");
    }
    else{
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
    }
%>
            <!-- /top nav -->
<jsp:include page="/views/layout/header.jsp" />
                <div class="padding">
                    <div class="full col-sm-12">
                        <!-- content -->
                        <div class="row">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-6">
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
                                                out.println("<div class=\"panel panel-default\"><div class=\"panel-heading\"><a href=\"#\" class=\"pull-right\">"+u.getPostOfYourFriends().get(i).getUser().getFirstname()+" "+u.getPostOfYourFriends().get(i).getUser().getLastname()+"</a> "+u.getPostOfYourFriends().get(i).getPostDate()+"</div>");
                                                out.println("<div class=\"panel-body\"><div class=\"clearfix\"></div>");
                                                out.println("<p>"+u.getPostOfYourFriends().get(i).getData()+"</p>");
                                                out.println("<hr><form><div class=\"input-group\"><div class=\"input-group-btn\"><button class=\"btn btn-default\">Send-it!</i></button></div><input class=\"form-control\" placeholder=\"Add a comment..\" type=\"text\"></div></form></div></div>");
                                            }
                                        }
                                    }
                                %>
                            </div>
                            <!-- main col right -->
                            <div class="col-sm-3">
                                <div class="well">

                                </div>
                            </div>

                        </div><!--/row-->

<jsp:include page="/views/layout/footer.jsp" />