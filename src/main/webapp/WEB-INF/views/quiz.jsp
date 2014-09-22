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
        <c:forEach var="question" items="${questions}">
                
                <tr>
                    <td>${question.questions}</td>
                
                    
                    
            </tr>
        </c:forEach>
    </body>
</html>
