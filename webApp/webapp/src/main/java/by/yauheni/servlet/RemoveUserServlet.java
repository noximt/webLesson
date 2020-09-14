package by.yauheni.servlet;

import by.yauheni.service.InMemoryUserService;
import by.yauheni.service.OperationService;
import by.yauheni.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/remove")
public class RemoveUserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("parameter");
        String id = req.getParameter("id");
        String login = req.getParameter("login");
        switch (param){
            case "id":
                userService.removeFromDBByID(Long.parseLong(id));
                break;
            case "login":
                userService.removeFromDBByLogin(login);
                break;
        }
    }
}
