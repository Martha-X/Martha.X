<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="super-theme-example">
	<div style="height: 650px;">
		<table id="itemParamList"></table>
	</div>
	<br /> <br />
</div>
<script type="text/javascript">
	$('#itemParamList')
	.datagrid(
		{
			url : 'item/param/list',
			fit : true,
			pagination : true,
			fitColumns : true,
			toolbar : [ {
				text : '新增',
				iconCls : 'fa fa-plus',
				handler : function() {
					//$("#item-add").click();
				}
			}, {
				text : '编辑',
				iconCls : 'fa fa-edit',
				handler : function() {
					var ids = getSelections();
					//判断如果未选定行，不执行，提示
					if(ids.length == 0 || ids.indexOf(',') > 0){
						$.messager.alert('提示','必需选择且只能选择一个商品！');
						return;
					}
					//如果选定多行数据提示只能选择一个商品
					$("#itemUpadteWindow").window({
						onLoad:function(){
							var data = $("#dgTbItem").datagrid("getSelections")[0];
							$("#itemUpdateForm").form('load',data);
							//将商品描述进行显示
							$.getJSON("item/query/item-desc/" + data.id,function(result){
								if(result.status == 200){
									itemUpdateEditor.html(result.data.itemDesc);
								}
							})
							TT.init({
								"pics":data.image,
								"cid":data.cid,
								fun:function(node){
									console.log("node");
									console.log(node);
								}
							});
							console.log(data);
						}
					}).window('open');
				}
			}, {
				text : '刷新',
				iconCls : 'fa fa-save',
				handler : function() {
					//$("#dgTbItem").datagrid("reload");
				}
			}, {
				text : '删除',
				iconCls : 'fa fa-remove',
				handler : function() {
					//options("删除",3);
				}
			}],
			height : 400,
			columns : [ [
				{
					field : 'id',
					title : 'ID',
					width : 100,
					align : 'center',
					sortable : true
				},
				{
					field : 'itemCatId',
					title : '类目ID',
					width : 60,
					align : 'center',
					sortable : true
				},
				{
					field : 'itemCatName',
					title : '类目名称',
					width : 60,
					align : 'center',
					sortable : true
				},
				{
					field : 'paramData',
					title : '商品规格',
					width : 300,
					formatter:formatItemParamData
				},
				{
					field : 'created',
					title : '创建时间',
					width : 100,
					align : 'center',
					formatter : TT.formatDateTime
				}, {
					field : 'updated',
					title : '更新时间',
					width : 100,
					align : 'center',
					formatter : TT.formatDateTime
				} ] ]
			});
	function formatItemParamData(val,index){
		var json = JSON.parse(val);
		var arr = [];
		$.each(json,function(i,e){
			arr.push(e.group);
		});
		return arr.join(",");
	}
</script>