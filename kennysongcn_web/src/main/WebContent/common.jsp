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
<%-- <script src="<%=basePath%>static/js-frame/bootstrap/js/table/bootstrap-table.min.js"></script> 
<script src="<%=basePath%>static/js-frame/bootstrap/js/table/bootstrap-table-locale-all.min.js"></script> 
<script src="<%=basePath%>static/js-frame/bootstrap/js/table/bootstrap-table-en-US.js"></script> 
<script src="<%=basePath%>static/js-frame/bootstrap/js/table/bootstrap-table-zh-CN.js"></script>  --%>
<!--  css --> 
<link rel="stylesheet" href="<%=basePath%>static/js-frame/bootstrap/css/bootstrap.css" /> 
<%-- <link rel="stylesheet" href="<%=basePath%>static/js-frame/bootstrap/css/bootstrap.min.css" />  --%>
<%-- <link rel="stylesheet" href="<%=basePath%>static/js-frame/bootstrap/css/bootstrap.css.map" /> --%>
<link rel="stylesheet" href="<%=basePath%>static/js-frame/bootstrap/css/bootstrap-theme.min.css" />
<%-- <link rel="stylesheet" href="<%=basePath%>static/js-frame/bootstrap/css/bootstrap-table.min.css" />
<link rel="stylesheet" href="<%=basePath%>static/js-frame/bootstrap/css/jquery.dataTables.css" /> --%>


<!-- =======================Extjs======================= -->
<script type="text/javascript" src="<%=basePath%>static/js-frame/Extjs/ext-bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/js-frame/Extjs/build/classic/theme-crisp/resources/theme-crisp-all.css" />
