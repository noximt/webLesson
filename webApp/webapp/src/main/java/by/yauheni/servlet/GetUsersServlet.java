package by.yauheni.servlet;

import by.yauheni.service.InMemoryUserService;
import by.yauheni.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/get")
public class GetUsersServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String byWhat = req.getParameter("byWhat");
        String byID = req.getParameter("byID");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        switch (byWhat){
            case "all":
                resp.getWriter().println(userService.getAllFromDB());
                break;
            case "byID":
                resp.getWriter().println(userService.getUserByIdFromDB(Long.parseLong(byID)));
                break;
            case "name":
                resp.getWriter().println(userService.getAllByNameFromDB(name));
                break;
            case "login":
                resp.getWriter().println(userService.getUserByLoginFromDB(login));
                break;
        }
    }
}
