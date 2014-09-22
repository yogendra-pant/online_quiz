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
        <jsp:include page="header.jsp" />
    </head>
    <body>

        <h1>Contest Details</h1> 
        <table class="myTable">
            <tr>
                <td>Contest Name</td>
                <td>Organizer Email</td>
                <td>Contest state</td>
                <td>Start time</td>
                <td>Duration</td>
                <td>Action</td>

            </tr>


            <tr>
                <td>${contest.name}</td>
                <td>${contest.organizerEmail}</td>
                <td>${contest.contestState}</td>
                <td>${contest.startTime}</td>
                <td><c:out value="${contest.duration.getHours()}:${contest.duration.getHours()}"/></td>
                <td>
                    <c:if test="${empty joined}">
                        <form action="join?contestId=${contest.id}" method="post">
                            <button type="submit">Join</button>
                        </form>
                    </c:if>
                    <c:if test="${not empty joined}">
                        <form action="enter?contestId=${contest.id}" method="post">
                            <button type="submit">Enter</button>
                        </form>
                    </c:if>



                </td>
            </tr>

        </table>

        <h1>Contestants</h1>  
        <table class="myTable">
            <tr>
                <td>Username</td>


            </tr>
            <c:forEach var="contestant" items="${contest.contestants}">

                <tr>
                    <td>${contestant.user.userName}</td>




                </tr>
            </c:forEach>

        </table>
    </body>
</html>

