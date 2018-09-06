//工具函数放到前面
function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}
var goods = new Vue({
	el:'#wrapper',
	data:{
		goodsList:[]
	},
	methods: {
		init: function(){
			var _self = this;
			$.ajax({
				url: "GoodsServlet",
				type: "post",
				data: {
					flag: "show",
					category: "all",
				},
				dataType: "json",
				success: function(res) {
					_self.goodsList = res.data;
				}
			})
		},
		
		addCart : function(){
			var _self = this;
			alert(1);
			$.ajax({
				url: "CartServlet",
				type: "post",
				data: {
					flag: "add",
					id:1,
					num:2,
				},
				dataType: "json",
				success: function(res) {
					if(res.code == "200")
						alert("success");
				}
			})
		},
		
	}
	
})

goods.init();