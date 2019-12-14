package webapp;

import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class Servlet extends HttpServlet {
    
   protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
     res.setContentType("text/html");
     
     ArrayList<Object> products = ObjectsDB.select();
     req.setAttribute("products", products);

     getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
   }
    
}
