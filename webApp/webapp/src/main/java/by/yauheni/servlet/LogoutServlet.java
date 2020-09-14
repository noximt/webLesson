package by.yauheni.servlet;

import by.yauheni.domain.Operation;
import by.yauheni.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    private OperationService operationService = new OperationService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        operationService.saveToDB((List<Operation>)req.getSession().getAttribute("operations"));
        req.getSession().setAttribute("user", null);
    }
}
