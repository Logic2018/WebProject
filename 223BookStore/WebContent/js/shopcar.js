//工具函数放到前面
function getQueryVariable(variable) {
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for(var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if(pair[0] == variable) {
			return pair[1];
		}
	}
	return(false);
}
var goods = new Vue({
	el: '#wrapper',
	data: {
		cartList: [],
		allprice: 0,
	},
	methods: {
		init: function() {
			var _self = this;
			_self.allprice = 0;
			$.ajax({
				url: "CartServlet",
				type: "post",
				data: {
					flag: "show",
					category: "all",
				},
				dataType: "json",
				success: function(res) {
					_self.allPrice = 0;
					for(var i = 0; i < res.data.length; i++) {
						_self.allprice += res.data[i].goods_price * res.data[i].goods_num;
					}
					_self.cartList = res.data;
				}
			})
		},
		
		del: function(gId){
			var _self = this;
			var msg = "Remove the product?";
			console.log(gId);
			if(confirm(msg) == true){
				$.ajax({
				url: "CartServlet",
				type: "post",
				data: {
					flag: "del",
					id: gId
				},
				dataType: "json",
				success: function(res) {
					if(res.code == "200"){
						goods.init();
					}
				}
			})
			}
		}

	}

})

goods.init();