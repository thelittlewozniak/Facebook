<%@ page import="model.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/5/2019
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User u = null;
    session=request.getSession();
    if(session!=null){
        if (session.getAttribute("user")!=null) {
            u = (User) session.getAttribute("user");
        } else {
            response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
        }
    }
    else
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
%>

<jsp:include page="/views/layout/header.jsp"/>

<jsp:include page="/views/layout/footer.jsp"/>
