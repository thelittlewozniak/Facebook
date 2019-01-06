package Controller;

import model.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserEditServlet")
public class UserEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = null;
        HttpSession session = request.getSession();
        if (request.getParameter("submit") != null && session.getAttribute("user") != null) {
            u=(User) session.getAttribute("user");
            u.setFirstname(request.getParameter("firstname"));
            u.setLastname(request.getParameter("lastname"));
            u.setRelationship(Boolean.parseBoolean(request.getParameter("relationship")));
            u.setPhoneNumber(Integer.parseInt(request.getParameter("phonenumber")));
            u.setAddress(request.getParameter("address"));
            u.updateUser();
            response.sendRedirect("/Facebook_intelliJ_war_exploded/Profile/");
        }
        else
            response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
    }
}
