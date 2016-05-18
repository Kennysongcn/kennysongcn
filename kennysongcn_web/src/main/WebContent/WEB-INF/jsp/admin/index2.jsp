<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.inc.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>资源管理系统</title>
<%@ include file="/common.jsp"%>
<%--  --%><script type="text/javascript" src="${contextPath}/static/js-custom/admin/app/Application.js"></script>
<%--<script type="text/javascript" src="${contextPath}/static/js-custom/user/userInfo.js"></script> --%> 
<link href="${contextPath}/static/css/admin/index.css" rel="stylesheet">
</head>
<body>
<!-- <nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="admin/index">KennySong</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="admin/index/#">仪表板</a></li>
					<li><a href="admin/index/#">设置</a></li>
					<li><a href="admin/loginOut">退出</a></li>
					<li><a href="admin/index/#">帮助</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav> 
<div style="clear: both;"></div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-sm-3 col-md-2 col-ld-2 sidebar" id="accordion">
			<!-- ajax 加载左侧导航 -->

			<!-- </div>
			<div
				class="col-sm-8 col-sm-offset-3 col-md-9 col-md-offset-2 col-lg-9 main">
				<h1 class="page-header">KennySong</h1>

				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
							<div >
								<canvas id="canvas" height="450" width="450"></canvas>
							</div>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
							<div id="canvas-holder">
								<canvas id="chart-area" width="300" height="300"> </canvas>
							</div>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img data-src="holder.js/200x200/auto/sky" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img data-src="holder.js/200x200/auto/vine" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
				</div>-->
		<!-- 		<div class="row-fluid">
                    <div class="panel-body" style="padding-bottom:0px;">
					  <div class="panel panel-default">
					   <div class="panel-heading">查询条件</div>
					   <div class="panel-body">
					    <form id="formSearch" class="form-horizontal">
					     <div class="form-group" style="margin-top:15px">
					      <label class="control-label col-sm-1" for="txt_search_username">用户名称</label>
					      <div class="col-sm-3">
					       <input type="text" class="form-control" id="txt_search_username">
					      </div>
					      <label class="control-label col-sm-1" for="txt_search_department">用户状态</label>
					      <div class="col-sm-3">
					       <input type="text" class="form-control" id="txt_search_department">
					      </div>
					      <div class="col-sm-4" style="text-align:left;">
					       <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
					      </div>
					     </div>
					    </form>
					   </div>
					  </div>
					</div>
				  <div id="toolbar" class="btn-group">
				   <button id="btn_add" type="button" class="btn btn-primary">
				    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				   </button>
				   <button id="btn_edit" type="button" class="btn btn-primary">
				    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
				   </button>
				   <button id="btn_delete" type="button" class="btn btn-danger">
				    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				   </button>
				  </div>
			
			</div> 
		</div>
	</div></div>-->


<script type="text/javascript">
$(document).ready(function () {
	//fristMenus();
	/* var radarChartData = {
			labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
			datasets: [
				{
					label: "My First dataset",
					fillColor: "rgba(220,220,220,0.2)",
					strokeColor: "rgba(220,220,220,1)",
					pointColor: "rgba(220,220,220,1)",
					pointStrokeColor: "#fff",
					pointHighlightFill: "#fff",
					pointHighlightStroke: "rgba(220,220,220,1)",
					data: [65,59,90,81,56,55,40]
				},
				{
					label: "My Second dataset",
					fillColor: "rgba(151,187,205,0.2)",
					strokeColor: "rgba(151,187,205,1)",
					pointColor: "rgba(151,187,205,1)",
					pointStrokeColor: "#fff",
					pointHighlightFill: "#fff",
					pointHighlightStroke: "rgba(151,187,205,1)",
					data: [28,48,40,19,96,27,100]
				}
			]
		};
	
	var pieData = [
					{
						value: 300,
						color:"#F7464A",
						highlight: "#FF5A5E",
						label: "Red"
					},
					{
						value: 50,
						color: "#46BFBD",
						highlight: "#5AD3D1",
						label: "Green"
					},
					{
						value: 100,
						color: "#FDB45C",
						highlight: "#FFC870",
						label: "Yellow"
					},
					{
						value: 40,
						color: "#949FB1",
						highlight: "#A8B3C5",
						label: "Grey"
					},
					{
						value: 120,
						color: "#4D5360",
						highlight: "#616774",
						label: "Dark Grey"
					}

				];

		window.onload = function(){
			window.myRadar = new Chart(document.getElementById("canvas").getContext("2d")).Radar(radarChartData, {
				responsive: true
			});
			var ctx = document.getElementById("chart-area").getContext("2d");
			window.myPie = new Chart(ctx).Pie(pieData);
		} */
})
function fristMenus(){
	  var menulist = "";
	  $.ajax({
         type: 'POST',
         dataType: "json",
         url:'admin/module/getModules',
         success: function (data) {
       	  $.each(data, function (row, index) {
       		  // 一层
       		menulist +='<a data-toggle="collapse" data-parent="accordion" href="#collapse'+index.moduleId+'"><span>'+index.moduleName+'</span></a><br />'
       		+'<ul id="collapse'+index.moduleId+'" class="nav nav-sidebar panel-collapse collapse in">';
       		 
       		$.each(index.childModule, function (row, secondModule) {
       			  //转化为json
       			menulist +='<li><a href="'+secondModule.moduleUrl+'">'+secondModule.moduleName+'</a></li>';
       		  })
       		 menulist += "</ul>";
       	  });
       	 
			//加载到页面
          $("#accordion").append(menulist);
         }
	  
    })  } 
</script>
</body>
</html>