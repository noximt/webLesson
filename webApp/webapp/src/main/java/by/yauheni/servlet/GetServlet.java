package by.yauheni.servlet;

import by.yauheni.service.InMemoryUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/get")
public class GetServlet extends HttpServlet {
    private InMemoryUserService userService = new InMemoryUserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String byWhat = req.getParameter("byWhat");
        String byID = req.getParameter("byID");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        switch (byWhat){
            case "all":
                resp.getWriter().println(userService.getAll());
                break;
            case "byID":
                resp.getWriter().println(userService.getByID(Long.parseLong(byID)));
                break;
            case "name":
                resp.getWriter().println(userService.getByName(name));
                break;
            case "login":
                resp.getWriter().println(userService.getByLogin(login));
                break;
        }
    }
}
