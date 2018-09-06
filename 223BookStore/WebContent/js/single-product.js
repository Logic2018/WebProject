var aId = -1;

var url = window.location.search;

if (url.indexOf("?") != -1) {
	var str = url.substr(1)
	strs = str.split("&");

	for (i = 0; i < strs.length; i++) {

		aId = strs[i].split("=")[1];

	}
}
var single = new Vue({
	el:'#wrapper',
	data:{
		goodsList:[],
	},
	methods: {
		init: function(){
			var _self = this;
			$.ajax({
				url: "GoodsServlet",
				type: "post",
				data: {
					flag: "single",
					id:aId
				},
				dataType: "json",
				success: function(res) {
					_self.goodsList = res.data;
				}
			})
		},
		
	
		addCart : function(gid){
			var _self = this;
			$.ajax({
				url: "CartServlet",
				type: "post",
				data: {
					flag: "add",
					id:gid,
					num:$("#qty").val(),
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

single.init();