<%-- 
    Document   : register
    Created on : Sep 15, 2014, 10:00:13 PM
    Author     : Yogendra
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user register page</title>
    </head>
    <body>
        <form:form commandName="user" action="registerUser" method="post">
              <%--<form:errors path="*" element="div"/>--%>
	<table>
		<tr>
			<td>User Name:</td>
			<td><form:input type="text" path="userName" name="userName" /> 
                        <form:errors path="userName" cssClass="error" />
                        </td>
		</tr>
		<tr>
			<td>Email Id:</td>
			<td><form:input type="text" path="emailId" name="emailId" />
                        <form:errors path="emailId" cssClass="error" />
                        </td>
		</tr>
		<tr>
			<td>Phone Number.:</td>
			<td><form:input type="text" path="phoneNumber" name="phoneNumber" /> 
                        <form:errors path="phoneNumber" cssClass="error" />
                        </td>
		</tr>
		<tr>
			<td>Password:</td>
                        <td><form:input type="password" path="password" name="password" />
                        <form:errors path="password" cssClass="error" />
                        </td>
		</tr>
                <tr>
			<td> Confirm Password:</td>
                        <td><form:input type="password" path="confirmPassword" name="confirmPassword" />
                        <form:errors path="confirmPassword" cssClass="error" />
                        </td>
		</tr>
	</table>
	<input type="submit"/>
	
        </form:form>
    </body>
</html>
