<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>kickstarterWEB</title>
</head>
<body>
<h1>Project from "<c:out value="${categoryName}"/>" category</h1>
<br>
<p><h2><c:out value="${project.name} - ${project.shortDescription}"/></h2></p>
<br>
<p><h4><c:out value="Sum to raise=${project.sumToRaise}"/></h4></p>
<p><h4><c:out value="Current sum=${project.currentSum}"/></h4></p>
<p><h4><c:out value="End date: ${project.endDate}"/></h4></p>
<p><h4><c:out value="Project history: ${project.projectHistory}"/></h4></p>
<p><h4><c:out value="fAQ: ${project.fAQ}"/></h4></p>
<p><h4><c:out value="Video: ${project.demoURL}"/></h4></p>

</body>
</html>