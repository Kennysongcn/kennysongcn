<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String cpath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+cpath+"/";
%>
<base href="<%=basePath%>">

<!-- ============jquery=============== -->
<script src="<%=basePath%>static/js-frame/jquery/jquery-2.2.3.min.js"></script>

<!-- ======================= bootstrap=============== -->
 <!-- ------------------js--------------- -->
<script src="<%=basePath%>static/js-frame/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>static/js-frame/bootstrap/js/Chart.min.js"></script>
<!--  css --> 
<link rel="stylesheet" href="<%=basePath%>static/js-frame/bootstrap/css/bootstrap.css" /> 
<link rel="stylesheet" href="<%=basePath%>static/js-frame/bootstrap/css/bootstrap-theme.min.css" />


<!-- =======================Extjs======================= -->
<script type="text/javascript" src="<%=basePath%>static/js-frame/Extjs/ext-bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/js-frame/Extjs/build/classic/theme-crisp/resources/theme-crisp-all.css" />

<!-- ==========================SeaJs======================= -->
<script type="text/javascript" src="<%=basePath%>static/js-frame/seajs/sea.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js-frame/seajs/runtime.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js-frame/seajs/runtime-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js-frame/seajs/sea-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js-frame/seajs/runtime-debug.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js-frame/seajs/runtime.js"></script>
<!-- ==========================angularJs====================== -->
<script type="text/javascript" src="<%=basePath%>static/js-frame/angularJs/angular.min.js"></script>