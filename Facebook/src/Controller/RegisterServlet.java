package Controller;

import model.pojo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String email;
    String password;
    String firstname;
    String lastname;
    String address;
    String birthday;
    String relationShip;
    String phoneNumber;
    String gender;
    String interestedIn;
    if (request.getParameter("submit") != null) {
      email = request.getParameter("email");
      password = request.getParameter("password");
      firstname = request.getParameter("firstname");
      lastname = request.getParameter("lastname");
      address = request.getParameter("address");
      birthday = request.getParameter("birthday");
      relationShip = request.getParameter("relationship");
      phoneNumber = request.getParameter("phonenumber");
      gender = request.getParameter("gender");
      interestedIn = request.getParameter("interested");
      if (email != null
          && password != null
          && firstname != null
          && lastname != null
          && address != null
          && birthday != null
          && relationShip != null
          && phoneNumber != null
          && gender != null
          && interestedIn != null) {
        User u = new User();
        if (u.register(
            email,
            password,
            firstname,
            lastname,
            address,
            birthday,
            relationShip,
            phoneNumber,
            gender,
            interestedIn)) {
          HttpSession session = request.getSession();
          session.setAttribute("user", u);
          response.sendRedirect("/Facebook_intelliJ_war_exploded/Activity/");
        } else {
          response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
        }
      } else {
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
      }
    }
  }
}
