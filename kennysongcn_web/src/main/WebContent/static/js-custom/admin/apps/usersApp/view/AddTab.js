Ext.define("Common.view.AddTab", {
	extend : 'Ext.tab.Panel',
});

function getParent(){
	 var mainPanle= Ext.getCmp('mainContent');
	 if(tab){
		 mainPanle.setActiveTab(tab); 
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
}