package by.yauheni.servlet;

import by.yauheni.domain.Operation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/memo")
public class MemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         List<Operation> operations = (List<Operation>) req.getSession().getAttribute("history");
         resp.getWriter().println(operations);
    }
}
