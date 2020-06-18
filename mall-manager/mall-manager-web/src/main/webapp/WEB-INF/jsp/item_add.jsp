<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<label for="" class="label-top">商品图片:</label>
			 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" name="image"/>
		</div>
		<a href="javascript:void(0)" class="easyui-linkbutton warning"
			onclick="clearForm()">取消</a> <a href="javascript:void(0)"
			class="easyui-linkbutton success" onclick="submitForm()">添加</a>
	</form>
	<img src="ftp://Martha@127.0.0.1/image/03.jfif">
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
			alert($('#itemAddForm').serialize())
			console.log();
			if (!$('#itemAddForm').form('validate')) {
				$.messager.alert('提示', '表单还未填写完成！');
				return;
			}
			//ajax的post方式提交表单
			//$('#itemAddForm').serialize()将表单序列号为key-value形式的字符串

			$.post("/item/save", $('#itemAddForm').serialize(), function(data) {
				if (data.status == 200) {
					$("#dgTbItem").datagrid("reload");
					$.messager.alert('操作成功', '恭喜您添加商品成功！', 'warning',
							function() {
								$("#item-list").click();
							});
				}
			});
		}
		function clearForm() {
			$('#itemAddForm').form('reset')
		}
	</script>
</div>