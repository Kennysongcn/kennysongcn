Ext.define('MyApp.view.ModuleView', {
    extend: 'Ext.Component',
    alias: 'widget.moduleView',
    store: 'Module',
    trackOver: true,
    cls: 'feed-list',
    itemSelector: '.feed-list-item',
    overItemCls: 'feed-list-item-hover',
    tpl: '<tpl for="."><div class="feed-list-item">{title}</div></tpl>'
});