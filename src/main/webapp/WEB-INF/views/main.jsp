<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<style type="text/css">
    table.myTable { border-collapse:collapse;  }
    table.myTable td, table.myTable th { border:1px solid black;padding:5px; margin: 15px; }
</style>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="header.jsp" />
        <a href="registerUser">Register User</a>
        <a href="addContest">Add Quiz Contest</a>
        <a href="addQuiz">Add Quiz</a>
    </head>
    <body>
        
        <table class="myTable">
            <tr>
                <td>Contest Name</td>
                <td>Organizer Email</td>
                <td>Contest state</td>
                <td>Start time</td>
                <td>Duration</td>
                <td>View Details</td>
            </tr>
            <c:forEach var="contest" items="${contests}">

                <tr>
                    <td>${contest.name}</td>
                    <td>${contest.organizerEmail}</td>
                    <td>${contest.contestState}</td>
                <td>${contest.startTime}</td>
                <td><c:out value="${contest.duration.getHours()}:${contest.duration.getHours()}"/></td>
                    <td>
                        <form action="detailsClick?contestId=${contest.id}" method="post">
                            <button type="submit">Details</button>
                        </form>
                    </td>


                </tr>
            </c:forEach>
        </table>
    </body>
</html>
