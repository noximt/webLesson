package by.yauheni.servlet;

import by.yauheni.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "remove")
public class RemovalServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String login = req.getParameter("login");
        String param = req.getParameter("parameter");
        switch (param){
            case "id":
                userService.removeByID(Long.parseLong(id));
                break;
            case "login":
                userService.removeBylogin(login);
                break;
        }
    }
}
