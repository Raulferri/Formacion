<%-- 
    Document   : registroEditorial
    Created on : 28-nov-2018, 11:12:59
    Author     : Arranque 4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--Link de Bootstrap que permite que se lean adecuadamente sus directivas--%>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <title>Registro de Editoriales</title>
    </head>
    <body>
        <%@include file="menu.jsp"%><%--Incluimos el menu al inicio de la pagina--%>
        <div class="form-control">
            <div class="table-header">
                Desde aqui puede añadir o eliminar una Editorial
            </div>
            <div>
                <form action="EditorialController" method="post" class="form-horizontal">
                    <br><br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">NIT</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="text" name="nit" value="" placeholder="NIT de la editorial"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Nombre:</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="text" name="nombre" value="" placeholder="Nombre de la editorial"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Telefono:</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="text" name="telefono" value="" placeholder="Telefono de la editorial"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Direccion:</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="text" name="direccion" value="" placeholder="Direccion de la editorial"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Email:</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="text" name="email" value="" placeholder="Email de la editorial"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Sitio Web:</label><%--Todas las opciones dentro de las clases son comandos de bootstrap--%>
                        <div class="col-sm-3">
                            <input type="text" name="sitioweb" value="" placeholder="Sitio web de la editorial"/>
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
