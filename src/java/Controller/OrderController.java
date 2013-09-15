/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FakeDatabase;
import Model.MenuItem;
import Model.MenuService;
import Model.Reciept;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            MenuService menu = new MenuService(new FakeDatabase());
            List<MenuItem> menuItems = menu.getMenuItems();

            List<MenuItem> orderedItems = new ArrayList<MenuItem>();
            
            for(int i = 0; i < menuItems.size(); i++) {
                Object obj = request.getParameter("menuItem" + i);
                if(obj != null) {
                    orderedItems.add(menuItems.get(i));
                }
            }
            
            request.setAttribute("order", orderedItems);
            
            
            Reciept reciept = new Reciept();
            double total = reciept.calcTotal(orderedItems);
            double tax = reciept.calcTax(orderedItems);
            
            request.setAttribute("total", nf.format(total));
            request.setAttribute("tax", nf.format(tax));
            request.setAttribute("gratuity", nf.format(reciept.calcGratuity(orderedItems)));
            request.setAttribute("subtotal", nf.format(total + tax));
            
            RequestDispatcher view =
                    request.getRequestDispatcher("/reciept.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
