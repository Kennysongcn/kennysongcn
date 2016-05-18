 Ext.define("MyApp.model.User", {
            extend: "Ext.data.Model",
            fields: [
                { name: 'userInfoId', type: 'int' },
                { name: 'name', type: 'int' },
                { name: 'loginName', type: 'string' },
                { name: 'email', type: 'string' },
                { name: 'telphone', type: 'string' },
                { name: 'userCode', type: 'string' },
                { name: 'positionName', type: 'string' },
                { name: 'createTime', type: 'string' },
                { name: 'updateTime', type: 'string' }
                
            ]
        });