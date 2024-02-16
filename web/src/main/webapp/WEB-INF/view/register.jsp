<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<h2>Registration Form</h2>

<style> div{
			width: 200px;
			}
				</style>
<form action="/bweb/register" method="post">
		<div class="input-group input-group-lg" style=background-color:beige>
		  <span class="input-group-text" id="inputGroup-sizing-lg">Username:</span><br>
		  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
		</div>
		<div class="input-group input-group-lg" style=background-color:lavender>
		  <span class="input-group-text" id="inputGroup-sizing-lg">Password:</span><br>
		  <input type="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
		</div>
		<div class="input-group input-group-lg" style=background-color:beige>
		  <span class="input-group-text" id="inputGroup-sizing-lg">E-mail:</span><br>
		  <input type="email" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
		</div>
		<div class="input-group input-group-lg" style=background-color:lavender>
		  <span class="input-group-text" id="inputGroup-sizing-lg">Name:</span><br>
		  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
		</div>
		<div class="input-group input-group-lg" style=background-color:beige>
		  <span class="input-group-text" id="inputGroup-sizing-lg">Surname:</span><br>
		  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
		</div>
		<br>
		<button type="submit" class="btn btn-secondary">Registry</button>
		<a href="/login" > Login </a>
</form>


