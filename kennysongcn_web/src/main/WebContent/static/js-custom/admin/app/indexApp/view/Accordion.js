Ext.define("MyApp.view.Accordion", {
	id : 'menuPanel',
	extend : 'Ext.panel.Panel',
	title : '系统设置',
	hrefTarget : 'mainContent',
	alias : 'widget.accordion',
	// 是否可以折叠
	collapsible : true,
	// 是否可以通过拖动改变宽度
	// split:true,
	width : 200,
	// 布局方式
	layout : 'accordion',
	region : 'west',
	layoutConfig : {
		titleCollapse : true, // 设置为点击整个标题栏都可以收缩
		animate : true, // 开启默认动画效果
		activeOnTop : true
	// 展开的面板总是在最顶层
	}
});

function treeMenuEven(data) {
	$.each(data, function(row, index) {
		$.each(index.childModule, function(row, index) {
		Ext.getCmp('menuPanel').add(Ext.create("Ext.tree.Panel", {
			id : index.moduleSn,
			store : treeStore(index, index.moduleSn),
			title : index.moduleName,
			iconCls : index.icon,
			useArrows : true,
			autoScroll : true,
			rootVisible : false,
			listeners : {
				itemclick : {
					fn : function(view, record, item, index, e, obj) {
						 var mainPanle= Ext.getCmp('mainContent');
						 var tab = mainPanle.queryById(record.data.id); 
					 if(tab){
							 mainTab.setActiveTab(tab); 
						 }else{
							 tab=mainPanle.add({
								 id: record.data.id, 
								 title:record.data.text, 
								 closable: true,
								 iconCls : 'tabs',
								 margins : '0 4 4 0',
								 html : '<iframe ID="mainFrame" name="main" src="'+record.data.moduleUrl+'" width="100%" height="100%" frameborder="0">ss</iframe>'
							 }).show();
						 }
						 e.stopEvent;
					},
					scope : this
				}
			},
		}));
		})
	})
	Ext.getBody().unmask();
}

var treeStore = function(index, moduleSn) {
	var arrayObj = new Array();
	$.each(index.childModule, function(row, index) {
		str = {
			"parentId" : index.moduleSn,
			leaf : true,
			"text" : index.moduleName,
			"moduleSn" : index.moduleSn,
			"moduleUrl":index.moduleUrl,
			"parentModuleId" : index.parentModuleId
		};
		arrayObj.push(str);
	})

	var store = Ext.create('Ext.data.TreeStore', {
		root : {
			expanded : true,
			children : arrayObj
		}
	});
	return store;
};
