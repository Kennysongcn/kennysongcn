Ext.onReady(function(){
	//开启悬浮提示功能

	Ext.QuickTips.init();
	//开启动态加载
	Ext.Loader.setConfig({
		enabled: true
	});
	Ext.application({
		//设定命名空间
		name: 'MyApp',
		//指定配置选项，设置相应的路径
		appFolder: 'static/js-custom/admin/apps/module',
		//自动加载和实例化Viewport文件
		autoCreateViewport: true,
		//加载控制器
		controllers: ['ModuleController'],
		launch: function() {
	        //Ext.Msg.alert('1','323333333');
	          Ext.tip.QuickTipManager.init();
	        }
	});
});

