package Controller;

import model.pojo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "WorkAddServlet")
public class WorkAddServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    User u;
    HttpSession session = request.getSession();
    if (request.getParameter("submit") != null && session.getAttribute("user") != null) {
      u = (User) session.getAttribute("user");
      u.addAWork(
          request.getParameter("name"),
          request.getParameter("address"),
          request.getParameter("begindate"),
          request.getParameter("jobtitle"));
      response.sendRedirect("/Facebook_intelliJ_war_exploded/Profile/");
    } else response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
  }
}
