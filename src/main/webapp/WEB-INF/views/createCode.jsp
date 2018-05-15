<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="header.jsp">
	<jsp:param name="titlePage" value="Login page" />
</jsp:include>
<div class="container">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<h2>
			Welcome ${pageContext.request.userPrincipal.name} |
			<button class="btn btn-primary"
				onclick="document.forms['logoutForm'].submit()">Logout</button>
			<a href="${contextPath}/welcome" class="btn btn-primary ">Back to
				preview codes</a>
		</h2>


		<form:form method="POST" modelAttribute="codeForm" class="form-signin">
			<h2 class="form-signin-heading">Create your code</h2>
			<spring:bind path="title">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input path="title" class="form-control" placeholder="Title"
						autofocus="true"></form:input>
					<form:errors path="title"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="code">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:textarea path="code" class="form-control" placeholder="Code"
						autofocus="true"></form:textarea>
					<form:errors path="code"></form:errors>
				</div>
			</spring:bind>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Save
				code</button>
		</form:form>

	</c:if>
</div>
<!-- /container -->
<jsp:include page="footer.jsp" />