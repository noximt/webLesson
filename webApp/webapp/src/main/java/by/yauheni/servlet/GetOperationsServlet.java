package by.yauheni.servlet;

import by.yauheni.domain.Operation;
import by.yauheni.domain.User;
import by.yauheni.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "GetOperationsServlet")
public class GetOperationsServlet extends HttpServlet {
    private OperationService operationService = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String byWhat = req.getParameter("byWhat");
        String opType = req.getParameter("opType");
        String dateFormat = req.getParameter("date");
        switch (byWhat) {
            case "all":
                resp.getWriter().println(operationService.getAllFromDB());
                break;
            case "byOperation":
                User user = (User) req.getSession().getAttribute("user");
                resp.getWriter().println(operationService.getByOperationFromDB(opType, user.getId()));
                break;
            case "byDate":
                resp.getWriter().println();
                break;
        }
    }

    public static void main(String[] args) {
        Operation operation = new Operation(1,1,20,"sum", 10, 30, new Date());
        String s = "dd/MM/yyyy HH:mm:ss";
        String s1 = "28/09/1996 14:00:00";
        SimpleDateFormat format = new SimpleDateFormat(s);
        System.out.println(operation.getDate());
        System.out.println(format.format(operation.getDate()));
        try {
            System.out.println(format.format(format.parse(s1)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String s2 = String.valueOf(operation.getDate());
        System.out.println(s2);
    }
}
