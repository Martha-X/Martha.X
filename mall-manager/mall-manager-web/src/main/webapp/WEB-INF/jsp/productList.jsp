<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="super-theme-example">
		<div style="height: 650px;">
			<table id="dgTbItem"></table>
		</div>
		<br /> <br />
		<div id="itemUpadteWindow" class="easyui-window" title="My Window"
			style="width: 80%; height: 80%;"
			data-options="iconCls:'icon-save',modal:true,closed:'true',href:'item_update'"></div>
	</div>
	<script type="text/javascript">
		$('#dgTbItem')
				.datagrid(
						{
							url : 'item/getItem',
							fit : true,
							pagination : true,
							fitColumns : true,
							toolbar : [ {
								text : '新增',
								iconCls : 'fa fa-plus',
								handler : function() {
									$("#item-add").click();
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
											TT.init({
												"image":data.image,
												"cid":data.cid,
												fun:function(node){
													
												}
											});
											console.log(data);
										}
									}).window('open');
								}
							}, {
								text : '保存',
								iconCls : 'fa fa-save',
								handler : function() {
								}
							}, {
								text : '删除',
								iconCls : 'fa fa-remove',
								handler : function() {
								}
							}, {
								text : '上架',
								iconCls : '"fa fa-upload',
								handler : function() {
								}
							}, {
								text : '下架',
								iconCls : '"fa fa-download',
								handler : function() {
								}
							} ],
							height : 400,
							columns : [ [
									{
										field : 'id',
										title : '商品id',
										width : 100,
										align : 'center',
										sortable : true
									},
									{
										field : 'title',
										title : '商品标题',
										width : 100,
										align : 'center',
										sortable : true
									},
									{
										field : 'sellPoint',
										title : '商品卖点',
										width : 100,
										align : 'center',
										sortable : true
									},
									{
										field : 'price',
										title : '商品价格',
										width : 100,
										align : 'center',
										sortable : true
									},
									{
										field : 'num',
										title : '商品库存',
										width : 100,
										align : 'center',
										sortable : true
									},
									{
										field : 'barcode',
										title : '商品条形码',
										width : 100,
										align : 'center',
										sortable : true
									},
									{
										field : 'image',
										title : '商品图片',
										width : 300,
										align : 'center',
										formatter : function(value, row) {
											return "<img src=" + value + " width='300px' height='200px'>";
										}
									}, {
										field : 'cid',
										title : '商品类目',
										width : 100,
										align : 'center',
									}, {
										field : 'status',
										title : '商品状态',
										width : 100,
										align : 'center',
										formatter : TT.formatItemStatus
									}, {
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
		function getSelections(){
			var itemList = $("#dgTbItem");
			var sels = itemList.datagrid("getSelections");
			var ids = [];
			for(var i in sels){
				ids.push(sels[i].id);
			}
			ids = ids.join(",");
			return ids;
		}
	</script>