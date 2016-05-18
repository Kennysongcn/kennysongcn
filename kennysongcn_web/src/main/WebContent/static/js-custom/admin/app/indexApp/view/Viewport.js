Ext.define("MyApp.view.Viewport", {
	extend : 'Ext.container.Viewport',
	// 布局方式：border
	layout : 'border',
	items : [ {
		xtype : 'top'// 这里可以写对应view的alias的属性
	}, {
		xtype : 'center'
	}, {
		xtype : 'accordion'
	}, {
		xtype : 'bottom'
	} ]
});
