<%@ page import="model.pojo.*" %><%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/6/2019
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User u = null;
    User user=null;
    session=request.getSession();
    if(session!=null){
        if (session.getAttribute("user")!=null) {
            u = (User) session.getAttribute("user");
            if (request.getAttribute("friend")!=null){
                user=(User) request.getAttribute("friend");
            }
            else{
                response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
            }
        } else {
            response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
        }
    }
    else
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
%>

<jsp:include page="/views/layout/header.jsp"/>
<div class="col-sm-6">
    <%
        out.println("<h3>Details:</h3>");
        out.println("<div class=\"panel panel-default\">");
        out.println("<div class=\"panel-body\"><div class=\"clearfix\"></div>");
        out.println("<p>Firstname:" +user.getFirstname()+"</p><hr><p>Lastname:"+ user.getLastname() + "</p><hr><p> Address:"+user.getAddress()+"</p><hr><p> Birthday: "+user.getBirthday()+"</p><hr><p> active since:"+user.getRegisterDate()+"</p><hr><p>Gender:"+(user.getGender()?"man":"woman")+"</p><hr><p> Relationship:"+(user.getRelationship()?"in a relationship":"single")+"</p><hr><p> Phone number:"+user.getPhoneNumber()+"</p><hr><p> Interested in:"+(user.getInterestedIn()?"men":"woman")+"</p>");
        out.println("</div></div>");
        user.getUser();
        out.println("<h3>Friends List:</h3>");
        for (Friend f:user.getFriendList()) {
            out.println("<div class=\"panel panel-default\">");
            out.println("<div class=\"panel-body\"><div class=\"clearfix\"></div>");
            if(f.getAsker().getId()==u.getId())
                out.println("<p>" +f.getReceiver().getFirstname()+" "+ f.getReceiver().getLastname() + "</p>");
            else
                out.println("<p>" +f.getAsker().getFirstname()+" "+ f.getAsker().getLastname() + "</p>");
            out.println("</div></div>");
        }
        out.println("<h3>Posts:</h3>");
        for (Post p:user.getPosts()) {
            out.println("<div class=\"panel panel-default\">");
            out.println("<div class=\"panel-body\">"+p.getPostDate()+"<div class=\"clearfix\"></div>");
            out.println("<p>"+p.getData()+"<p>");
            out.println("</div></div>");
        }
        out.println("<h3>Works:</h3>");
        out.println("<br><div class=\"panel panel-default\">");
        for (Work w:user.getWorks()) {
            out.println("<div class=\"panel-body\">"+w.getName()+"<div class=\"clearfix\"></div>");
            out.println("<p>"+w.getJobTitle()+"</p> <p>"+w.getBeginDate()+"</p>  <p>"+w.getEndDate()+"</p>");
            out.println("</div>");
        }
        out.println("</div>");
        out.println("<h3>Schools:</h3>");
        out.println("<br><div class=\"panel panel-default\">");
        for (Schooling s:user.getSchoolings()) {
            out.println("<div class=\"panel-body\">"+s.getName()+"<div class=\"clearfix\"></div>");
            out.println("<p>"+s.getType()+"</p> <p>"+s.getBeginDate()+"</p>  <p>"+s.getEndDate()+"</p> <p>"+s.getGraduate()+"</p>");
            out.println("</div>");
        }
        out.println("</div>");
    %>
</div>
<jsp:include page="/views/layout/footer.jsp"/>
