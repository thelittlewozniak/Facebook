<%@ page import="model.pojo.Comment" %>
<%@ page import="model.pojo.Post" %>
<%@ page import="model.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/2/2019
  Time: 12:58 PM
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
<!-- /top nav -->
<jsp:include page="/views/layout/header.jsp"/>
            <div class="col-sm-6">
                <div class="well">
                    <form class="form-horizontal" role="form" method="post"
                          action="/Facebook_intelliJ_war_exploded/MakeAPost/">
                        <h4>What's New</h4>
                        <div class="form-group" style="padding:14px;">
                            <textarea class="form-control" placeholder="Update your status" name="data"></textarea>
                        </div>
                        <button class="btn btn-primary pull-right" type="submit" name="submit" value="submit">Post
                        </button>
                        <ul class="list-inline">
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                            <li><a href=""></a></li>
                        </ul>
                    </form>
                </div>
                <%
                    if (u.getPostOfYourFriends() != null) {
                        List<Post> posts = u.getPostOfYourFriends();
                        if (posts.size() >= 1) {
                            for (int i = 0; i < u.getPostOfYourFriends().size(); i++) {
                                Post p = u.getPostOfYourFriends().get(i);
                                p.getAPost();
                                out.println("<div class=\"panel panel-default\"><div class=\"panel-heading\"><a href=\"#\" class=\"pull-right\">" + p.getUser().getFirstname() + " " + p.getUser().getLastname() + "</a> " + p.getPostDate() + "</div>");
                                out.println("<div class=\"panel-body\"><div class=\"clearfix\"></div>");
                                out.println("<p>" + p.getData() + "</p>");
                                out.println("<hr>");
                                if (p.getLikes() != null)
                                    out.println("<div class=\"pull-left\">" + p.getLikes().size() + " likes </div>");
                                else
                                    out.println("<div class=\"pull-left\">0 like </div>");
                                if (p.getComments() != null)
                                    out.println("<p class=\"pull-right\">" + p.getComments().size() + " comments </p><br><br>");
                                else
                                    out.println("<p class=\"pull-right\">0 comment </p><br><br>");
                                if (p.getComments().size() > 0) {
                                    for (int j = 0; j < p.getComments().size(); j++) {
                                        Comment comment = p.getComments().get(j);
                                        comment.getAComment();
                                        int test = 0;
                                        for (int k = 0; k < comment.getLikes().size(); k++) {
                                            if (comment.getLikes().get(k).getUser().getId() == u.getId())
                                                test = comment.getLikes().get(k).getId();
                                        }
                                        if (test != 0) {
                                            out.println("<div class=\"comment\"><div class=\"well\" style=\"padding:0\"><div>" + comment.getUser().getFirstname() + " " + comment.getUser().getLastname() + ":" + comment.getData() + "</div><div style=\"font-size:9px\">" + comment.getPostDate() + " <a href=\"/Facebook_intelliJ_war_exploded/UnLikeAComment?id=" + test + "\">UnLike it!</a></div></div></div>");
                                        } else {
                                            out.println("<div class=\"comment\"><div class=\"well\" style=\"padding:0\"><div>" + comment.getUser().getFirstname() + " " + comment.getUser().getLastname() + ":" + comment.getData() + "</div><div style=\"font-size:9px\">" + comment.getPostDate() + " <a href=\"/Facebook_intelliJ_war_exploded/LikeAComment?id=" + comment.getId() + "\">Like it!</a></div></div></div>");
                                        }
                                    }
                                }
                                out.println("<form action=\"/Facebook_intelliJ_war_exploded/MakeAComment/\" method=\"post\"><div class=\"input-group\"><div class=\"input-group-btn\">");
                                if (p.getLikes().size() > 0) {
                                    for (int j = 0; j < p.getLikes().size(); j++) {
                                        if (p.getLikes().get(j).getUser().getId() == u.getId())
                                            out.println("<a type=\"button\" class=\"btn btn-primary\" href=\"/Facebook_intelliJ_war_exploded/UnLikeAPost?id=" + p.getLikes().get(j).getId() + "\">UnLike it!</a>");
                                        else
                                            out.println("<a type=\"button\" class=\"btn btn-primary\" href=\"/Facebook_intelliJ_war_exploded/LikeAPost?id=" + p.getId() + "\">Like it!</a>");
                                    }
                                } else
                                    out.println("<a type=\"button\" class=\"btn btn-primary\" href=\"/Facebook_intelliJ_war_exploded/LikeAPost?id=" + p.getId() + "\">Like it!</a>");
                                out.println("<button type=\"submit\" name=\"submit\" value=\"submit\" class=\"btn btn-default\">Send-it!</i></button></div><input type=\"hidden\" value=\"" + p.getId() + "\" name=\"id\"><input class=\"form-control\" placeholder=\"Add a comment..\" type=\"text\" name=\"data\"></div></form></div>");
                                out.println("</div>");
                            }
                        }
                    }
                %>
            </div>
<jsp:include page="/views/layout/footer.jsp"/>