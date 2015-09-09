<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>kickstarterWEB</title>
</head>
<body>
<h1>Project from "<c:out value="${categoryName}"/>" category</h1>
<br>
<p><h2><c:out value="${project.name} ${project.shortDescription}"/></h2></p>
<br>
<form>
<p><b>Sum to raise</b><c:out value=": ${project.sumToRaise}"/></p>
<p><b>Current sum</b><c:out value=": ${project.currentSum}"/></p>
<p><b>End date:</b><c:out value=" ${project.endDate}"/></p>
<p><b>Project history:</b><c:out value=" ${project.projectHistory}"/></p>
<p><b>FAQ:</b><c:out value=" ${project.fAQ}"/></h4></p>
<p><h4> <c:out value="Video: "/><a href="${project.demoURL}">${project.demoURL}</a> </h4></p>
</form>

<form action="addmoney" method="POST">
    <b>Amount to add:</b> <input type="number" name="addedamount"><br>
    <br>
    <b>Sponsor name:</b> <input type="text" width="12" name="sponsorname"><br>
    <b>Card number:</b> <input type="number" width="12" name="cardnumber"><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>