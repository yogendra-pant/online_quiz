<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
         <jsp:include page="header.jsp" />
        <form:form commandName="quiz" action="addQuestion" method="post">
            <h1>Enter Quiz Info</h1>
            <table >

                <tr>
                    <td>Quiz Name:</td>
                    <td><form:input type="text" path="displayName" name="displayName" /> 
                    </td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><form:input type="text" path="description" name="description" />                    
                    </td>
                </tr>


                <tr>
            </table>
            <h1>Add Question!</h1>
            <table>
                <td>Question:</td>
                <td><form:input type="text" path="question" name="question" /> 
                    <%--<form:errors path="question" cssClass="error" />--%>
                </td>
            </tr>
            <tr>
                <td>Solution:</td>
                <td><form:input type="text" path="solution" name="solution" />
                    <%--<form:errors path="solution" cssClass="error" />--%>
                </td>
            </tr>
        </table>
        <input type="submit" value="Add question"></>
       
    </form:form>
        
         <form action="save" method="post">
            <button type="submit">Save Quiz</button>
        </form>
    <h1>Questions with Answers</h1>
    <table>
        <tr>
            <td>Question</td>
            <td>Answer</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="ques" items="${questions}">
            <tr>

                <td>${ques.question}</td>
                <td>${ques.solution}</td>
                <td>update</td>
                <td>Delete</td>
            </tr>
        </c:forEach> 
    </table>
</body>
</html>
