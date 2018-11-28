<%-- 
    Document   : registroLibro
    Created on : 28-nov-2018, 13:20:11
    Author     : Raul Ferri
--%>

<%@page import="dao.EditorialDAO"%>
<%@page import="model.Editorial"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--Link de Bootstrap que permite que se lean adecuadamente sus directivas--%>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <title>Registro de Libros</title>
    </head>
    <body>
        <%@include file="menu.jsp"%><%--Incluimos el menu al inicio de la pagina--%>
        <div class="form-control">
            <div class="table-header">
                Desde aqui puede añadir o eliminar una Editorial
            </div>
            <div>
                <form action="LibroController" method="post" class="form-horizontal">
                    <br><br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">ISBN</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="text" name="isbn" value="" placeholder="ISBN del libro"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Titulo:</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="text" name="titulo" value="" placeholder="Titulo del libro"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Descripcion:</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <textarea name="descripcion" rows="4" cols="43" placeholder="Descripcion del libro"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Nombre del autor</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="text" name="autor" value="" placeholder="Autor del libro"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Fecha de publicacion:</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="date" name="publicacion" value="" placeholder="Publicacion del libro"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-paddding-right">
                            Categoría Temática:
                        </label>
                        <div class="col-sm-3">
                            <select name="categoria">
                                <option value="0">Seleccione Categoria</option>
                                <% for(Categoria c:CategoriaDAO.listar()){ %><%-- c recibe la lista de categoria que se recorrera--%>
                                <option value="<%= c.getCodigo()%>"><%= c.getNombre()%></option><%--Iterando en el bucle for, va añadiendo las diferentes categorias como opciones del desplegable--%>
                                <%}%>
                            </select>
                        </div> 
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-paddding-right">
                            Editorial:
                        </label>
                        <div class="col-sm-3">
                            <select name="editorial">
                                <option value="0">Seleccione la Editorial</option>
                                <% for(Editorial e:EditorialDAO.listar()){ %>
                                <option value="<%= e.getNit()%>"><%= e.getNombre() %></option>
                                <%}%>
                            </select>
                        </div> 
                    </div>
                    <br>
                    <div class="col-sm-3">
                        <button name="Registrar" class="btn btn-success" type="submit" value="Registrar">
                            <i class="fa fa-save"></i>
                            Registrar
                        </button>
                        <button name="Actualizar" class="btn btn-warning" type="submit" value="Actualizar">
                            <i class="fa fa-edit"></i>
                            Actualizar
                        </button>
                        <button name="Eliminar" class="btn btn-danger" type="submit" value="Eliminar">
                            <i class="fa fa-remove"></i>
                            Eliminar
                        </button>
                    </div>
                </form>
                <br>
                <%=(request.getAttribute("mensaje") != null ? request.getAttribute("mensaje"):"")%>
                <%--Una vez hecho el submit en los botones, recojemos el mensaje de regreso enviados por el controlador--%>
            </div>
        </div>
    </body>
</html>
