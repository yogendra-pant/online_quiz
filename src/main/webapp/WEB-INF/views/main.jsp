<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Quiz Contest Hosting</h1>
        <a href="registerUser">Register User</a>
        <a href="addContest">Add Quiz Contest</a>
        <a href="addQuestion">Add Question</a>
        
        <table>
            <c:forEach var="contest" items="${contests}">
                <tr>
                    <td>${contest.name}</td>
                    <td>${contest.organizerEmail}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
