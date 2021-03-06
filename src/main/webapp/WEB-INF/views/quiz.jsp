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
        <title>Quiz Page</title>
    </head>
    <body>
        <form:form  commandName="quizSolution" action="submitQuiz?contestId=${contestId}" method="post">
            <table>            
                <c:forEach var="quest" items="${quizSolution.questionSolutions}" varStatus="vs">
                    <tr>
                        <td>[${quest.point}] Question.${vs.index+1} ${quest.question}</td>
                    </tr>
                    <tr>                        
                        <td><form:input path="questionSolutions[${vs.index}].solution"
                                    /></td>
                    </tr>
                </c:forEach>
            </table>
            
            <input type="submit"/>
        </form:form>
    </body>
</html>
