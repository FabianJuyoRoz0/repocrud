<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecera.jsp" %>
<H1 style="clear:both"> &nbsp;</H1>
                    <h1>Modificar Clientes</h1>                                   
                    <form:form commandName="cliente" method="post">
                        <form:errors path="*"></form:errors><br><br>
                        <form:label path="nombre" cssClass="input-group-addon">Digite el Nombre: </form:label>
                        <form:input path="nombre" cssClass="form-control"></form:input>
                         <form:label path="direccion" cssClass="input-group-addon">Digite la Dirección:  </form:label>
                        <form:input path="direccion" cssClass="form-control"></form:input>
                        <form:label path="correo" cssClass="input-group-addon">Digite el e-Mail: </form:label>
                        <form:input path="correo" cssClass="form-control"></form:input>
                        <form:label path="telefono" cssClass="input-group-addon">Digite el Teléfono: </form:label>
                        <form:input path="telefono" cssClass="form-control"></form:input>
                        <form:label path="salario" cssClass="input-group-addon">Digite el salario: </form:label>
                        <form:input path="salario" cssClass="form-control"></form:input>
                        <form:button value="Enviar_datos" class="btn btn-success btn-md">
                            Enviar Datos
                        </form:button>
                            <input type="reset" value="Limpiar..." class="btn btn-success btn-md"/>
                            <a href="formCliente.htm" class="btn btn-success btn-md">Regresar<a/>
                    </form:form>
                                      <c:out value="${cli[0].nombre}"></c:out>
                                      <c:out value="${cli[0].direccion}"></c:out>
                                      <c:out value="${cli[0].correo}"></c:out>
                                      <c:out value="${cli[0].telefono}"></c:out>
                                      <c:out value="${cli[0].salario}"></c:out>

                </div>
            </div>
        </div>
    </div>
    </body>
</html>
