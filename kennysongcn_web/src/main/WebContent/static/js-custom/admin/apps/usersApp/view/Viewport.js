Ext.define("User.view.Viewport", {
	extend : 'Ext.container.Viewport',
	// 布局方式：border
	layout : 'border',
	items : [ {
		xtype : 'userListView'
	}]
});
