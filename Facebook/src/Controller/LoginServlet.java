package Controller;

import model.pojo.User;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String email = null;
        String password = null;
        if (request.getParameter("submit") != null) {
            email = request.getParameter("email");
            password = request.getParameter("password");
            User u = new User();
            if (u.login(email, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", u);
                response.sendRedirect("/Facebook_intelliJ_war_exploded/Activity/");
            } else {
                response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
            }
        }
    }
}
