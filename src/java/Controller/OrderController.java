/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FakeDatabase;
import Model.MenuDAO;
import Model.MenuItem;
import Model.MenuService;
import Model.Reciept;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
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
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

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
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            MenuService menu = new MenuService(driverClassName, url, username, password);
            List<MenuItem> menuItems = menu.getAllMenuItems();

            List<MenuItem> orderedItems = new ArrayList<MenuItem>();
            
            for(int i = 0; i < menuItems.size(); i++) {
                Object obj = request.getParameter("menuItem" + i);
                if(obj != null) {
                    orderedItems.add(menuItems.get(i));
                }
            }
            
            session.setAttribute("order", orderedItems);
            
            
            Reciept reciept = new Reciept();
            double total = reciept.calcTotal(orderedItems);
            double tax = reciept.calcTax(orderedItems);
            
            String phone = 
                    this.getServletContext().getInitParameter("phone");
            
            session.setAttribute("phone", phone);
            session.setAttribute("total", nf.format(total));
            session.setAttribute("tax", nf.format(tax));
            session.setAttribute("gratuity", nf.format(reciept.calcGratuity(orderedItems)));
            session.setAttribute("subtotal", nf.format(total + tax));
            
            RequestDispatcher view =
                    request.getRequestDispatcher("/receipt.jsp");
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
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
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
