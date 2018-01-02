$(function() {
	$("#data")
			.bootstrapTable(
					{
						url : basePath + "queery-by-page",
						totalField : 'total',
						dataField : 'records',
						pagination : true,
						sidePagination : "server",
						pageSize : 2,
						pageList : [ 3, 10, 25, 50, 100 ],
						toolbar : "#toolbar",
						columns : [
								{
									field : "categoryName",
									title : "分类名称"

								},
								{
									field : "createTime",
									title : "创建时间",
									formatter : function(value, row, index,
											field) {
										var da = new Date(value);
										var year = da.getFullYear() + '-';
										var month = da.getMonth() + 1 + '-';
										var date = da.getDate();

										return year + month + date;
									}

								},
								{
									field : "sort",
									title : "排序"
								},
								{
									field : "status",
									title : "状态",
									formatter : function(value, row, index,
											field) {
										if (value === true) {
											return '有效';
										}
										return "无效";
									}
								},
								{
									field : 'operate',
									title : '操作',
									align : 'center',
									events : {
										'click .btn-edit' : function(e, value,
												row, index) {
											document.location = basePath
													+ "course-category/update?id="
													+ row.id
										},
										'click .btn-danger' : function(e,
												value, row, index) {
											var doDelete = function() {
												var id = row.id;
												var url = basePath
														+ "course-category"
														+ "/delete/" + id;
												var table = $("#data");
												var deteOpt = {
													field : 'id',
													values : [ row.id ]
												}
												var deleteMethod = function(
														result) {
													if (result.code === 0) {
														table.bootstrapTable(
																'remove',
																deteOpt);
														layer.close(index);
													} else {
														layer
																.msg(result.message);
													}
												}
												$.post(url, deleteMethod,
														"json")

											}
											var index = layer.confirm(
													"确定要删除该记录吗？", doDelete);
										}

									},
									formatter : function(value, row, index) {
										return [
												'<btn class="btn btn-xs btn-edit btn-info"  title="Like">',
												'<i class="glyphicon glyphicon-edit"></i>',
												'</btn>  ',
												'<btn class="btn btn-xs btn-danger href="javascript:void(0)" title="Remove">',
												'<i class="glyphicon glyphicon-remove"></i>',
												'</btn>' ].join('');
									}
								} ]
					});

	$("#add").click(function() {
		document.location = basePath + "course-category/add";
	});

	window.operateEvents = {};

});
