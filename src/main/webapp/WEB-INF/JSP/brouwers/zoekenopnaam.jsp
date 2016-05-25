<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>

<head>
	<v:head title="Zoeken op naam"/>
</head>

<body>
	<v:menu/>

	<h1>Zoeken op naam</h1>
	
	<c:url value="/brouwers" var="formTarget"/>
	
	<sform:form action="${formTarget}" commandName="zoekenOpNaam" method="get">
		<sform:label path="zoekstring">
		<sform:errors path="zoekstring" />
		Zoekstring:</sform:label>
		<sform:input path="zoekstring" autofocus="autofocus" required="required" type="search"/>
		<input type="submit" value="Zoeken" />
	</sform:form>
	
	<c:if test='${not empty brouwers}'>
	<ul>
		<c:forEach items='${brouwers}' var='brouwer'>
			<li>${brouwer.naam}</li>
		</c:forEach>
	</ul>
	</c:if>
	
</body>

</html>