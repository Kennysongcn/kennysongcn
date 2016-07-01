Ext.define("User.view.UserListView", {
	extend : 'Ext.grid.Panel',
	id : 'UserListView',
	title : '用户管理',
	renderTo: Ext.getBody(),
    width:800,
    layout: {type: 'table'},
	alias : 'widget.userListView',
	region : 'center',
	store : 'UserListStore',
	selModel: { selType: 'checkboxmodel'},
	columnLines:true,
    initComponent: function() {
    	this.tbar=[{text : '添加',action : 'add',iconCls : 'add_btn'},
    	           {text : '删除',action : 'del',iconCls : 'del_btn'},
    	           {text : '编辑',action : 'edit',iconCls : 'edit_btn'}];
    	
        this.bbar = [{ xtype: 'pagingtoolbar',
            store: 'UserListStore',
            displayMsg: '显示 {0} - {1} 条，共计 {2} 条',
            emptyMsg: "没有数据",
            beforePageText: "当前页",
            afterPageText: "共{0}页",
            displayInfo: true                 
        }]
        
        this.columns=[{text : '用户名',dataIndex : 'userName',}, 
                      {	text : '用户手机',dataIndex : 'userPhone',},
                      {text : '用户QQ',dataIndex : 'userQq',},
                      {text : '用户邮箱',dataIndex : 'userEmail',},
                      {text : '用户地址',dataIndex : 'userAddress',},
                      {text : '用户生日',dataIndex : 'userBirthday',},
                      {text : '注册时间',dataIndex : 'userRegisterTime',},
                      {text : '是否锁定',dataIndex : 'userLock',},
                      {text : '是否冻结',dataIndex : 'userFreeze',}],
        this.callParent();
    }
	
});