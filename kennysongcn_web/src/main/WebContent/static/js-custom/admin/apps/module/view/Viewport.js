Ext.define("MyApp.view.Viewport", {
	extend : 'Ext.container.Viewport',
	 alias: 'widget.configViewport',
	// 布局方式：border
	layout : 'border',
	items : [ {
		xtype : 'top'// 这里可以写对应view的alias的属性
	}, {
		xtype : 'center'
	}, {
		xtype : 'west'
	}, {
		xtype : 'bottom'
	} ],
	initComponent: function() {
//      var soup = {
//          contents: [],
//          add: function(ingredient) {
//              alert(2);
//              this.contents.push(ingredient);
//          }
//      };
//      Ext.Function.interceptAfter(soup, "add", function(ingredient){
//          // Always add a bit of extra salt
//          alert(ingredient);
//          this.contents.push("salt");
//      });
//      soup.add("water");
//      soup.add("onions");
//     alert( soup.contents)
      this.callParent();
  }
});
