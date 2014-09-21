<%-- 
    Document   : addQuestion
    Created on : Sep 20, 2014, 3:24:00 PM
    Author     : Yogendra
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Add Question!</h1>
         <form:form commandName="question" action="addQuestion" method="post">
            <table>
                    <td>Question:</td>
                    <td><form:input type="text" path="question" name="question" /> 
                    <form:errors path="question" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Solution:</td>
                    <td><form:input type="text" path="solution" name="solution" />
                    <form:errors path="solution" cssClass="error" />
                    </td>
                </tr>
            </table>
            <input type="submit"/>

        </form:form>
    </body>
</html>
