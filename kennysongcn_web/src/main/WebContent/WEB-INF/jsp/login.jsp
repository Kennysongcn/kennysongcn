<%@ page language="java" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.inc.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<meta >
<title>记忆旅行后台管理系统</title>
<meta name="description" content="">
<meta name="Keywords" content="">
<%@ include file="/common.jsp"%>
<link href="${contextPath}/static/css/signin.css" rel="stylesheet">

</head>
<body class="mybody">
		<div class="signin">
			<div class="signin-head"><img src="${contextPath}/static/images/test/head_121.png" alt="" class="img-circle"></div>
			<form class="form-signin" role="form" id="loginForm" action=""  method="post">
				<input type="text" name="username"   id="username" class="form-control" placeholder="用户名" required autofocus />
				<input type="password"   name="password"  id="password" class="form-control" placeholder="密码" required />
				<button id="btnEp" class="btn btn-lg btn-warning btn-block" type="button" onclick="login()">登录</button>
				<label class="checkbox">
					<input type="checkbox" value="remember-me"> 记住我
				</label>
			</form>
		</div>
</body>
<script type="text/javascript">

if (window != top) {
	top.location.href = location.href; 
}

	function cleardata() {
		$('#loginForm').form('clear');
	}
	function login() {
		if ($("input[name='username']").val() == "") {
			Ext.Msg.alert('消息提示', '用户名为空，请输入用户名');
			$("input[name='username']").focus();
		}else if($("input[name='password']").val() == ""){
			Ext.Msg.alert('消息提示', '密码为空，请输入用户名');
			$("input[name='password']").focus();
		} else {
			//ajax异步提交  
			$.ajax({
				type : "POST", //post提交方式默认是get
				url : "${contextPath}/admin/login",
				data : $("#loginForm").serialize(), //序列化             
				beforeSend: function () {
					 $('#btnEp').attr('disabled',true);
					document.getElementById("btnEp").style.background="#90a2bc";
					// alert("与服务器交互开始调用！"); 
					 //load();
				    },
				error : function(request) { // 设置表单提交出错        
					//disLoad();
					$("#showMsg").html(request); //登录错误提示信息
				},
				success : function(data) {
					if(data==""){
						Ext.Msg.confirm( '消息提示','用户名或密码错误，请重新输入',function (e){
							
							if(e=="yes"){
								 $('#btnEp').attr('disabled',false);
								 document.getElementById("btnEp").style.background="#eb9316";
								 $("input[name='username']").focus();
								 //document.location = "${contextPath}/admin/index";
							}else{
								//document.location = "${contextPath}/admin/index";
							}
						});
					}else{
				    	document.location = "${contextPath}/admin/index";
				    } 
				
					
				}
			});
		}
	}
</script>
</html>