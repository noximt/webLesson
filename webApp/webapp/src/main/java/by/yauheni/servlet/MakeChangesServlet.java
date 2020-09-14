package by.yauheni.servlet;

import by.yauheni.domain.User;
import by.yauheni.service.InMemoryUserService;
import by.yauheni.service.UserService;
import by.yauheni.storage.UserStorageDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/change")
public class MakeChangesServlet extends HttpServlet {
    private UserService userService = new UserService();

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
                userService.updateNameInDB(value,Long.parseLong(id));
                break;
            case "pass":
                userService.updatePasswordInDB(value,Long.parseLong(id));
                break;
        }
    }
}
