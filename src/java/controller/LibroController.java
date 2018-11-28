/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LibroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Libro;

/**
 *
 * @author Raul Ferri
 */
public class LibroController extends HttpServlet {

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
            out.println("<title>Servlet LibroController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LibroController at " + request.getContextPath() + "</h1>");
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
        
        String isbn=request.getParameter("isbn");
        String titulo=request.getParameter("titulo");
        String autor=request.getParameter("autor");
        String publicacion=request.getParameter("publicacion");
        int categoria=Integer.parseInt(request.getParameter("categoria"));//Aqui se recibe un String y se convierte a entero con el parseInt
        String editorial=request.getParameter("editorial");
        String descripcion=request.getParameter("descripcion");
        
        //Se llama al modelo para setearle los valores escritos
        Libro lib = new Libro();
        lib.setIsbn(isbn);
        lib.setTitulo(titulo);
        lib.setNombre_autor(autor);
        lib.setPublicacion(publicacion);
        lib.setCodigo_categoria(categoria);
        lib.setNit_editorial(editorial);
        lib.setDescripcion(descripcion);
        
       /* se puede colocar una variable delante de las acciones como por ejemplo bRegistrar
        * bActualizar o bEliminar y ser consecuentes y colocar la misma letra en el jsp de 
        * registroLibro, donde se encuentran los botones con las acciones aqui citadas
        * se puede tambien y es lo que hemos hecho declarar un value= en los botones del jsp,
        * ahorrandonos asi esta opcion de llamar a las acciones precedidas por una letra 
        */
        if (request.getParameter("Registrar")!= null)//Espera a recibir una llamada cuando alguien pulse el boton en la web
        {
            if(LibroDAO.registrar(lib))//Llama a la funcion solicitada y comprueba que se ejecuta correctamente
            {
                request.setAttribute("mensaje","El Libro se ha registrado correctamente");
            }
            else
            {
                request.setAttribute("mensaje","No se ha podido registrar el libro");
            }
        }
        else if (request.getParameter("Actualizar")!= null)//Espera a recibir una llamada cuando alguien pulse el boton en la web
        {
            if (LibroDAO.actualizar(lib))//Llama a la funcion solicitada y comprueba que se ejecuta correctamente
            {
                request.setAttribute("mensaje","Se ha actualizado el Libro correctamente");
            }
            else
            {
                request.setAttribute("mensaje","Los datos del Libro no se han podido actualizar");
            }
        }
        else if (request.getParameter("Eliminar")!= null)//Espera a recibir una llamada cuando alguien pulse el boton en la web
        {
            if (LibroDAO.eliminar(lib))//Llama a la funcion solicitada y comprueba que se ejecuta correctamente
            {
                request.setAttribute("mensaje", "Se ha eliminado el Libro");
            }
            else
            {
                request.setAttribute("mensaje", "No se ha podido eliminar el Libro");
            }
        }
        else
        {
            request.setAttribute("mensaje", "Acción desconocida");
        }
        request.getRequestDispatcher("registroLibro.jsp").forward(request, response);
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
