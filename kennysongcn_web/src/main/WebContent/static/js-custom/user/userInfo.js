$(function () {
	tableInit();
});
 
 function tableInit() {
	  $('#table-user').bootstrapTable({
		  method: 'get',
		  url: 'admin/manage/userinfo/list',
		  dataType: "json",
		  striped: true,	 //使表格带有条纹
		  pagination: true,	//在表格底部显示分页工具栏
		  pageNumber: 1,
		  pageSize: 5,
		  pageList: [5, 10, 25, 50],
		  idField: "userInfoId",  //标识哪个字段为id主键
		  showToggle: true,   //名片格式
		  cardView: false,//设置为True时显示名片（card）布局
		  showColumns: true, //显示隐藏列  
		  showRefresh: true,  //显示刷新按钮
		  singleSelect: true,//复选框只能选择一条记录
		  search: false,//是否显示右上角的搜索框
		  clickToSelect: true,//点击行即可选中单选/复选框
		  sidePagination: "server",//表格分页的位置
		  queryParams: queryParams, //参数
		  queryParamsType: "limit", //参数格式,发送标准的RESTFul类型的参数请求
		  toolbar: "#toolbar", //设置工具栏的Id或者class
		  columns: [{
			    checkbox: true
			   }, {
			    field: 'userCode',
			    title: '用户编码'
			   }, {
			    field: 'userName',
			    title: '用户名称'
			   }, {
			    field: 'email',
			    title: '邮箱'
			   }, {
			    field: 'telphone',
			    title: '手机号'
			   },{
				    field: 'positionName',
				    title: '职位'
				   },{
					    field: 'userStatus',
					    title: '状态'
					   }, ], //列
		  silent: true,  //刷新事件必须设置
		  formatLoadingMessage: function () {
		    return "请稍等，正在加载中...";
		  },
		  formatNoMatches: function () {  //没有匹配的结果
		    return '无符合条件的记录';
		  },
		  onLoadError: function (data) {
		    $('#reportTable').bootstrapTable('removeAll');
		  }/*,
		  onClickRow: function (row) {
		    window.location.href = "/qStock/qProInfo/" + row.ProductId;
		  },*/
		});
  }
 
 function queryParams(params) {  //配置参数
	    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	    rows: params.limit, //页面大小
	    start:  params.offset, //页码
	     userName: $("#txt_search_username").val(),
	     department: $("#txt_search_department").val()
	    };
	    return temp;
	  }