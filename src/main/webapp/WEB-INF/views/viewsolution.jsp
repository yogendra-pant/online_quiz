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
        <form:form  commandName="quizSolution" action="submitGrade?contestantId=${contestantId}" method="post">
            <table>            
                <c:forEach var="quest" items="${quizSolution.questionSolutions}" varStatus="vs">
                    <tr>
                        <td>[${quiz.questions[vs.index].point}] Question.${vs.index+1} ${quiz.questions[vs.index].question} </td>
                    </tr>
                    <tr>
                    <td><form:input path="questionSolutions[${vs.index}].point"
                                    />
                    <%--<form:errors path="question" cssClass="error" />--%>
                </td>
                    </tr>
                    <tr>                        
                        <td>User Solution: ${quest.solution}</td>
                    </tr>
                    
                    
                    <tr>                        
                        <td>Correct Solution: ${quiz.questions[vs.index].solution}</td>
                    </tr>
                    
                    
                </c:forEach>
            </table>
            
            <input type="submit"/>
        </form:form>
    </body>
</html>
