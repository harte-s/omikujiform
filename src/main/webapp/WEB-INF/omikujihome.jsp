<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Home</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->

    <form action="/omikuji/process" method="post" class="col-6 mx-auto">
        <h2 class="text-center">Send an Omikuji</h2>
        <c:out value="${error}"></c:out>
        <div class="form-group">
            <label for="numYears">Pick any number from 5 to 25:</label>
            <input type="number" name="numYears"  class="form-control">
        </div>
        <div class="form-group">
            <label for="city">Enter the name of any city:</label>
            <input type="text" name="city"  class="form-control">
        </div>
        <div class="form-group">
            <label for="person">Enter the name of any living person:</label>
            <input type="text" name="person"  class="form-control">
        </div>
        <div class="form-group">
            <label for="activity">Enter professional endeavor or hobby:</label>
            <input type="text" name="activity"  class="form-control">
        </div>
        <div class="form-group">
            <label for="livingthing">Enter any type of living thing:</label>
            <input type="text" name="livingthing"  class="form-control">
        </div>
        <div class="form-group">
            <label for="compliment">Say something nice to someone:</label>
            <textarea name="compliment" cols="30" rows="10" class="form-control"></textarea>
        </div>
        <input type="submit" value="Send" class="btn btn-success">
    </form>
    </div> <!-- End of Container -->
</body>
</html>
