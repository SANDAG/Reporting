<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>SANDAG ABM Reporting</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1.0', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawCharts);

    // Callback that creates and populates a data table, 
    // instantiates the pie chart, passes in the data and draws it.
    function drawCharts() {

        // Create the data table.
        var modeData = new google.visualization.DataTable();
        modeData.addColumn('string', 'Mode');
        modeData.addColumn('number', 'Trips');
        modeData.addRows([
            ['DriveAlone', ${modeshare.driveAloneTrips}],
            ['Carpool', ${modeshare.carpoolTrips}],
            ['Transit', ${modeshare.transitTrips}], 
            ['Walk', ${modeshare.walkTrips}],
            ['Bike', ${modeshare.bikeTrips}],
            ['Other', ${modeshare.otherTrips}]
        ]);
        
        var boardingsData = new google.visualization.DataTable();
        boardingsData.addColumn('string', 'Mode');
        boardingsData.addColumn('number', 'Boardings');
        boardingsData.addRows([
            ['Commuter Rail', ${boardingsByMode.commuterRail}],
            ['Light Rail', ${boardingsByMode.lightRail}],
            ['Regional BRT', ${boardingsByMode.regionalBrt}], 
            ['Express Bus', ${boardingsByMode.expressBus}],
            ['Local Bus', ${boardingsByMode.localBus}],
        ]);
        
        var formatter = new google.visualization.NumberFormat({
            fractionDigits: 0,
        });
        formatter.format(modeData, 1);
        formatter.format(boardingsData, 1);

        // Set chart options
        var options = {
               'width':250,
               'height':250,
               'pieHole': 0.4,
               'legend': {position: 'none'},
               'chartArea': {width:'100%',height:'100%'},
               'pieSliceText': 'label',
               'pieSliceTextStyle': {color: 'white', fontSize: 10},
               'colors': ['#5DA5DA','#FAA43A', '#F17CB0', '#B2912F','#B276B2','#DECF3F']
        };

        // Instantiate and draw our chart, passing in some options.
        var modeChart = new google.visualization.PieChart(document.getElementById('mode_chart_div'));
        var boardingsChart = new google.visualization.PieChart(document.getElementById('boardings_chart_div'));
        
        modeChart.draw(modeData, options);
        boardingsChart.draw(boardingsData, options);
    }
</script>

</head>
<body>

	<h1 class="page-header">${scenario.description} (Scenario
		ID:${scenario.id})</h1>

	<div class="row placeholders">
		<div class="col-xs-6 col-sm-3 placeholder">
			<div id="mode_chart_div"></div>
		</div>
		<div class="col-xs-6 col-sm-3 placeholderclass table-responsive">
			<h4>Mode Share</h4>
			<span class="text-muted">Resident Travel</span>
			<table class="table table-striped">
				<thead>
					<tr>
					    <th></th>
						<th>Mode</th>
						<th>Share</th>
					</tr>
					<tr>
					    <td><div class="color-box" style="background-color:#5DA5DA;" ></div></td>
						<td class="text-left">Drive Alone</td>
						<td class="text-right"><fmt:formatNumber type="percent"
								groupingUsed="true" maxFractionDigits="2" minFractionDigits="2"
								value="${modeshare.driveAloneModeShare}" /></td>
					</tr>
					<tr>
					    <td><div class="color-box" style="background-color:#FAA43A;" ></div></td>
						<td class="text-left">Carpool</td>
						<td class="text-right"><fmt:formatNumber type="percent"
								groupingUsed="true" maxFractionDigits="2" minFractionDigits="2"
								value="${modeshare.carpoolModeShare}" /></td>
					</tr>
					<tr>
					    <td><div class="color-box" style="background-color:#F17CB0;" ></div></td>
						<td class="text-left">Transit</td>
						<td class="text-right"><fmt:formatNumber type="percent"
								groupingUsed="true" maxFractionDigits="2" minFractionDigits="2"
								value="${modeshare.transitModeShare}" /></td>
					</tr>
					<tr>
					    <td><div class="color-box" style="background-color:#B2912F;" ></div></td>
						<td class="text-left">Walk</td>
						<td class="text-right"><fmt:formatNumber type="percent"
								groupingUsed="true" maxFractionDigits="2" minFractionDigits="2"
								value="${modeshare.walkModeShare}" /></td>
					</tr>
					<tr>
					    <td><div class="color-box" style="background-color:#B276B2;" ></div></td>
						<td class="text-left">Bike</td>
						<td class="text-right"><fmt:formatNumber type="percent"
								groupingUsed="true" maxFractionDigits="2" minFractionDigits="2"
								value="${modeshare.bikeModeShare}" /></td>
					</tr>
					<tr>
					    <td><div class="color-box" style="background-color:#DECF3F;" ></div></td>
						<td class="text-left">Other</td>
						<td class="text-right"><fmt:formatNumber type="percent"
								groupingUsed="true" maxFractionDigits="2" minFractionDigits="2"
								value="${modeshare.otherModeShare}" /></td>
					</tr>
				</thead>

			</table>
		</div>
		<div class="col-xs-6 col-sm-3 placeholder">
			<div id="boardings_chart_div"></div>
		</div>
        <div class="col-xs-6 col-sm-3 placeholderclass table-responsive">
            <h4>Boardings</h4>
            <span class="text-muted">By Main Mode</span>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th></th>
                        <th>Mode</th>
                        <th>Boardings</th>
                    </tr>
                    <tr>
                        <td><div class="color-box" style="background-color:#5DA5DA;" ></div></td>
                        <td class="text-left">Commuter Rail</td>
                        <td class="text-right"><fmt:formatNumber type="number"
                                groupingUsed="true" maxFractionDigits="0"
                                value="${boardingsByMode.commuterRail}" /></td>
                    </tr>
                    <tr>
                        <td><div class="color-box" style="background-color:#FAA43A;" ></div></td>
                        <td class="text-left">Light Rail</td>
                        <td class="text-right"><fmt:formatNumber type="number"
                                groupingUsed="true" maxFractionDigits="0"
                                value="${boardingsByMode.lightRail}" /></td>
                    </tr>
                    <tr>
                        <td><div class="color-box" style="background-color:#F17CB0;" ></div></td>
                        <td class="text-left">Regional BRT</td>
                        <td class="text-right"><fmt:formatNumber type="number"
                                groupingUsed="true" maxFractionDigits="0"
                                value="${boardingsByMode.regionalBrt}" /></td>
                    </tr>
                    <tr>
                        <td><div class="color-box" style="background-color:#B2912F;" ></div></td>
                        <td class="text-left">Express Bus</td>
                        <td class="text-right"><fmt:formatNumber type="number"
                                groupingUsed="true" maxFractionDigits="0"
                                value="${boardingsByMode.expressBus}" /></td>
                    </tr>
                    <tr>
                        <td><div class="color-box" style="background-color:#B276B2;" ></div></td>
                        <td class="text-left">Local Bus</td>
                        <td class="text-right"><fmt:formatNumber type="number"
                                groupingUsed="true" maxFractionDigits="0"
                                value="${boardingsByMode.localBus}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="text-left"><b>Total Boardings</b></td>
                        <td class="text-right"><b><fmt:formatNumber type="number"
                                groupingUsed="true" maxFractionDigits="0"
                                value="${boardings}" /></b></td>
                    </tr>
                </thead>

            </table>
        </div>
	</div>

	<h2 class="sub-header">Key Performance Measures</h2>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Metric</th>
					<th>Value</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Vehicle Miles Traveled</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="2" minFractionDigits="2"
							value="${vmt}" /> miles</td>
				</tr>
				<tr>
					<td>Vehicle Hours Traveled</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="2" minFractionDigits="2"
							value="${vht}" /> hours</td>
				</tr>
				<tr>
					<td>Average Network Speed</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="1" minFractionDigits="1"
							value="${networkSpeed}" /> mph</td>
				</tr>
				<tr>
					<td>Total Transit Boardings</td>
					<td class="text-right"><fmt:formatNumber type="number"
							groupingUsed="true" maxFractionDigits="0" value="${boardings}" />
						passengers</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>