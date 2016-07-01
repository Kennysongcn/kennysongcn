Ext.define('MyApp.store.Module', {
    extend: 'Ext.data.TreeStore',
    model: 'MyApp.model.MenuModel',
    root: {
        expanded: true,
        children: [{
            name: 'Europe, ME, Africa',
            mtype: 'MenuModel'
        }, {
            name: 'North America',
            mtype: 'MenuModel'
        }]
    }
});