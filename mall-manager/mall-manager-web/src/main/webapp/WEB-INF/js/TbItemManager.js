function getSelections(tableId){
	console.log(tableId);
	var itemList = $(tableId);
	console.log(itemList);
	var sels = itemList.datagrid("getSelections");
	var itemIds = [];
	for(var i in sels){
		itemIds.push(sels[i].id);
	}
	itemIds = itemIds.join(",");
	return itemIds;
}


function tbItemOptions(keywords,optionsId,tableId){
	//itemIds 为商品id数组，存放一条或多条商品的id
	var itemIds = getSelections(tableId);
	//判断如果未选定行，不执行，提示
	if(itemIds.length == 0){
		$.messager.alert('提示','必需选择一个商品！');
		return;
	}
	//提醒是否删除数据
	$.messager.confirm('确认','您确认想要'+keywords+'ID为' + itemIds + "的商品吗？",function(r){
		if(r){
			//进行post交互
			var optionsNeed = {"itemIds":itemIds,"optionsId":optionsId};
			$.post("item/operate",optionsNeed,function(data){
				if(data.status==200){
					$(tableId).datagrid("reload");
				}else{
					alert(keywords+"失败！")
				}
			});
		}
	});
}