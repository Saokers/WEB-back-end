<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>商城后台</title>
<jsp:include page="../commonCss.jsp" />
</head>
<body class="blank">
	<jsp:include page="../main/top.jsp" />
	<jsp:include page="../main/left.jsp" />
	<jsp:include page="../commonJs.jsp" />
	<div id="wrapper">
		<div class="small-header transition animated fadeIn">
			<div class="content animate-panel">
				<div class="hpanel">
					<div class="panel-body">
						<div class="row">
							<div class="hpanel">
								<div id="error_div" class="text-left"></div>
								<form id="form_userInfo" name="form_userInfo" method="POST">
									<div class="form-group col-lg-6">
										<label>选择区间</label>
										<div class="input-group date">
											<input name="searchTimeFrom" type="text" class="form-control">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
										</div>
									</div>
									<div class="form-group col-lg-6">
										<label></label>
										<div class="input-group date">
											<input name="searchTimeTo" type="text" class="form-control">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
										</div>
									</div>
									<div class="text-right m-t-xs">
										<button id="search" class="btn btn-success"
											style="margin-right: 5px; margin-top: 5px" type="button">
											<strong>查询</strong>
										</button>
										<button id="reset" class="btn btn-success"
											style="margin-right: 5px; margin-top: 5px"
											style="margin-right: 20px;" type="reset">
											<strong>重置</strong>
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>
		<div class="content animate-panel">
			<div class="row">
				<div class="col-lg-12">
					<div class="hpanel">
						<div class="panel-body">
							<div id="char" style="width: 100%; height: 600px;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<form id="forwordform"
		action='<c:url value="/admin/order/History?${_csrf.parameterName}=${_csrf.token}" />'
		method='POST'>
		<input type="hidden" name="userId" id="userId" /> <input
			type="hidden" name="roleStr" id="roleStr" /> <input type="hidden"
			name="orderNum" id="ordernum">

	</form>
	<script type="text/javascript">
		$('#leftMenuOrder').addClass('active');
		$('.date').datepicker();
		var myChart = echarts.init(document.getElementById('char'));
		var option = {
	            tooltip: {},
	            legend: {
	                data:['订单数(条)','订单金额(万元)']
	            },
	            xAxis: {
	                data: ${data.date}
	            },
	            yAxis: {},
	            series: [{
	                name: '订单数(条)',
	                type: 'bar',
	                data: ${data.count}
	            },
	            {
	            	name: '订单金额(万元)',
	                type: 'bar',
	                data: ${data.price}
	            }
	            ]
	        };
		myChart.setOption(option);
		$('#search').click(function() {
			var beginDate=$('[name=searchTimeFrom]').val();
			var endDate=$('[name=searchTimeTo]').val();
			if (beginDate==""||endDate=="") {
				return false;	
			}
			searchOrderData(beginDate,endDate);
		});
		
		function searchOrderData(beginDate,endDate){
			$.ajax({
				contentType : 'application/json;charset=utf-8',
				url : '/Shopping/api/v1/order/data',
				type : "POST",
				data : JSON.stringify({"beginDate":beginDate,"endDate":endDate}),
				dataType : "json", //ajax返回值设置为text(json格式也可用它返回，可打印出结果，也可设置成json)  
				success : function(result) {
					result=result.data;
					console.log(result);
					option.xAxis.data=result.date;
					option.series[0].data=result.count;
					option.series[1].data=result.price;
					myChart.setOption(option);
				}
			});
		}
	</script>
</body>
</html>