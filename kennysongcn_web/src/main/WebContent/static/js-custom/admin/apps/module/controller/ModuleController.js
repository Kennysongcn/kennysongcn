Ext.define('MyApp.controller.ModuleController', {
	extend : 'Ext.app.Controller',
	views : [ 'Center', 'Top', 'West', 'Bottom' ],
	init: function(app) {
        this.control({
            'viewport > west': {
                'afterrender':this.afrender,
                'select':this.onSelectionChange
            }
        });
    },afrender:function(view){
		Ext.getBody().mask('正在加载系统菜单,请稍后...');
		Ext.Ajax.request({
			url : 'admin/module/getModules',
			method : 'GET',
			// 回调
			callback : function(options, success, response) {
				treeMenuEven(Ext.JSON.decode(response.responseText));
			}
		});
       // view.getSelectionModel().select(view.store.first());
    },onSelectionChange: function(thisview, record, eOpts){
        var self = this;
        var selected = record;
         if(selected.get('module') =='userModule'){
     	  Ext.require("MyApp.controller.UserController",function(){
 			 var userController = application.getController('UserController');
 			 userController.init(self);
     	  },self);
         }else if(selected.get('module') =='roleModule'){
        	  Ext.require("MyApp.controller.RoleController",function(){
        		 var roleController = application.getController('RoleController');
        		 roleController.init(self);
 	  	  },self);
         }
     }
 });
