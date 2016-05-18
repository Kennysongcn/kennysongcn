/*常量*/
var CONSTANT = {
		DATA_TABLES : {
			DEFAULT_OPTION : { //DataTables初始化选项
				language: {
					"processing":   "处理中...",
					"lengthMenu":   "每页 _MENU_ 项",
					"zeroRecords":  "没有匹配结果",
					"info":         "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
					"infoEmpty":    "当前显示第 0 至 0 项，共 0 项",
					"infoFiltered": "(由 _MAX_ 项结果过滤)",
					"infoPostFix":  "",
					//"sSearch":       "搜索:",
					"url":          "",
					"emptyTable":     "表中数据为空",
					"loadingRecords": "载入中...",
					"infoThousands":  ",",
					"paginate": {
						"first":    "首页",
						"previous": "上页",
						"next":     "下页",
						"last":     "末页"
						//"jump":     "跳转"
					},
					"aria": {
						"sortAscending":  ": 以升序排列此列",
						"sortDescending": ": 以降序排列此列"
					}
				},
                autoWidth: false,	//禁用自动调整列宽
                stripeClasses: ["odd", "even"],//为奇偶行加上样式，兼容不支持CSS伪类的场合
                order: [],			//取消默认排序查询,否则复选框一列会出现小箭头
                processing: true,	//隐藏加载提示,自行处理
                serverSide: true,	//启用服务器端分页
                searching: false	//禁用原生搜索
			},
			COLUMN: {
                CHECKBOX: {	//复选框单元格
                    className: "td-checkbox",
                    orderable: false,
                    width: "30px",
                    data: "userInfoId",
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" class="iCheck">';
                    }
                }
            },
            RENDER: {	//常用render可以抽取出来，如日期时间、头像等
                ELLIPSIS: function (data, type, row, meta) {
                	data = data||"";
                	return '<span title="' + data + '">' + data + '</span>';
                }
            }
		}
};