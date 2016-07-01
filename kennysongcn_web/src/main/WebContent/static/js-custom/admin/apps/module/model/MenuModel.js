 Ext.define("MyApp.model.MenuModel", {
            extend: 'Ext.data.TreeModel',
            fields: [{
    	        name: 'text',
    	        mapping: 'title'
    	    },{
    	        name: 'url',
    	        mapping: 'module'
    	    }]
        });
