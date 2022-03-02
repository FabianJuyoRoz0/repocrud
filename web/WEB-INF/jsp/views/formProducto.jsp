<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecera.jsp" %>
        <h1 style="clear:both">Ejemplo de FORM</h1>
        <div class="content">
            <form:form cssClass="navbar-form " method="post" commandName="cliente">
                <div>
                     Formulario para administrar productos
                </div>
                <br>
                <form:button name="Enviar" class="btn btn-success btn-lg">Consultar</form:button>
                <a class="btn btn-success btn-lg" href="index.htm" role="button" >Regresar...</a>

             </form:form>
            </div>
    </body>
</html>
