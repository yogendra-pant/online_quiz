<%-- 
    Document   : register
    Created on : Sep 15, 2014, 10:00:13 PM
    Author     : Yogendra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user register page</title>
    </head>
    <body>
        <form action="users" method="post">
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
	
	</form>
    </body>
</html>
