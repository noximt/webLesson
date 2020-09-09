package by.yauheni.servlet;

import by.yauheni.domain.Operation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet(urlPatterns = "/memo")
public class MemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Operation> operations = (List<Operation>) req.getSession().getAttribute("history");
        String byWhat = req.getParameter("bywhat");
        String optype = req.getParameter("optype");
        String date = req.getParameter("date");
        switch(byWhat){
            case "all":
                resp.getWriter().println(operations);
                break;
            case "operation":
                List<Operation> operationsOptype = new ArrayList<>();
                for (int i = 0; i < operations.size(); i++) {
                    if (operations.get(i).getOpType().equals(optype)){
                        operationsOptype.add(operations.get(i));
                    }
                }
                resp.getWriter().println(operationsOptype);
                break;
            case "date":
                SimpleDateFormat formatter = new SimpleDateFormat("MMMM, dd, yyyy", Locale.ENGLISH);
                List<Operation> operationsData = new ArrayList<>();
                for (int i = 0; i < operations.size(); i++) {
                    try {
                        if (operations.get(i).getData().before(formatter.parse(date))){
                            operationsData.add(operations.get(i));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
        }


    }
}
