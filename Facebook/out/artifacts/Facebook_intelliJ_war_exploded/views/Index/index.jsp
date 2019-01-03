<%@ page import="model.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 12/12/2018
  Time: 8:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 12/16/2018
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User u=null;
    if(session.getAttribute("user")!=null){
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Activity/");
    }
    %>
        <!-- /top nav -->
<jsp:include page="/views/layout/header.jsp" />

        <div class="padding">
          <div class="full col-sm-12">

            <!-- content -->
            <div class="row">
              <div class="col-sm-8">
                <div class="panel panel-default">
                  <div class="panel-heading">Connect with friends and the world around you on Facebook.</div>
                  <div class="panel-body">
                    <img src="https://scontent.fbru2-1.fna.fbcdn.net/v/t1.0-9/29512165_10216053466270970_8307976904525516907_n.jpg?_nc_cat=107&_nc_ht=scontent.fbru2-1.fna&oh=df283284cb7daf7f0828c55a70403bc2&oe=5CCE1544" class="img-circle pull-left">
                    <span class="pull">See photos and updates from friends in News Feed.</span>
                  </div>
                  <div class="panel-body">
                    <img src="https://scontent.fbru2-1.fna.fbcdn.net/v/t1.0-9/65711_10200499693363719_1241543246_n.jpg?_nc_cat=102&_nc_ht=scontent.fbru2-1.fna&oh=b9fd9f8fc96586a56396e710bdfecb68&oe=5CC825C9" class="img-circle pull-left">
                    <span>Share what's new in your life on your Timeline.</span>

                  </div>
                  <div class="panel-body">
                    <img src="https://scontent.fbru2-1.fna.fbcdn.net/v/t1.0-9/10300965_1445273082428150_7310414669714928221_n.jpg?_nc_cat=104&_nc_ht=scontent.fbru2-1.fna&oh=67f85bccb98fb4b246410a210ebfed3a&oe=5C91BB8B" class="img-circle pull-left">
                    <span>Find more of what you're looking for with Facebook Search.</span>
                  </div>
                </div>
                <div class="panel panel-default">
                  <div class="panel-heading"><a href="#" class="pull-right">Le Christ Cosmique</a> <h4>Facebook fait peau neuve!</h4></div>
                  <div class="panel-body">
                      et ouais les nullos, Raph le bg et moi on dev facebook!
                  </div>
                </div>
              </div>
              <!-- main col right -->
              <div class="col-sm-4">
                <div class="well">
                  <form class="form" action="/Facebook_intelliJ_war_exploded/Register/" method="post">
                    <h4>Sign-up</h4>
                    <div class="input-group text-center">
                        <div class="input-group-lg form-group">
                            <label class="control-label pull-left">Enter your email address:</label>
                            <input class="form-control input-lg pull-right" placeholder="Enter your email address" type="email" name="email">
                        </div>
                        <div class="input-group-lg form-group">
                            <label class="control-label pull-left">Enter your password:</label>
                            <input class="form-control input-lg pull-right" placeholder="Enter your email address" type="password" name="password">
                        </div>
                        <div class="input-group-lg form-group">
                            <label class="control-label pull-left">Re-enter your password:</label>
                            <input class="form-control input-lg pull-right" placeholder="Enter your email address" type="password">
                        </div>
                        <div class="input-group-lg form-group">
                            <label class="control-label pull-left">Enter your firstname:</label>
                            <input class="form-control input-lg pull-right" placeholder="Enter your Firstname" type="text" name="firstname">
                        </div>
                        <div class="input-group-lg form-group">
                            <label class="control-label pull-left">Enter your lastname:</label>
                            <input class="form-control input-lg pull-right" placeholder="Enter your Lastname" type="text" name="lastname">
                        </div>
                        <div class="input-group-lg form-group">
                            <label class="control-label pull-left">Enter your address:</label>
                            <input class="form-control input-lg pull-right" placeholder="Enter your address" type="text" name="address">
                        </div>
                        <div class="input-group-lg form-group">
                            <label class="control-label pull-left">Enter your birthday:</label>
                            <input class="form-control input-lg" placeholder="Enter your birthday" type="date" name="birthday">
                        </div>
                        <div class="input-group form-group">
                            <label class="control-label pull-left">Enter your relationship state:</label><br>
                            <label class="radio-inline" ><input name="relationship" value="true" type="radio">In a relationship    </label>
                            <label class="radio-inline" ><input name="relationship" value="false" type="radio">Single</label>
                        </div>
                        <div class="input-group-lg form-group">
                            <label class="control-label pull-left">Enter your Phone Number:</label>
                            <input class="form-control input-lg" placeholder="Enter your phone number" type="number" name="phonenumber">
                        </div>
                        <div class="input-group form-group">
                            <label class="control-label pull-left">Enter your gender:</label><br>
                            <label class="radio-inline" ><input name="gender" value="true" type="radio">Male</label>
                            <label class="radio-inline" ><input name="gender" value="false" type="radio">Female</label>
                        </div>
                        <div class="input-group form-group">
                            <label class="control-label pull-left">Interesed in:</label><br>
                            <label class="radio-inline" ><input name="interested" value="true" type="radio">Male</label>
                            <label class="radio-inline" ><input name="interested" value="false" type="radio">Female</label>
                        </div>

                        <button class="btn btn-lg btn-primary pull-right" type="submit" name="submit" value="submit">Register you!</button>
                    </div>
                  </form>
                </div>
              </div>
            </div><!--/row-->

<jsp:include page="/views/layout/footer.jsp" />