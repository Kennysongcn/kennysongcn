Ext.define("User.store.user.UserListStore", {
	extend: "Ext.data.Store",
        	model: "User.model.UserModel",
            fields: ["userId", "groupId", "userName", "userPwd"/**/, "userPhone", "userSex",
                     "userQq", "userEmail", "userAddress",
                     "userMark", "userRankId", "userLastLoginIp",
                     "userBirthday", "userDescription", "userImageUrl",
                     "userSchool", "userRegisterTime", "userRegisterIp",
                     "userLastUpdateTime", "userWeibo", "userBloodType",
                     "userSays", "userLock", "userFreeze",
                     "userPower"],
            pageSize: 5,  //页容量5条数据
            //是否在服务端排序 （true的话，在客户端就不能排序）
            remoteSort: false,
            remoteFilter: true,
            autoSync : false,
            proxy: {
                type: 'ajax',
                url: 'admin/manage/users/list',
                reader: {   //这里的reader为数据存储组织的地方，下面的配置是为json格式的数据，例如：[{"total":50,"rows":[{"a":"3","b":"4"}]}]
                    type: 'json', //返回数据类型为json格式
                    rootProperty: 'rows',  //数据
                    totalProperty: 'total' //数据总条数
                }
            },
            sorters: [{
                //排序字段。
                property: 'ordeId',
                //排序类型，默认为 ASC 
                direction: 'desc'
            }],
            autoLoad: true  //即时加载数据
        });