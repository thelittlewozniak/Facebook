<%@ page import="model.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/6/2019
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/views/layout/header.jsp"/>
<%
    User u = null;
    if (session.getAttribute("user") != null) {
        u = (User) session.getAttribute("user");
    } else {
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
    }
%>


<div class="col-sm-6">
    <%
        for (int i = 0; i < u.friendRequest().size(); i++) {
            out.println("<div class=\"panel panel-default\">");
            out.println("<div class=\"panel-body\"><div class=\"clearfix\"></div>");
            out.println("<a href=\"/Facebook_intelliJ_war_exploded/ProfileFriend?id="+u.friendRequest().get(i).getAsker().getId()+"\">" +u.friendRequest().get(i).getAsker().getFirstname()+" "+ u.friendRequest().get(i).getAsker().getLastname() + "</a><a href=\"/Facebook_intelliJ_war_exploded/AcceptFriend?id="+u.friendRequest().get(i).getAsker().getId()+"\" type=\"button\" class=\"pull-right btn btn-primary\">Accept</a><hr><p>"+u.friendRequest().get(i).getAsker().getAddress()+"</p>");
            out.println("</div></div>");
        }
    %>
</div>
<!-- main col right -->

<jsp:include page="/views/layout/footer.jsp"/>