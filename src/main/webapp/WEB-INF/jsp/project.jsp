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
    <p><b>Sum to raise</b><br><c:out value=" ${project.sumToRaise}"/></p>

    <p><b>Current sum</b><br><c:out value=" ${project.currentSum}"/></p>

    <p><b>End date:</b><br><c:out value=" ${project.endDate}"/></p>

    <p><b>Project history:</b><br><c:out value=" ${project.projectHistory}"/></p>

    <p><h4><c:out value="Video: "/><br><a href="${project.demoURL}">${project.demoURL}</a></h4></p>

    <p><b>FAQ</b></p>
    <ol>
        <c:forEach var="question" items="${questions}">

            <li><c:out value="${question.name}"/></li>
        </c:forEach>
    </ol>
</form>
<br>

<form action="faq" method="POST">
    <fieldset>
        <legend width="200">Here you can ask yor questions</legend>
        <b>Your question:</b> <input type="text" name="addedQuestion" required
                                     data-fv-notempty-message="fill amount"><br>
        <input type="submit" value="Submit">
        <input type="hidden" value="${project.name}" name="projectname">
        <br>
    </fieldset>
</form>
<br>
<br>
<fieldset>

    <legend width="200">You can help in raising money</legend>
    <form action="addmoney" method="POST">

        <fieldset>
            <p><b>Choose on of sum to share</b></p>
            <p>
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
        <fieldset>
            <p><b>Or add preferred amount</b></p>
            <b>Amount to add:</b> <input type="number" id="addedAmount" name="addedAmount" required
                                         data-fv-notempty-message="fill amount">
            <br>
            <br>
            <b>Sponsor name:</b> <input type="text" width="12" name="sponsorname">
            <br>
            <br>
            <b>Card number:</b> <input type="number" width="12" name="cardnumber">
            <br>
            <input type="submit" value="Submit">
        </fieldset>
    </form>
</fieldset>


</body>
</html>