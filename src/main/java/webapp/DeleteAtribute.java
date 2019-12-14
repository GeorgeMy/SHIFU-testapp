package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/deleteAtribute"})
public class DeleteAtribute extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            
            String name = request.getParameter("name");
            AtributesDB.delete(name);
            response.sendRedirect(request.getContextPath()+"");
        }
        catch(Exception ex){
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
