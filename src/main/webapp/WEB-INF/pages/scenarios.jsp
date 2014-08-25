<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Year</th>
						<th>Description</th>
						<th>Path</th>
						<th>Load Date</th>
						<th>Complete</th>
						<th>User</th>
					</tr>
				</thead>
				<tbody>
				    <c:forEach items="${scenarios}" var="scenario" varStatus="status">
				        <tr data-id="${scenario.id}">
				            <td><a href="<c:url value="/scenario/${scenario.id}" />">${scenario.id}</a></td>
				            <td>${scenario.year}</td>
				            <td>${scenario.description}</td>
				            <td>${scenario.path}</td>
				            <td>${scenario.loaded}</td>
				            <td>${scenario.complete}</td>
				            <td>${scenario.user}</td>
				        </tr>
				    </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>