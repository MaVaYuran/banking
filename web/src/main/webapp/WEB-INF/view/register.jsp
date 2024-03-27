<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<h2>Registration Form</h2>
<style> {width: 200}
</style>

<form action="/bweb/register" method="post">
     <div class="form-group">
       <label for="username">Username:</label>
       <input type="text" class="form-control" id="username" name="username">
     </div>
     <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" id="password" name="password">
     </div>
     <div class="form-group">
         <label for="firstname">First Name:</label>
         <input type="text" class="form-control" id="firstname" name="firstname">
     </div>
     <div class="form-group">
         <label for="lastname">Last Name:</label>
         <input type="text" class="form-control" id="lastname" name="lastname">
     </div>
     <div class="form-group">
         <label for="email">Email:</label>
         <input type="email" class="form-control" id="email" name="email">
     </div>

        <button type="submit" class="btn btn-primary">Submit</button>
</form>
<%@include file="footer.jsp"%>

