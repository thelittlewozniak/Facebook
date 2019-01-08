package Controller;

import model.pojo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AcceptFriendServlet")
public class AcceptFriendServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String id;
    User user;
    HttpSession session = request.getSession();
    if (request.getParameter("id") != null) {
      id = request.getParameter("id");
      if (session.getAttribute("user") != null) {
        user = (User) session.getAttribute("user");
        user.acceptAFriend(Integer.parseInt(id));
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Activity/");
      } else response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
    } else response.sendRedirect("/Facebook_intelliJ_war_exploded/Activity/");
  }
}
