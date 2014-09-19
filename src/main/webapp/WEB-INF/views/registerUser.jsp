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
        <form:form commandName="User" action="registerUser" method="post">
              <form:errors path="*" element="div"/>
	<table>
		<tr>
			<td>User Name:</td>
			<td><input type="text" name="userName" /> </td>
		</tr>
		<tr>
			<td>Email Id:</td>
			<td><input type="text" name="emailId" /> </td>
		</tr>
		<tr>
			<td>Phone Number.:</td>
			<td><input type="text" name="phoneNumber" /> </td>
		</tr>
		<tr>
			<td>Password:</td>
                        <td><input type="password" name="password" /> </td>
		</tr>
                <tr>
			<td> Confirm Password:</td>
                        <td><input type="password" name="confirmPassword" /> </td>
		</tr>
	</table>
	<input type="submit"/>
	
        </form:form>
    </body>
</html>
