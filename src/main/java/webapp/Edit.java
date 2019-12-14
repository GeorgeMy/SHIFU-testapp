package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/edit"})
public class Edit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
             
            int id = Integer.parseInt(request.getParameter("id"));
            
            Object products = ObjectsDB.selectOne(id);
            
            if(products!=null){
                
                request.setAttribute("products", products);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
    
        }
        catch(Exception ex){
            System.out.print(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
           int Id = Integer.parseInt(request.getParameter("id"));
           String name = request.getParameter("name");
           Object object = new Object(Id, name);
           ObjectsDB.update(object);
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
