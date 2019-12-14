package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/showAtt"})
public class showAtt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
             
                int id = Integer.parseInt(request.getParameter("id"));
            
                ArrayList<Atribute> atributes = AtributesDB.selectByObjectId(id);
                
                request.setAttribute("id", id);
                request.setAttribute("atributes", atributes);
                getServletContext().getRequestDispatcher("/showatributes.jsp").forward(request, response);
            
    
        }
        catch(Exception ex){
            System.out.print(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
