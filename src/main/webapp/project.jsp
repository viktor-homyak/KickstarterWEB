<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>kickstarterWEB</title>
</head>
<body>
<h1>Project from "<c:out value="${categoryName}"/>" category</h1>
<br>

<p>

<h2><c:out value="${project.name} ${project.shortDescription}"/></h2></p>
<br>

<form>
    <p><b>Sum to raise</b><c:out value=": ${project.sumToRaise}"/></p>

    <p><b>Current sum</b><c:out value=": ${project.currentSum}"/></p>

    <p><b>End date:</b><c:out value=" ${project.endDate}"/></p>

    <p><b>Project history:</b><c:out value=" ${project.projectHistory}"/></p>

    <p><b>FAQ:</b><c:out value=" ${project.fAQ}"/></p>

    <p><h4><c:out value="Video: "/><a href="${project.demoURL}">${project.demoURL}</a></h4></p>
</form>

<form action="addmoney" method="POST">

    <p><b>You can help in raising money</b></p><br>
    <b>Amount to add:</b> <input type="number" name="addedAmount" required data-fv-notempty-message ="fill amount"><br>
    <br>
    <b>Sponsor name:</b> <input type="text" width="12" name="sponsorname"><br>
    <br>
    <b>Card number:</b> <input type="number" width="12" name="cardnumber"><br>
    <input type="hidden"  value="${project.id}" name="projectId">
    <input type="hidden" value="${project.parentId}" name="categoryId">
    <input type="hidden" value="${project.currentSum}" name="currentSum">
    <input type="submit" value="Submit">
</form>

</body>
</html>