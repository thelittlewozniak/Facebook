<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/6/2019
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/views/layout/header.jsp"/>
<div class="col-sm-6">
    <div class="well">
        <form class="form" action="/Facebook_intelliJ_war_exploded/WorkAdd/" method="post">
            <h4>Add a work</h4>
            <div class="input-group text-center">
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your company name:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your name company"
                           type="text" name="name">
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your company address:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your company address"
                           type="text" name="address">
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your Begin date:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your begin date"
                           type="Date" name="begindate">
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your job title:</label>
                    <input class="form-control input-lg" placeholder="Enter your job title" type="text"
                           name="jobtitle">
                </div>

                <button class="btn btn-lg btn-primary pull-right" type="submit" name="submit"
                        value="submit">Add your work!
                </button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="/views/layout/footer.jsp"/>