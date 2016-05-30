<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>

<!DOCTYPE HTML>
<html>

<head>
	<v:head title="Toevoegen"/>
</head>

<body>
	<v:menu/>
	
	<h1>Brouwer toevoegen</h1>
	
	<c:url value="/brouwers" var = "url" />
	<v:brouwerform url="${url}" knopTekst="Toevoegen" />

</body>

</html>