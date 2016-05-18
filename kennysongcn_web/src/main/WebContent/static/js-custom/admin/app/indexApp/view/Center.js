Ext.define('MyApp.view.Center',{  
        extend:'Ext.tab.Panel',
        id:'mainContent',
        //layout:'fit',  
        //注意 加上widget.  
        alias:'widget.center',  
        region:'center',  
        activeTab:0,  
        items:[  
               {  
            	   id: 'tabIndex',
                   title:'主页', 
                   layout: 'fit',
                   collapisble: true,
                   html:'欢迎使用后台管理系统 版本1.0'  
               } 
        ],  
        initComponent:function(){  
            this.callParent(arguments);  
        }  
    }  
) 