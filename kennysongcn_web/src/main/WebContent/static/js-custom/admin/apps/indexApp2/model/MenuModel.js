 Ext.define("MyApp.model.MenuModel", {
            extend: 'Ext.data.TreeModel',
            fields: [
               // { name: 'moduleId', type: 'int' },
               // { name: 'moduleSn', type: 'int' },
              //  { name: 'ParentModuleId',},
                { name: 'text',mapping: 'moduleName'},
             //   { name: 'moduleUrl', type: 'string' },
                //{ name: 'icon', type: 'string' },
            ]
        });