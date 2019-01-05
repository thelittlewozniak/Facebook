package Controller;

import model.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UnLikePostServlet")
public class UnLikePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = null;
        User user = new User();
        HttpSession session = request.getSession();
        if (request.getParameter("id") != null) {
            id = request.getParameter("id");
            if (session.getAttribute("user") != null) {
                user = (User) session.getAttribute("user");
                user.deleteALikeOnPost(Integer.parseInt(id));
                response.sendRedirect("/Facebook_intelliJ_war_exploded/Activity/");
            } else
                response.sendRedirect("/Facebook_intelliJ_war_exploded/Index/");
        } else
            response.sendRedirect("/Facebook_intelliJ_war_exploded/Activity/");
    }
}
