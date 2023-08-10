 <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<form:form action="/login" method="post" modelAttribute="login">

		<h4>Login to continue</h4>
		<div>
			<label>Email</label>
			<form:input path="email" class="form-control" type="email"
				name="email" value="${email}" />
			<form:errors path="email" cssClass="text-danger" />
		</div>
		<div>
			<label>Password</label>
			<form:input path="pass_words" class="form-control" type="password"
				name="pass_words" value="${pass}" />
			<form:errors path="pass_words" cssClass="text-danger" />
		</div>
		<div>
			<%-- <form:checkbox path="rememberme" name="rememberme" label="Remember me"/> --%>
			<input type="checkbox" name="remember" value="true"> Remember
			me
		</div>
		<button class="btn btn-primary w-100 mt-4" type="submit">Login</button>
	</form:form>
</body>
</html>