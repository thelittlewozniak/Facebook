package Controller;

import model.pojo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MakeCommentServlet")
public class MakeCommentServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String data;
    int id;
    User u;
    HttpSession session = request.getSession();
    if (request.getParameter("submit") != null && session.getAttribute("user") != null) {
      data = request.getParameter("data");
      id = Integer.parseInt(request.getParameter("id"));
      u = (User) session.getAttribute("user");
      if (u.makeAComment(data, "string", id))
        response.sendRedirect("/Facebook_intelliJ_war_exploded/Activity/");
      else response.sendRedirect("/Facebook_intelliJ_war_exploded/Activity/");
    } else response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
  }
}
