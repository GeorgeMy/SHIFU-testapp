package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/editatribute"})
public class EditAtribute extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             
            int id = Integer.parseInt(request.getParameter("id"));
            Atribute atribute = AtributesDB.selectById(id);
            
            
            if(atribute!=null){
                
                request.setAttribute("atribute", atribute);
                getServletContext().getRequestDispatcher("/editAtributes.jsp").forward(request, response);
            }
    
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
           int Id = Integer.parseInt(request.getParameter("id"));
           String name = request.getParameter("name");
           int El = Integer.parseInt(request.getParameter("el"));
           Atribute atribute = new Atribute(Id, name, El);
           AtributesDB.update(atribute);
           response.sendRedirect(request.getContextPath()+"");
        }
        catch(Exception ex){
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private PrintWriter PritWriter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
