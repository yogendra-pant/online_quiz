<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<form:form  action="submitQuiz" method="post">
        <table>            
            <c:forEach var="quest" items="${questions}">
                <tr>
                    <td>Question. ${quest.question}</td>
                    <td><input type="text" name="userAnswer" size="100" /></td>
                </tr>
            </c:forEach>
        </table>
    <input type="submit"/>
</form:form>
    </body>
</html>
