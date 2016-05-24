<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>

<head>
	<v:head title="Zoeken"/>
</head>

<body>
	<v:menu/>
	
	<h1>Brouwers op naam</h1>
	
	<!-- Display ABC as links -->
	<nav><ul>
	<c:forEach items="${alfabet}" var="letter">
		
		<spring:url value="/brouwers/beginnaam/{eersteLetter}" var="letterLink">
			<spring:param name="eersteLetter" value="${letter}" />
		</spring:url>	
		<li><a href="${letterLink}">${letter}</a></li>
	
	</c:forEach>
	</ul></nav>
	
	<c:choose>
		<c:when test="${not empty brouwers}">
			<ul>
			<c:forEach items="${brouwers}" var="brouwer">
				<li>${brouwer.naam}</li>
			</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<span>Klik op een letter om brouwers te vinden met die beginletter.</span>
		</c:otherwise>
	
	</c:choose>

</body>

</html>