<%@ page import="model.pojo.*" %>
<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/5/2019
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User u = null;
    session = request.getSession();
    if (session != null) {
        if (session.getAttribute("user") != null) {
            u = (User) session.getAttribute("user");
        } else {
            response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
        }
    } else
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
%>

<jsp:include page="/views/layout/header.jsp"/>
<div class="col-sm-6">
    <%
        out.println("<a type=\"button\" class=\" pull-right btn btn-primary\" href=\"/Facebook_intelliJ_war_exploded/EditDetails\">Edit your details</a><h3>Details:</h3>");
        out.println("<div class=\"panel panel-default\">");
        out.println("<div class=\"panel-body\"><div class=\"clearfix\"></div>");
        out.println("<p>Firstname:" + u.getFirstname() + "</p><hr><p>Lastname:" + u.getLastname() + "</p><hr><p> Address:" + u.getAddress() + "</p><hr><p> Birthday: " + u.getBirthday() + "</p><hr><p> active since:" + u.getRegisterDate() + "</p><hr><p>Gender:" + (u.getGender() ? "man" : "woman") + "</p><hr><p> Relationship:" + (u.getRelationship() ? "in a relationship" : "single") + "</p><hr><p> Phone number:" + u.getPhoneNumber() + "</p><hr><p> Interested in:" + (u.getInterestedIn() ? "men" : "woman") + "</p>");
        out.println("</div></div>");
        u.getUser();
        out.println("<h3>Friends List:</h3>");
        for (Friend f : u.getFriendList()) {
            out.println("<div class=\"panel panel-default\">");
            out.println("<div class=\"panel-body\"><div class=\"clearfix\"></div>");
            if (f.getAsker().getId() == u.getId())
                out.println("<a href=\"/Facebook_intelliJ_war_exploded/ProfileFriend?id=" + f.getReceiver().getId() + "\">" + f.getReceiver().getFirstname() + " " + f.getReceiver().getLastname() + "</a>");
            else
                out.println("<a href=\"/Facebook_intelliJ_war_exploded/ProfileFriend?id=" + f.getAsker().getId() + "\">" + f.getAsker().getFirstname() + " " + f.getAsker().getLastname() + "</a>");
            out.println("</div></div>");
        }
        out.println("<h3>Posts:</h3>");
        for (Post p : u.getPosts()) {
            out.println("<div class=\"panel panel-default\">");
            out.println("<div class=\"panel-body\">" + p.getPostDate() + "<div class=\"clearfix\"></div>");
            out.println("<p>" + p.getData() + "<p>");
            out.println("</div></div>");
        }
        out.println("<h3>Works:</h3><a href=\"/Facebook_intelliJ_war_exploded/AddAWork\" type=\"button\" class=\"btn btn-primary\"> Add one!</a>");
        out.println("<br><div class=\"panel panel-default\">");
        for (Work w : u.getWorks()) {
            out.println("<div class=\"panel-body\">" + w.getName() + "<div class=\"clearfix\"></div>");
            out.println("<p>" + w.getJobTitle() + "</p> <p>" + w.getBeginDate() + "</p>  <p>" + w.getEndDate() + "</p><hr>");
            out.println("</div>");
        }
        out.println("</div>");
        out.println("<h3>Schools:</h3><a href=\"/Facebook_intelliJ_war_exploded/AddASchool\" type=\"button\" class=\"btn btn-primary\"> Add one!</a>");
        out.println("<br><div class=\"panel panel-default\">");
        for (Schooling s : u.getSchoolings()) {
            out.println("<div class=\"panel-body\">" + s.getName() + "<div class=\"clearfix\"></div>");
            out.println("<p>" + s.getType() + "</p> <p>" + s.getBeginDate() + "</p>  <p>" + s.getEndDate() + "</p> <p>" + s.getGraduate() + "</p><hr>");
            out.println("</div>");
        }
        out.println("</div>");
    %>
</div>
<jsp:include page="/views/layout/footer.jsp"/>
