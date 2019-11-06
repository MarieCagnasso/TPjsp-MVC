/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rima.tpjsp.mvc.controler;

import fr.rima.tpjsp.mvc.dao.DAOException;
import fr.rima.tpjsp.mvc.data.DataSourceFactory;
import fr.rima.tpjsp.mvc.dao.DiscountCodeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import fr.rima.tpjsp.mvc.data.DataSourceFactory;

import fr.rima.tpjsp.mvc.dao.DiscountCodeDAO;
import fr.rima.tpjsp.mvc.model.DiscountCodeEntity;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author marie
 */
@WebServlet(name = "ShowCode", urlPatterns = {"/"})
public class ShowCodeControler extends HttpServlet {

    private DiscountCodeDAO dao; // L'objet à tester
    private DataSource myDataSource;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOException {
        myDataSource = DataSourceFactory.getDataSource();
        DiscountCodeDAO dao = new DiscountCodeDAO(DataSourceFactory.getDataSource());
        
        List<DiscountCodeEntity> codes = dao.showAllCode();
        
        request.setAttribute("codes", codes);
        String jspView = "addDiscountCode.jsp";
        request.getRequestDispatcher("views/" + jspView).forward(request, response);
    }
    
        
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        } catch (DAOException ex) {
            Logger.getLogger(ShowCodeControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
        } catch (DAOException ex) {
            Logger.getLogger(ShowCodeControler.class.getName()).log(Level.SEVERE, null, ex);
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
