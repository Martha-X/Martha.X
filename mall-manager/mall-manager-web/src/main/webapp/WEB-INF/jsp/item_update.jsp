<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
					name="barcode" class="easyui-numberbox"
					data-options="required:true" />
			</div>
			<div class="form-item">
				<label for="" class="label-top">商品图片:</label> <a
					href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
				<input type="hidden" name="image" />
			</div>
			<a href="javascript:void(0)" class="easyui-linkbutton warning"
				onclick="clearForm()">取消</a> <a href="javascript:void(0)"
				class="easyui-linkbutton success" onclick="submitForm()">修改</a>
		</form>
	</div>
</body>
</html>