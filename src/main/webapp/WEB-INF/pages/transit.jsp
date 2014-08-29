<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>SANDAG ABM Reporting</title>


</head>
<body>

	<h1 class="page-header">${scenario.description} (Scenario
		ID:${scenario.id})</h1>

	<div class="row placeholders">
		<div class="col-xs-12 col-sm-6 placeholder">
            SOME SUMMARY DATA
		</div>
		<div class="col-xs-12 col-sm-6 placeholderclass table-responsive">
            MORE SUMMARY DATA
		</div>
	</div>

	<h2 class="sub-header">Daily Boardings and Alightings</h2>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="text-left">Route</th>
					<th class="text-right">Mode</th>
					<th class="text-right">Boardings</th>
					<th class="text-right">Alightings</th>
				</tr>
			</thead>
			<tbody>
			     <c:forEach items="${routes}" var="route">
			         <tr>
			             <td class="text-left">${route.routeNumber}</td>
			             <td class="text-right">${route.modeId}</td>
			             <td class="text-right"><fmt:formatNumber groupingUsed="true" maxFractionDigits="0"
                                value="${route.boardings}" /></td>
			             <td class="text-right"><fmt:formatNumber groupingUsed="true" maxFractionDigits="0"
                                value="${route.alightings}" /></td>
			     </c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>