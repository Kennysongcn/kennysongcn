Ext.define("MyApp.view.Top", {
    extend: "Ext.Component",
    alias: 'widget.top',
    height: 50,
    region:'north' ,
	html:'<nav class="navbar navbar-inverse navbar-fixed-top">'+
		'<div class="container-fluid">'+
'<div class="navbar-header">'+
	'<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">'+
		'<span class="sr-only">Toggle navigation</span> '+
		'<span class="icon-bar"></span> '+
		'<span class="icon-bar"></span> '+
		'<span class="icon-bar"></span>'+
	'</button>'+
	'<a class="navbar-brand" href="admin/index">KennySong</a></div>'+
'<div id="navbar" class="navbar-collapse collapse">'+
	'<ul class="nav navbar-nav navbar-right">'+
		'<li><a href="admin/index/#">仪表板</a></li>'+
		'<li><a href="admin/index/#">设置</a></li>'+
		'<li><a href="admin/loginOut">退出</a></li>'+
	'	<li><a href="admin/index/#">帮助</a></li>'+
	'</ul>'+
	'<form class="navbar-form navbar-right">'+
		'<input type="text" class="form-control" placeholder="Search...">'+
	'</form></div></div></nav>'

});


