package by.yauheni.servlet;

import by.yauheni.domain.User;
import by.yauheni.service.InMemoryUserService;
import by.yauheni.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth")
public class AuthorizeServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/auth.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = (User) userService.getUserByLoginFromDB(login);
        if (user.getPassword().equals(password)){
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/calculator.jsp").forward(req, resp);
        }else{
            req.setAttribute("message","Wrong password");
            getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
        }

    }
}
