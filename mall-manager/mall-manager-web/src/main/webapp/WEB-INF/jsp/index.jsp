<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!--easyui-->
<script src="easyui/jquery.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="easyui/jquery.easyui.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript" charset="utf-8"></script>
<!--开发-->
<link rel="stylesheet" href="easyui/themes/gray/easyui.css">
<link rel="stylesheet" href="easyui/themes/super/css/font-awesome.min.css">
<link rel="stylesheet" href="easyui/themes/super/superBlue.css" id="themeCss">
<script src="js/super.js" type="text/javascript" charset="utf-8"></script>

<!--测试dist-->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/super/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="easyui/themes/super/superBlue.css" id="themeCss">
<script type="text/javascript" src="easyui/themes/super/super.js"></script>
<script src="js/superDemo.js" type="text/javascript" charset="utf-8"></script>
</head>
<body id="main" class="easyui-layout">
	<div data-options="region:'north',border:false" class="super-north">
		<!--顶部-->
		<div class="super-navigation">
			<!--系统名称-->
			<div class="super-navigation-title">SUPER THEME</div>
			<!--自定义导航-->
			<div class="super-navigation-main">
				<div class="super-setting-left">
					<ul>
						<li><i class="fa fa-commenting-o"></i>消息</li>
						<li><i class="fa fa-envelope-o"></i>邮件</li>
						<li><i class="fa fa-bell-o"></i>通知</li>
					</ul>
				</div>
				<div class="super-setting-right">
					<ul>
						<li>
							<div class="super-setting-icon">
								<i class="fa fa-gears"></i>
							</div>
							<div id="mm" class="easyui-menu">
								<div>个人中心</div>
								<div id="themeSetting">主题</div>
								<div class="menu-sep"></div>
								<div id="logout">退出</div>
							</div>
						</li>
						<li class="user"><span class="user-icon"><img
								src="img/favicon.png" /></span>管理员</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div data-options="region:'west',title:'MAIN NAVIGATION',border:false"
		class="super-west">
		<!--左侧导航-->
		<div class="easyui-accordion"
			data-options="border:false,fit:true,selected:true">
			<div title="商品管理" data-options="iconCls:'fa fa-table'">
				<ul>
					<li id="item-list" data-url='productList'>商品管理</li>
					<li id="item-list" data-url='item_add'>添加商品</li>
				</ul>
			</div>
		</div>
	</div>
	<div data-options="region:'center'" style="padding-top: 2px;">
		<!--主要内容-->
		<div id="tt" class="easyui-tabs" data-options="border:false,fit:true">
			<div title="首页" data-options="iconCls:'fa fa-home'">
				<div style="padding: 20px;">放点什么好呢......</div>
			</div>
		</div>
	</div>
	<div data-options="region:'south'" class="super-south">
		<!--页脚-->
		<div class="super-footer-info">
			<span><i class="fa fa-info-circle"></i> 作者：Martha</span> <span><i
				class="fa fa-copyright"></i> CopyRight 2020 版权所有 <i
				class="fa fa-caret-right"></i></span>
		</div>
	</div>

	<!--主题设置弹窗-->
	<div id="win">
		<div class="themeItem">
			<ul>
				<li>
					<div class="superGreen" style="background: #1abc9c;">green</div>
				</li>
				<li class="themeActive">
					<div class="superBlue" style="background: #3498db;">blue</div>
				</li>
				<li>
					<div class="superGray" style="background: #95a5a6;">gray</div>
				</li>
				<li>
					<div class="superAmethyst" style="background: #9b59b6;">amethyst</div>
				</li>
				<li>
					<div class="superBlack" style="background: #34495e;">black</div>
				</li>
				<li>
					<div class="superYellow" style="background: #e67e22;">yellow</div>
				</li>
				<li>
					<div class="superEmerald" style="background: #2ecc71;">emerald</div>
				</li>
				<li>
					<div class="superRed" style="background: #e74c3c;">red</div>
				</li>
			</ul>
		</div>
	</div>

</body>

</html>