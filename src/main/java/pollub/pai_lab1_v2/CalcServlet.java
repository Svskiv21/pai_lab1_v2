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

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Wynik obliczeń " + oblicz(request) + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String oblicz(HttpServletRequest request){
        String komunikat = "";
        try {
            Double num1 = Double.parseDouble(request.getParameter("num1"));
            Double num2 = Double.parseDouble(request.getParameter("num2"));
            String operator = request.getParameter("operator");
            boolean isCorrect = true;
            Double result = null;


            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                default:
                    if (num1 == 0 || num2 == 0) {
                        isCorrect = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
            }
            if (isCorrect) {
                komunikat = "<p>" + num1 + operator + num2 + " = " + result + "</p>";
            } else {
                komunikat = "<p>Nie można dzielić przez 0!</p>";
            }
        } catch (NumberFormatException ex) {
            komunikat = "<p>Niepoprawne dane!</p>";
        }
        return komunikat;
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
