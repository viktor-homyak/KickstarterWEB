<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>kickstarterWEB</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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

    <p><h4><c:out value="Video: "/><a href="${project.demoURL}">${project.demoURL}</a></h4></p>

    <p><b>FAQ</b></p>
    <ol>
        <c:forEach var="question" items="${questions}">

            <li><c:out value="${question.name}"/></li>
        </c:forEach>
    </ol>
</form>

<fieldset>
    <legend width="200">You can help in raising money</legend>
    <form action="addmoney" method="POST">
        <br>

        <fieldset>
            <legend width="200">Choose on of sum to share</legend>
            <p>
                <label></label>
                <input type="radio"
                       name="amount"
                       id="sizeSmall"
                       value=1000
                       onClick="document.getElementById('addedAmount').value=this.value"
                       checked="checked"/>1000

                <label for="sizeSmall">small</label>

                <input type="radio"
                       name="amount"
                       id="sizeMed"
                       value=5000
                       onClick="document.getElementById('addedAmount').value=this.value"/>5000
                <label for="sizeMed">medium</label>

                <input type="radio"
                       name="amount"
                       id="sizeLarge"
                       value=20000
                       onClick="document.getElementById('addedAmount').value=this.value"/>20000
                <label for="sizeLarge">large</label>
            </p>
        </fieldset>
        <br>
        <p><b>Or add preferred amount</b></p><br>
        <b>Amount to add:</b> <input type="number" id="addedAmount" name="addedAmount" required
                                     data-fv-notempty-message="fill amount"><br>
        <br>
        <b>Sponsor name:</b> <input type="text" width="12" name="sponsorname"><br>
        <br>
        <b>Card number:</b> <input type="number" width="12" name="cardnumber"><br>
        <input type="hidden" value="${project.id}" name="projectId">
        <input type="hidden" value="${project.parentId}" name="categoryId">
        <input type="hidden" value="${project.currentSum}" name="currentSum">
        <input type="submit" value="Submit">
    </form>
</fieldset>

<form action="faq" method="POST">
    <br>

    <p><b>Here you can ask your question</b></p><br>
    <b>Your question:</b> <input type="text" name="addedQuestion" required data-fv-notempty-message="fill amount"><br>
    <br>
    <input type="submit" value="Submit">
    <input type="hidden" value="${project.name}" name="projectname">
    <input type="hidden" value="${project.id}" name="projectId">
    <input type="hidden" value="${project.parentId}" name="categoryId">
    <br>
</form>


</body>
</html>