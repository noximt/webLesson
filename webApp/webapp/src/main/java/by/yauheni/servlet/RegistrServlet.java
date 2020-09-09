package by.yauheni.servlet;

import by.yauheni.domain.User;
import by.yauheni.service.InMemoryUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg",name = "regServlet")
public class RegistrServlet extends HttpServlet {
    private InMemoryUserService userService = new InMemoryUserService();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        User user = new User(login, password, name);
        userService.save(user);
    }
}
