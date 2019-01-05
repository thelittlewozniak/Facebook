<%@ page import="model.pojo.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="model.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/5/2019
  Time: 1:45 PM
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
                    if (u.searchAUser(request.getParameter("keyword")) != null) {
                        List<User> users = u.searchAUser(request.getParameter("keyword"));
                        if (users.size() >= 1) {
                            for (int i = 0; i < users.size(); i++) {
                                User user = users.get(i);
                                out.println("<div class=\"panel panel-default\">");
                                out.println("<div class=\"panel-body\"><div class=\"clearfix\"></div>");
                                out.println("<p>" +user.getFirstname()+" "+ user.getLastname() + "</p><hr><p>"+user.getAddress()+"</p>");
                                out.println("</div></div>");
                            }
                        }
                    }
                %>
            </div>
            <!-- main col right -->

<jsp:include page="/views/layout/footer.jsp"/>