<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecera.jsp" %>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap.min.css" />
        </script>
            <h1 style="clear:both">Conexion a la base de datos</h1>
                    <a href="agregarCliente.htm" class="btn btn-success">Agregar Cliente</a>
                <div class="card-body ">
                    <table id="listadoTabla" class="table table-bordered table-striped table-hover">
                        <thead>
                            <th>Item</th>
                            <th>nombre</th>
                            <th>direccion</th>
                            <th>correo</th>
                            <th>telefono</th>
                            <th>Salario</th>
                            <th>Acciones</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${cliente}" var="dato">
                            <tr>
                                <td><c:out value="${dato.id}"></c:out></td>
                                <td><c:out value="${dato.nombre}"></c:out></td>
                                <td><c:out value="${dato.direccion}"></c:out></td>
                                <td><c:out value="${dato.correo}"></c:out></td>
                                <td><c:out value="${dato.telefono}"></c:out></td>
                                <td><c:out value="${dato.salario}"></c:out></td>
                                <td>
                                    <a href="actCliente.htm?id=${dato.id}" 
                                   class="btn btn-warning">
                                    <span class="glyphicon glyphicon-pencil"></span></a> 
<!--                                    <a href="actCliente.htm?id=${dato.id}" class="btn btn-warning">Editar</a> 
    -->                                <a href="borrarCliente.htm?id=${dato.id}" class="btn btn-danger">
                                        <span class="glyphicon glyphicon-trash"></span>
                                        </a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

