<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 1/6/2019
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/views/layout/header.jsp"/>
<div class="col-sm-6">
    <div class="well">
        <form class="form" action="/Facebook_intelliJ_war_exploded/SchoolAdd/" method="post">
            <h4>Add a school</h4>
            <div class="input-group text-center">
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your company name:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your name of school"
                           type="text" name="name">
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your type of school:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your type of school"
                           type="text" name="type">
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your company address:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your school address"
                           type="text" name="address">
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your Begin date:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your begin date"
                           type="Date" name="begindate">
                </div>
                <div class="input-group-lg form-group">
                    <label class="control-label pull-left">Enter your end date:</label>
                    <input class="form-control input-lg pull-right" placeholder="Enter your end date"
                           type="Date" name="enddate">
                </div>
                <div class="input-group form-group">
                    <label class="control-label pull-left">Are your graduated:</label><br>
                    <label class="radio-inline"><input name="graduate" value="true" type="radio">Yes</label>
                    <label class="radio-inline"><input name="graduate" value="false"
                                                       type="radio">No</label>
                </div>

                <button class="btn btn-lg btn-primary pull-right" type="submit" name="submit"
                        value="submit">Add your school!
                </button>
            </div>
        </form>
    </div>
</div>
<jsp:include page="/views/layout/footer.jsp"/>