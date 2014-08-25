<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>SANDAG ABM Reporting</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	// Load the Visualization API and the piechart package.
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.setOnLoadCallback(drawCharts);

	// Callback that creates and populates a data table, 
	// instantiates the pie chart, passes in the data and draws it.
	function drawCharts() {

		// Create the data table.
		var facilityData = new google.visualization.DataTable();
		facilityData.addColumn('string', 'Facility');
		facilityData.addColumn('number', 'VMT');

		facilityData.addRows([ 
            [ 'Freeway', ${ifcVmtProfiles.total.freewayVmt}],
			[ 'Prime', ${ifcVmtProfiles.total.primeVmt}], 
			[ 'Major', ${ifcVmtProfiles.total.majorVmt}],
			[ 'Collector', ${ifcVmtProfiles.total.collectorVmt}],
			[ 'Local Collector', ${ifcVmtProfiles.total.localCollectorVmt}],
			[ 'Rural Collector', ${ifcVmtProfiles.total.ruralCollectorVmt}],
			[ 'Local', ${ifcVmtProfiles.total.localVmt}],
			[ 'Connector Ramp', ${ifcVmtProfiles.total.connectorRampVmt}],
			[ 'Ramp', ${ifcVmtProfiles.total.rampVmt}], 
			[ 'Access', ${ifcVmtProfiles.total.accessVmt}] ]);

		var formatter = new google.visualization.NumberFormat({
		    fractionDigits: 0,
		});
		formatter.format(facilityData, 1);
		
		// Set chart options
		var options = {
			'width' : 450,
			'height' : 350,
			'chartArea' : {	width : '85%', height : '70%'},
			'vAxis' : {
				ticks : [ { v : 0, f : '0'},
				          {	v : 10000000, f : '10'},
				          {	v : 20000000, f : '20'},
				          {	v : 30000000, f : '30'},
				          { v : 40000000, f : '40'},
				          { v : 50000000, f : '50'},
				          { v : 60000000, f : '60'}
				         ],
				minorGridlines : { count : 4},
				title: 'VMT (millions)',
				titleTextStyle: {italic: false}
			},
			'hAxis': {
				slantedTextAngle: 90,
				maxTextLines: 3
			},
			'legend' : {
				position : "none"
			}
		};

		// Instantiate and draw our chart, passing in some options.
		var facilityChart = new google.visualization.ColumnChart(document
				.getElementById('facility_chart_div'));

		facilityChart.draw(facilityData, options);
	}
</script>

</head>
<body>

	<h1 class="page-header">${scenario.description}(Scenario
		ID:${scenario.id})</h1>

	<div class="row placeholders">
		<div class="col-xs-12 col-sm-6 placeholder">
			<div id="facility_chart_div"></div>
		</div>
		<div class="col-xs-12 col-sm-6 placeholderclass table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<td><b>Facility Type</b></td>
						<td><b>VMT</b></td>
						<td><b>VHT</b></td>
						<td><b>Speed</b></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="text-left">Freeway</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.freewayVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.freewayVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.freewaySpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left">Prime</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.primeVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.primeVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.primeSpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left">Major</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.majorVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.majorVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.majorSpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left">Collector</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.collectorVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.collectorVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.collectorSpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left">Local Collector</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.localCollectorVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.localCollectorVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.localCollectorSpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left">Rural Collector</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.ruralCollectorVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.ruralCollectorVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.ruralCollectorSpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left">Local</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.localVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.localVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.localSpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left">Connector Ramp</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.connectorRampVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.connectorRampVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.connectorRampSpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left">Ramp</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.rampVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.rampVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.rampSpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left">Access</td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.accessVmt}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.total.accessVht}" /></td>
						<td class="text-right"><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.total.accessSpeed}" /></td>
					</tr>
					<tr>
						<td class="text-left"><b>Total</b></td>
						<td class="text-right"><b><fmt:formatNumber type="number"
									groupingUsed="true" maxFractionDigits="0"
									value="${ifcVmtProfiles.total.totalVmt}" /></b></td>
						<td class="text-right"><b><fmt:formatNumber type="number"
									groupingUsed="true" maxFractionDigits="0"
									value="${ifcVmtProfiles.total.totalVht}" /></b></td>
						<td class="text-right"><b><fmt:formatNumber type="number"
									groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
									value="${ifcVmtProfiles.total.totalSpeed}" /></b></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<h2 class="sub-header">Daily VMT Summary</h2>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th class="text-left">Functional Class</th>
					<th class="text-right">VMT</th>
					<th class="text-right">VHT</th>
					<th class="text-right">Speed</th>
				</tr>
			</thead>
		</table>
		<table class="table table-striped">
			<thead>
				<tr>
					<td class="text-left"><b>Single Occupancy Vehicles</b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.driveAlone.totalVmt}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.driveAlone.totalVht}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.driveAlone.totalSpeed}" /></b></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="text-left">Freeway</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.freewayVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.freewayVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.freewaySpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Prime</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.primeVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.primeVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.primeSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Major</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.majorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.majorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.majorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.collectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.collectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.collectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.localCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.localCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.localCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Rural Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.ruralCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.ruralCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.ruralCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.localVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.localVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.localSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Connector Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.connectorRampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.connectorRampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.connectorRampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.rampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.rampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.rampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Access</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.accessVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.driveAlone.accessVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.driveAlone.accessSpeed}" /></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-striped">
			<thead>
				<tr>
					<td class="text-left"><b>High Occupancy Vehicles</b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.carpool.totalVmt}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.carpool.totalVht}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.carpool.totalSpeed}" /></b></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="text-left">Freeway</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.freewayVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.freewayVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.freewaySpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Prime</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.primeVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.primeVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.primeSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Major</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.majorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.majorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.majorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.collectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.collectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.collectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.localCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.localCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.localCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Rural Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.ruralCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.ruralCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.ruralCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.localVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.localVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.localSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Connector Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.connectorRampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.connectorRampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.connectorRampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.rampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.rampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.rampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Access</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.accessVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.carpool.accessVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.carpool.accessSpeed}" /></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-striped">
			<thead>
				<tr>
					<td class="text-left"><b>Light Heavy Duty Trucks</b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.lhdt.totalVmt}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.lhdt.totalVht}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.lhdt.totalSpeed}" /></b></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="text-left">Freeway</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.freewayVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.freewayVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.freewaySpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Prime</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.primeVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.primeVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.primeSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Major</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.majorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.majorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.majorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.collectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.collectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.collectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.localCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.localCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.localCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Rural Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.ruralCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.ruralCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.ruralCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.localVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.localVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.localSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Connector Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.connectorRampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.connectorRampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.connectorRampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.rampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.rampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.rampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Access</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.accessVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.lhdt.accessVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.lhdt.accessSpeed}" /></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-striped">
			<thead>
				<tr>
					<td class="text-left"><b>Medium Heavy Duty Trucks</b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.mhdt.totalVmt}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.mhdt.totalVht}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.mhdt.totalSpeed}" /></b></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="text-left">Freeway</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.freewayVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.freewayVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.freewaySpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Prime</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.primeVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.primeVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.primeSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Major</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.majorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.majorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.majorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.collectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.collectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.collectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.localCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.localCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.localCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Rural Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.ruralCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.ruralCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.ruralCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.localVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.localVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.localSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Connector Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.connectorRampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.connectorRampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.connectorRampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.rampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.rampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.rampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Access</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.accessVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.mhdt.accessVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.mhdt.accessSpeed}" /></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-striped">
			<thead>
				<tr>
					<td class="text-left"><b>Heavy Heavy Duty Trucks</b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.hhdt.totalVmt}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="0"
								value="${ifcVmtProfiles.hhdt.totalVht}" /></b></td>
					<td class="text-right"><b><fmt:formatNumber type="number"
								groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
								value="${ifcVmtProfiles.hhdt.totalSpeed}" /></b></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="text-left">Freeway</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.freewayVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.freewayVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.freewaySpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Prime</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.primeVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.primeVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.primeSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Major</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.majorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.majorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.majorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.collectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.collectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.collectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.localCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.localCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.localCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Rural Collector</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.ruralCollectorVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.ruralCollectorVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.ruralCollectorSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Local</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.localVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.localVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.localSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Connector Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.connectorRampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.connectorRampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.connectorRampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Ramp</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.rampVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.rampVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.rampSpeed}" /></td>
				</tr>
				<tr>
					<td class="text-left">Access</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.accessVmt}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0"
							value="${ifcVmtProfiles.hhdt.accessVht}" /></td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${ifcVmtProfiles.hhdt.accessSpeed}" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>