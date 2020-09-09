package by.yauheni.servlet;

import by.yauheni.domain.User;
import by.yauheni.service.InMemoryUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/change")
public class MakeChangesServlet extends HttpServlet {
    InMemoryUserService userService = new InMemoryUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            User user = (User) req.getSession().getAttribute("user");
            resp.getWriter().println(user);
        } else {
            resp.getWriter().println("User is not auth");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String value = req.getParameter("value");
        String type = req.getParameter("type");
        switch (type){
            case "name":
                userService.updateName(value,Long.parseLong(id));
                break;
            case "pass":
                userService.updatePassword(value,Long.parseLong(id));
                break;
        }
    }
}
