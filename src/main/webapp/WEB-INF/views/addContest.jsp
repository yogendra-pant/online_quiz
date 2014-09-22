<%-- 
    Document   : addContest
    Created on : Sep 19, 2014, 10:43:10 PM
    Author     : Yogendra
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="header.jsp" />
    </head>
    <body>
        <form:form commandName="contestInfo" action="addContest" method="post">
            <%--<form:errors path="*" element="div"/>--%>
            <table>

                <td>Contest Name:</td>
                <td><form:input type="text" path="contestName" name="contestName" /> 
                    <form:errors path="contestName" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Contest Date:</td>
                <td><form:input type="text" path="contestDate" name="contestDate" />
                    <form:errors path="contestDate" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Contest Duration:</td>
                <td><form:input type="text" path="contestDuration" name="contestDuration" />
                    <form:errors path="contestDuration" cssClass="error" />
                </td>
            </tr>

            <tr>
                <td>Organizer Name:</td>
                <td><form:input type="text" path="organizerName" name="organigerName" />
                    <form:errors path="organizerName" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Organizer Email:</td>
                <td><form:input type="text" path="organizerEmail" name="organigerEmail" />
                    <form:errors path="organizerEmail" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Select Quiz:</td>
                <td>
                    <form:select path="quizName" items="${quizList}" />
                </td>
            </tr>
        </table>
        <input type="submit"/>

    </form:form>
</body>
</html>
