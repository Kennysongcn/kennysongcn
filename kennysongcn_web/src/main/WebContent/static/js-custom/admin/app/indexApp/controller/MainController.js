/*var updateClock = function() {
	var date = new Date();
	var aWeek = [ '星期天', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ];
	Ext.getElementById('clock').innerHTML = "现在是"
			+ Ext.Date.format(date, 'Y年m月d日	' + aWeek[new Date().getDay()]
					+ '	H时i分s秒');
}
var task = Ext.TaskManager.start({
	run : updateClock,
	interval : 1000
});
function transTime() {
	var dt = new Date();
	var time = Ext.Date.format(dt, 'A');
	if (time == 'AM') {
		return '早上好,' + Ext.getElementById('getUserName').value;
	} else {
		return '下午好,' + Ext.getElementById('getUserName').value;
	}
}*/
Ext.define('MyApp.controller.MainController', {
	extend : 'Ext.app.Controller',
	views : [ 'Center', 'Top', 'Accordion', 'Bottom' ],
	init : function() {
		this.control({
			'viewport > accordion' : {
				afterrender : this.getRootId,
				
			},
			
		});
	},
	/*logout : function() {
		Ext.Msg.confirm("提示", "确认要退出系统？", function(btn) {
			if (btn == "yes") {
				alert(Ext.getElementById('getUserName').value);
				// document.location =
				// "web-page/logout.jsp";
			}
		});
	},*/
	getRootId : function() {
		Ext.getBody().mask('正在加载系统菜单,请稍后...');
		Ext.Ajax.request({
			url : 'admin/module/getModules',
			method : 'POST',
			// 回调
			callback : function(options, success, response) {
				treeMenuEven(Ext.JSON.decode(response.responseText));
			}
		});
	},
	changePage:function(){
			        alert('success');
			    }
});