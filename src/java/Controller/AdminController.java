/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MenuItem;
import Model.MenuService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bit
 */
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String driverClassName = 
                    this.getServletContext().getInitParameter("driver-class-name");
        String url = 
                    this.getServletContext().getInitParameter("url");
        String username = 
                    this.getServletContext().getInitParameter("username");
        String password = 
                    this.getServletContext().getInitParameter("password");
        try {
            RequestDispatcher view;

            MenuService menu = new MenuService(driverClassName, url, username, password);

            MenuItem selectedItem = new MenuItem();
            String id = null;
            id = request.getParameter("id");

            int row = 0;



            String action = request.getParameter("formAction");

            if (action.equals("delete")) {
                row = menu.deleteItem(id);
                session.setAttribute("row", row);
                view = request.getRequestDispatcher("/admin.jsp");
            } else if (action.equals("modify") || action.equals("add")) {
                if (id != null) {
                    selectedItem = menu.getItemById(id);
                    session.setAttribute("item", selectedItem);
                    session.setAttribute("id", selectedItem.getId());
                    session.setAttribute("name", selectedItem.getName());
                    session.setAttribute("price", selectedItem.getPrice());
                }
                view = request.getRequestDispatcher("/modifyAdd.jsp");
            } else {
                view = request.getRequestDispatcher("/admin.jsp");
            }


            session.setAttribute("row", row);



            List<MenuItem> menuItems = menu.getAllMenuItems();
            session.setAttribute("menuItems", menuItems);

//            view = request.getRequestDispatcher("/admin.jsp");
            
            view.forward(request, response);
        } finally {            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
