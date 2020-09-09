package by.yauheni.servlet;

import by.yauheni.domain.Operation;
import by.yauheni.service.CaclService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "calculateservlet",urlPatterns = "/calculate")
public class CalculateServlet extends HttpServlet {
    private CaclService  caclService = new CaclService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String optype = req.getParameter("optype");
        HttpSession session = req.getSession();
        List<Operation> operations = (List<Operation>) session.getAttribute("history");
        double result = caclService.calculate(optype, Integer.parseInt(x), Integer.parseInt(y));
        Operation operation = new Operation(Double.parseDouble(x),Double.parseDouble(y), result, optype);
        operations.add(operation);
        resp.getWriter().println(result);
    }
}
