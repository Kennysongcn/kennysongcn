Ext.define('User.controller.UserController', {
	extend : 'Ext.app.Controller',
	views : [ 'Viewport','UserListView'],
	stores: ['UserListStore'],
	model: ['UserModel'],
	init : function(){
	    this.control({
	      'userListView>toolbar button[action=add]':{
	        click : this.addUser
	      },
	      'userListView>toolbar button[action=del]':{
	        click : this.delUser
	      },			
	      'userListView>toolbar button[action=edit]' : {
	        click : this.editUserInfo
	      }
	    });
	  },
		  editUserInfo : function(btn){
			var  grid = Ext.getCmp('UserListView');
			var selRecords  = grid.getSelectionModel().getSelection();
			var len = selRecords.length;
			if (len == 0) {  
			    Ext.MessageBox.alert("提示消息", "您未选中任何数据!");  
			    return false;  
			}else{
				win(selRecords);
				//var mainPanle= Ext.getCmp('mainContent');
				//xtype:''
			}
		},
});

function win(selRecords){
	var data = selRecords[0].data;
	var form  = Ext.create('Ext.form.FormPanel', {
	    bodyPadding: 5,
	    width: 350,
	    // 将会通过 AJAX 请求提交到此URL
	  //  url: 'save-form.php',
	    // 表单域 Fields 将被竖直排列, 占满整个宽度
	    layout: 'form',
	    defaults: {
	        anchor: '100%'
	    },
	    method:'GET',
	    // The fields
	    defaultType: 'textfield',
	    items: [{fieldLabel: '用户名称',name: 'userName',allowBlank: false},
        { fieldLabel: '手机',name: 'userPhone', allowBlank: false },
        { fieldLabel: '性别',name: 'userSex', allowBlank: false },
        { fieldLabel: 'QQ',name: 'userQq', allowBlank: false },
        { fieldLabel: '邮箱',name: 'userEmail', allowBlank: false },
        { fieldLabel: '住址',name: 'userAddress', allowBlank: false },
        { fieldLabel: '用户积分',name: 'userMark', allowBlank: false },
        { fieldLabel: '上传登录IP',name: 'userLastLoginIp', allowBlank: false },
        {fieldLabel: '生日', name: 'userBirthday', allowBlank: false },
        { fieldLabel: '血型',name: 'userBloodType', allowBlank: false },
        { fieldLabel: '自我描述',name: 'userDescription', allowBlank: false },
        {fieldLabel: '头像', name: 'userImageUrl', allowBlank: false },
        {fieldLabel: '毕业学校', name: 'userSchool', allowBlank: false },
        { fieldLabel: '注册时间',name: 'userRegisterTime', allowBlank: false },
        { fieldLabel: '用户名',name: 'userRegisterIp', allowBlank: false },
        { fieldLabel: '上次登录时间',name: 'userLastUpdateTime', allowBlank: false },
        { fieldLabel: '用户名',name: 'userWeibo', allowBlank: false },
        { fieldLabel: '用户语录',name: 'userSays', allowBlank: false },
        { fieldLabel: '锁定状态',name: 'userLock', allowBlank: false },
        { fieldLabel: '冻结状态',name: 'userFreeze', allowBlank: false }],
	    // 重置 和 保存 按钮.
	    buttons: [{
	        text: '重置',
	        handler: function() {
	            this.up('form').getForm().reset();
	        }
	    }, {
	        text: '保存',
	        formBind: true, //only enabled once the form is valid
	        disabled: true,
	        handler: function() {
	            var form = this.up('form').getForm();
	            if (form.isValid()) {
	                form.submit({
	                    success: function(form, action) {
	                       Ext.Msg.alert('保存成功', action.result.msg);
	                    },
	                    failure: function(form, action) {
	                        Ext.Msg.alert('操作失败', action.result.msg);
	                    }
	                });
	            }
	        }
	    }],
	    renderTo: Ext.getDetachedBody('mainContent')
	});
	form.getForm().load({
	    url: 'admin/manage/users/'+data.userId
	});
return form;
}

function addTab(data){
	var mainPanle= Ext.getCmp('mainContent');
	var tab = mainPanle.queryById(data.id); 
	 if(tab){
		 mainPanle.setActiveTab(tab); 
		 }else{
			 tab=mainPanle.add({
				 id: data.id, 
				 title:data.userName, 
				 closable: true,
				 iconCls : 'tabs',
				 margins : '0 4 4 0',
				 html : '<iframe ID="editUserInfoFrame'+data.userId+'" name="main"  width="100%" height="100%" frameborder="0">zxc</iframe>'
			 }).show();
		 }
	 return tab;
}