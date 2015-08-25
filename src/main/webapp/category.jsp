<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>kickstarterWEB</title>
</head>
<body>
<h1>Projects from "<c:out value="${category}"/>" category</h1>
<br>
<ol>
    <c:forEach var="project" items="${projects}">
        <li><a href="projectId=${project.index}"><c:out value="${project.name}"/></a></li>
    </c:forEach>
</ol>
</body>
</html>