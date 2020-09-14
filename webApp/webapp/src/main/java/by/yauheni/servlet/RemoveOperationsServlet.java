package by.yauheni.servlet;

import by.yauheni.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/clear")
public class RemoveOperationsServlet extends HttpServlet {
    private OperationService operationService = new OperationService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (operationService.clearAllFromDB()){
            resp.getWriter().println("All operations were cleared!");
        }
    }
}
