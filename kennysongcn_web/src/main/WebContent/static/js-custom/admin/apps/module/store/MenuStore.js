Ext.define("MyApp.store.MenuStore", {
	extend : "Ext.data.TreeStore",
	defaultRoodId : "rows",
	model : "MyApp.model.MenuModel",
	proxy : {
		type : 'ajax',
		url : 'admin/module/getModules',
		reader : { // 这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
			type : 'json', // 返回数据类型为json格式
			root : 'rows', // 数据
			totalProperty : 'total' // 数据总条数
		}
	},
	autoLoad : true
// 即时加载数据
});