<%-- 
    Document   : listarLibros
    Created on : 29-nov-2018, 8:33:44
    Author     : Arranque 4
--%>

<%@page import="dao.CategoriaDAO"%>
<%@page import="dao.EditorialDAO"%>
<%@page import="dao.LibroDAO"%>
<%@page import="model.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--Link de Bootstrap que permite que se lean adecuadamente sus directivas--%>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <title>Listado de libros</title>
    </head>
    <body>
        <%@include file="menu.jsp"%><%--Incluimos el menu al inicio de la pagina--%>
        <div class="row">
            <div class="col-xs-12">
                <div class="row">
                    <div class="col-xs-12">
                        <div>
                            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>ISBN</th>
                                        <th>Titulo del Libro</th>
                                        <th>Autor</th>
                                        <th><i class="ace-icon fa fa-calendar-o"></i> Fecha de Publicación</th>
                                        <th>Editorial</th>
                                        <th>Categoría</th>
                                        <th>Editar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for(Libro l:LibroDAO.listar()){%>
                                    <tr>
                                        <td><%= l.getIsbn() %> </td>
                                        <td><%= l.getTitulo()%></td>
                                        <td><%= l.getNombre_autor()%></td>
                                        <td><%= l.getPublicacion()%></td>
                                        <td><span class="label label-sm label-success"><%= EditorialDAO.getEditorial(l.getNit_editorial())%></span></td>
                                        <td><span class="label label-sm label-success"><%= CategoriaDAO.getCategoria(l.getCodigo_categoria())%></span></td>
                                        <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a class="green" href="registroLibro.jsp">
                                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>
                                                <a class="red" href="registroLibro.jsp">
                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                </a>
                                            </div>
                                        </td>            
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
