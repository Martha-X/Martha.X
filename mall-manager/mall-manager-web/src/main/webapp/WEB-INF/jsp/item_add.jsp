<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.form-item {
	margin-bottom: 15px;
	width: 100%;
	float: left;
}

.form-item>label {
	min-width: 72px;
	display: inline-block;
}

.form-item input, select {
	width: 270px;
}
</style>
<div class="super-theme-example">
	<form id="itemAddForm" method="post">
		<div class="form-item">
			<label for="" class="label-top">商品类目:</label> <a
				href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>
			<input type="hidden" name="cid" style="width: 280px;"></input>
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品名称：</label> <input id="title"
				name="title" class="easyui-validatebox easyui-textbox"
				prompt="请输入商品名称" data-options="required:true">
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品卖点：</label> <input id="sellPoint"
				name="sellPoint" class="easyui-validatebox easyui-textbox"
				prompt="请输入商品卖点" data-options="required:true">
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品价格：</label> <input type="text"
				name="price" class="easyui-numberbox" />
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品库存：</label> <input type="text"
				name="num" class="easyui-numberbox" />
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品条形码：</label> <input type="text"
				name="barcode" class="easyui-numberbox" data-options="required:true" />
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品图片:</label> <a
				href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
			<input type="hidden" name="image" />
		</div>
		<div class="form-item">
			<label for="" class="label-top" style="align-content: center;">商品描述:</label>
			<textarea style="width: 800px; height: 300px; visibility: hidden;"
				name="desc"></textarea>
		</div>
		<div class="form-item params hide">
			<label for="" class="label-top" style="align-content: center;">商品规格:</label>
			<div></div>
			<input type="hidden" name="itemParams">
		</div>
		<a href="javascript:void(0)" class="easyui-linkbutton warning"
			onclick="clearForm()">取消</a> <a href="javascript:void(0)"
			class="easyui-linkbutton success" onclick="submitForm()">添加</a>
	</form>
	<script type="text/javascript">
		var itemAddEditor;
		//页面初始化完毕后执行此方法
		//创建富文本编辑器
		$(function() {
			itemAddEditor = TT.createEditor("#itemAddForm [name=desc]");
			//初始化类目选择和图片上传器
			TT.init({
				fun : function(node) {
					//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。 
					TT.changeItemParam(node, "itemAddForm");
				}
			});
		});
		
		function submitForm() {
			//当全部字段不符合要求时阻止表单提交并return
			if (!$('#itemAddForm').form('validate')) {
				$.messager.alert('提示', '表单还未填写完成！');
				return;
			}
			//提取商品规格数据
			var paramJson = [];
			$("#itemAddForm .params li").each(function(i, e) {
				var trs = $(e).find("tr");
				var group = trs.eq(0).text();
				var ps = [];
				for (var i = 1; i < trs.length; i++) {
					var tr = trs.eq(i);
					ps.push({
						"k" : $.trim(tr.find("td").eq(0).find("span").text()),
						"v" : $.trim(tr.find("input").val())
					});
				}
				paramJson.push({
					"group" : group,
					"params" : ps
				});
			});
			paramJson = JSON.stringify(paramJson);
			console.log(paramJson);
			$("#itemAddForm [name=itemParams]").val(paramJson);
			//输出表单键值对
			alert($('#itemAddForm').serialize())
			itemAddEditor.sync();
			//ajax的post方式提交表单
			//$('#itemAddForm').serialize()将表单序列号为key-value形式的字符串
			//将数据发送至/item/save【URL】，发送到服务器的数据$('#itemAddForm').serialize()【Data】，请求成功时运行的函数【function(data)】
			$.post("/item/save", $('#itemAddForm').serialize(), function(data) {
				console.log(data);
				if (data.status == 200) {
					//重新加载商品列表控件
					$("#dgTbItem").datagrid("reload");
					//messager.alert(String title,String message,Object responseValue,function)
					$.messager.alert('Martha-X', '添加商品成功！', 'info', function() {
						$("#item-list").click();//回到商品管理页面
					});
				}
			});
		}
		function clearForm() {
			$('#itemAddForm').form('reset')
		}
	</script>
</div>