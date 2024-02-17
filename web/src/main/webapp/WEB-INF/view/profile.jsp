<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>

<div class="container" style="max-width: 960px; margin: auto; padding: 2rem; background-color: #f8f9fa;">
    <h2 class="text-primary" style="font-size: 2rem; font-weight: bold;">Welcome, ${customer.firstname}!</h2>
    <p class="text-success" style="font-size: 1.5rem;">Your email: ${user.email}</p>
    <p class="text-info" style="font-size: 1.5rem;">Your current balance is: ${account.balance}</p>
 <sec:authorize access="hasRole('ROLE_ADMIN')">
     <p class="text-success" style="font-size: 1.5rem;"><a href="/bweb/feedback"> Feedback</a></p>
 </sec:authorize>
 <sec:authorize access="hasRole('ROLE_ADMIN')">
     <p class="text-success" style="font-size: 1.5rem;"><a href="/bweb/exchange-rates">Update exchange rate</a></p>
 </sec:authorize>
               <br>
  <!--  <a href="/bweb/deposits/${account.id}" class="btn btn-primary">Mamma mia</a>-->
</div>