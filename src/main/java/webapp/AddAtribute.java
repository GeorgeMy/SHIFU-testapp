/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/addAtribute"})
public class AddAtribute extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       getServletContext().getRequestDispatcher("/addAtribute.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {   int id = AtributesDB.select().size()+1;
            String name = request.getParameter("name");
            int objectID = Integer.parseInt(request.getParameter("el"));
            Atribute atribute = new Atribute(id, name, objectID);
            AtributesDB.insert(atribute);
            response.sendRedirect(request.getContextPath()+"");
            //response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex){
            getServletContext().getRequestDispatcher("/addAtribute.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
