<%-- Pagina de edicao de mercadoria. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<spring:message code="label.editar" var="label_editar" htmlEscape="false" />
	<spring:message code="msg.erro.clasificacion.inexistente" var="clasificacion_inexistente" htmlEscape="false" />
	
	<c:if test="${clasificacion != null}" var="temClasificacion">
		<c:import url="/WEB-INF/views/clasificacion/mantener/formClasificacion.jsp">
			<c:param name="method" value="PUT" />
			<c:param name="sublabel" value="${label_editar}" />
			<c:param name="enableRemove" value="true" />
		</c:import>
		
	   	<form:form id="deleteClasificacion" action="" method="DELETE"></form:form>
	   	
	   	<script>
	   	$(document).ready(function () {
	   		$("#excluir").click(function () {
	   	   		$("#deleteClasificacion").submit();
	     	});
	   	});
		</script>
	</c:if>
	<c:if test="${!temClasificacion}">
		<h3>${clasificacion_inexistente}</h3>
	</c:if>
	
</div>