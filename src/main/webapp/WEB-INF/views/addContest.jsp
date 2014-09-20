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
    </head>
    <body>
        <form:form commandName="contextProxy" action="addQuiz" method="post">
            <form:errors path="*" element="div"/>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><form:input type="text" path="name" name="name" /> </td>
                </tr>
                <tr>
                    <td>Game Name:</td>
                    <td><form:input type="text" path="gameName" name="gameName" /> </td>
                </tr>

                <tr>
                    <td>Start Time:</td>
                    <td><form:input type="text" path="startTime" name="startTime" /> </td>
                </tr>
                
                <tr>
                    <td>Organizer Name:</td>
                    <td><form:input type="text" path="organigerName" name="organigerName" /> </td>
                </tr>
                <tr>
                    <td>Organizer Email:</td>
                    <td><form:input type="text" path="organigerEmail" name="organigerEmail" /> </td>
                </tr>
            </table>
            <input type="submit"/>

        </form:form>
    </body>
</html>
