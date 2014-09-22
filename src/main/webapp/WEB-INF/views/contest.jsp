<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<style type="text/css">
    table.myTable { border-collapse:collapse; }
    table.myTable td, table.myTable th { border:1px solid black;padding:5px; }
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="main">Home</a>
        <a href="j_spring_security_logout">logout</a>

        <table class="myTable">
            <tr>
                <td>Contest Name:</td>
                <td>Organizer Email:</td>
                <td>Action:</td>
            </tr>


            <tr>
                <td>${contest.name}</td>
                <td>${contest.organizerEmail}</td>
                <td>
                    <form action="join?contestId=${contest.id}" method="post">
                        <button type="submit">Join</button>
                    </form>

                    <form action="enter?contestId=${contest.id}" method="post">
                        <button type="submit">Enter</button>
                    </form>
                </td>
            </tr>

        </table>
    </body>
</html>
