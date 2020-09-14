package by.yauheni.servlet;

import by.yauheni.domain.User;
import by.yauheni.service.InMemoryUserService;
import by.yauheni.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg",name = "regServlet")
public class RegistrServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);}

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        User user = new User(login, password, name);
        userService.saveToDB(user);
            getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
    }
}
