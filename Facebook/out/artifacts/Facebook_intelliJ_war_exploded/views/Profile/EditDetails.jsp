<%@ page import="model.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/6/2019
  Time: 5:54 PM
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
    <div class="well">
        <form class="form" action="/Facebook_intelliJ_war_exploded/UserEdit/" method="post">
            <h4>Add a work</h4>
            <div class="input-group text-center">
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your firstname:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your firstname"
                           type="text" name="firstname" value="<%=u.getFirstname()%>">
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your lastname:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your type lastname"
                           type="text" name="lastname" value="<%=u.getLastname()%>">
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your address:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your address"
                           type="text" name="address" value="<%=u.getAddress()%>">
                </div>
                <div class="input-group form-group">
                    <label class="control-label pull-left">Are you in a relationship:</label><br>
                    <label class="radio-inline"><input name="relationship" value="true" type="radio">In a
                        relationship</label>
                    <label class="radio-inline"><input name="relationship" value="false" checked
                                                       type="radio">Single</label>
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your phone number:</label>
                    <input class="form-control input-lg pull-right" value="<%=u.getPhoneNumber()%>"
                           type="text" name="phonenumber">
                </div>
                <button class="btn btn-lg btn-primary pull-right" type="submit" name="submit"
                        value="submit">Edits your informations!
                </button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="/views/layout/footer.jsp"/>