<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <head>
        <title>Добавить сообщение</title>
    </head>
    <body>
     <div class="container mt-5" >
        <h2>Добавить сообщение</h2>
        <form action="/feedback/add" method="post">
            <input type="text" name="title" placeholder="Тема обращения" class="form-control">
            <input type="text" name="description" class="form-control">
            <textarea name="full_message" placeholder="Введите сообщение" class="form-control"/>
            <button type="submit" class="btn btn-success">Отправить</button>
        </form>

     </div>
    </body>
</html>