package by.yauheni.servlet;

import by.yauheni.service.CaclService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    private CaclService  caclService = new CaclService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String optype = req.getParameter("optype");
        double result = caclService.calculate(optype, Integer.parseInt(x), Integer.parseInt(y));
        resp.getWriter().println(result);
    }
}
