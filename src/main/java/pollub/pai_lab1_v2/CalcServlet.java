package pollub.pai_lab1_v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calcServlet", value = "/calc-servlet")
public class CalcServlet extends HttpServlet {

    public void init(){
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//
//        String num1 = req.getParameter("num1");
//        String num2 = req.getParameter("num2");
//        String operator = req.getParameter("operator");
////        oblicz(req);
//
//        PrintWriter out = resp.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Wynik obliczeń:</h1>");
//        out.println("<p>" + num1 + " " + operator + " " + num2 + " = " + oblicz(req) + "</p>");
//        out.println("</body></html>");
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String operator = req.getParameter("operator");
//        oblicz(req);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Wynik obliczeń:</h1>");
        out.println("<p>" + num1 + " " + operator + " " + num2 + " = " + oblicz(req) + "</p>");
        out.println("</body></html>");
        out.close();
    }

    public Float oblicz(HttpServletRequest request){
        Float num1 = Float.parseFloat(request.getParameter("num1"));
        Float num2 = Float.parseFloat(request.getParameter("num2"));
        String operator = request.getParameter("operator");

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                // mam wrażenie że nie powinno być to na defaulcie + nie ma ustawionego
                // defaulta w formularzu wiec sie wywali
                return num1 / num2;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
