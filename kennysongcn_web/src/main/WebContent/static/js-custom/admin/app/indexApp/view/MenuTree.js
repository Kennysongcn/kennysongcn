Ext.define('Demo.view.MenuTree', {
	    extend: 'Ext.tree.Panel',
	    alias: 'widget.menutree',
	    border: false,
	    //规定锚链接地址的显示区域
	    hrefTarget: 'mainContent',
	    //是否显示根节点
	    rootVisible: false,
	    //数据集
	    store: 'MenuStore',
	    //菜单样式
	    bodyStyle: {
	        background: '#ffc',
	        padding: '10px'
	    }
	});