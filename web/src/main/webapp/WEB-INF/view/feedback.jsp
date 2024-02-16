<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <head>
        <title>Feedback</title>
    </head>
    <body>
     <div class="container mt-5" class="alert alert-info mt-2">
        <h2>Обратная связь</h2>
        <c:forEach var="message" items="${requestScope.messages}">
            <p>${message.title}</p>
            <p>${message.description}</p>
            <a href="/feedback/${message.id}">Читать полностью</a>
        </c:forEach>
     </div>
    </body>
</html>