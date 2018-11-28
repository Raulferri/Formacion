/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;

/**
 *
 * @author Arranque 4
 */
public class CategoriaController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CategoriaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoriaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        //processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        Categoria c = new Categoria();
        c.setNombre(nombre);
        
        if(request.getParameter("Registrar") != null)
        {
            if(CategoriaDAO.registrar(c))//Llama a la funcion solicitada y comprueba que se ejecuta correctamente
            {
                request.setAttribute("mensaje", "La Categoria se ha registrado correctamente");
            }
            else
            {
                request.setAttribute("mensaje", "No se ha podido registrar la Categoria");
            }
        }
        else if(request.getParameter("Eliminar") != null)
        {
            if (CategoriaDAO.eliminar(c))//Llama a la funcion solicitada y comprueba que se ejecuta correctamente
            {
                request.setAttribute("mensaje", "Se ha eliminado la Categoria");
            }else
            {
                request.setAttribute("mensaje", "No se ha podido eliminar la Categoria");
            }
        }
        else
        {
            request.setAttribute("mensaje", "Accion desconocida");
        }
        
        request.getRequestDispatcher("registroCategoria.jsp").forward(request,response);
        //Aqui se ha utilizado request para devolver la respuesta en vez de response para ahorrar recursos,
        //por lo general es lo que se suele hacer
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
