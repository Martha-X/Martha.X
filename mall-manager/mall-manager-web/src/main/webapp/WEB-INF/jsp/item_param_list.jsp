<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="super-theme-example">
	<div style="height: 650px;">
		<table id="itemParamList"></table>
	</div>
	<br /> <br />
	<div id="itemParamUpdateWindow" class="easyui-window" title="Martha-X"
		style="width: 80%; height: 80%;"
		data-options="iconCls:'icon-save',modal:true,closed:'true',href:'${pageContext.request.contextPath}/item_param_update'"></div>
</div>
<script type="text/javascript">
	$('#itemParamList')
	.datagrid(
		{
			url : '${pageContext.request.contextPath}/item/param/list',
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
					var ids = getSelections("#itemParamList");
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
							TT.initItemParamCat({
								"cid":data.itemCatName,
							});
							document.querySelector("#itemParamUpdateTable [name=id]").value = data.id;
							document.querySelector("#itemParamUpdateTable [name=cid]").value = data.itemCatId;
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
				iconCls : 'fa fa-refresh',
				handler : function() {
					$("#itemParamList").datagrid("reload");
				}
			}, {
				text : '删除',
				iconCls : 'fa fa-remove',
				handler : function() {
					//itemIds 为商品id数组，存放一条或多条商品的id
					var itemIds = getSelections("#itemParamList");
					//判断如果未选定行，不执行，提示
					if(itemIds.length == 0){
						$.messager.alert('提示','必需选择一个商品！');
						return;
					}
					//提醒是否删除数据
					$.messager.confirm('确认','您确认想要删除ID为' + itemIds + "的商品吗？",function(r){
						if(r){
							//进行post交互
							var optionsNeed = {"itemIds":itemIds};
							$.post("item/param/operate",optionsNeed,function(data){
								if(data.status==200){
									$("#itemParamList").datagrid("reload");
								}else{
									alert("删除失败！")
								}
							});
						}
					});
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