<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<html>
    <head>
        <title>${title}</title>
    </head>
    <body>
       <p> Hello, ${title}!</p>
       <br>
       <a href="/bweb/register">Register</a>

    </body>
</html>