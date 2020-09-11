<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="super-theme-example">
	<div style="height: 650px;">
		<table id="itemParamList"></table>
	</div>
	<br /> <br />
	<div id="itemParamUpdateWindow" class="easyui-window" title="Martha-X"
		style="width: 80%; height: 80%;"
		data-options="iconCls:'icon-save',modal:true,closed:'true',href:'item_param_update'"></div>
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
					TT.createWindow({url:"item_param_add"});
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
					$("#itemParamUpdateWindow").window({
						onLoad:function(){
							var data = $("#itemParamList").datagrid("getSelections")[0];
							console.log(data);
							$("#itemParamUpdateTable").form('load',data);
							//将商品描述进行显示
							$.getJSON("item/param/query/itemParamList/" + data.id,function(result){
								if(result.status == 200){
								}
							})
							TT.initItemParamCat({
								"cid":data.itemCatName,
							});
							document.querySelector("[name=id]").value = data.id;
							document.querySelector("[name=cid]").value = data.itemCatId;
							var paramData = JSON.parse(data.paramData);//转为json格式
							for(var i = 0;i<paramData.length;i++){//添加组
								$(".addGroup").click();
								for(var j = 1;j<paramData[i].params.length;j++){//添加参数框
									$(".addParam")[i].click();
								}
							}
							var group = document.querySelectorAll("#itemParamUpdateWindow input.textbox-text");//获取第一个input【组】
							var param = document.querySelectorAll("#itemParamUpdateWindow input.textbox-text");//获取第二个input【参数】
							var group = document.querySelectorAll("#" + group[0].id);//获取组id
							var params = document.querySelectorAll("#" + param[1].id);//获取参数inputId
							for(var i= 0;i<group.length-1;i++ ){//去除被克隆无用组并赋值
								group[i].value = paramData[i].group;
							}
							var arr = [];//用于保存参数
							for(var i = 0 ;i<paramData.length;i++){
								for(var j = 0;j<paramData[i].params.length;j++){
									arr.push(paramData[i].params[j]);
								}
							}
							for(var i = 0;i<params.length-1;i++){//放入参数
								params[i].value = arr[i];
							}
							//document.querySelectorAll("#_easyui_textbox_input1")[0].value = paramData[0].group;
							//console.log(document.querySelectorAll("#_easyui_textbox_input1")[0].value);
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
	function getSelections(){
		var itemList = $("#itemParamList");
		var sels = itemList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].id);
		}
		ids = ids.join(",");
		return ids;
	}
</script>