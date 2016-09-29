<%@ include file="includes/header.jsp" %>
	<div class="panel-heading">
		<h3 class="panel-title"><spring:message code="signup"/></h3>
	</div>
	
	<div class="panel-body">
		<form:form modelAttribute="signUpForm" role="form">
		
			<div class="form-group">
				<form:label path="email">Email Address</form:label>
				<form:input path="email" type="email" class="form-control" placeholder="Enter email"/>
				<p class="help-block">Enter a unique email address</p>
			</div>
			
			<div class="form-group">
				<form:label path="name">Name</form:label>
				<form:input path="name" class="form-control" placeholder="Enter Name"/>
				<p class="help-block">Enter your name</p>
			</div>
			
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" class="form-control" placeholder="Password"/>
			</div>
			
			<button type="submit" class="btn btn-default">Submit</button>
		
		</form:form>
	</div>
<%@ include file="includes/footer.jsp" %>
