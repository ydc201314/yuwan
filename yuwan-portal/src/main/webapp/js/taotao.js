var TT = TAOTAO = {
	checkLogin : function(){
		var _ticket = $.cookie("YUWAN_TICKET");
		if(!_ticket){
			return ;
		}
		$.ajax({
			url : "http://sso.yudch.top/user/" + _ticket,
			dataType : "jsonp",
			type : "GET",
			success : function(data){
				if(data){
					var _data = data;
					var html =_data.username+"，欢迎来到鱼丸！<a href=\"http://www.yudch.top/user/logout.html\" class=\"link-logout\">[退出]</a>";
					$("#loginbar").replaceWith(html);
				}
			}
		});
	}
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	TT.checkLogin();
});