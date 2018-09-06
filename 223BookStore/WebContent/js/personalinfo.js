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
var user = new Vue({
	el:'#user',
	data:{
		username:"",
		usersex: "",
		usertel: "",
		useremail: ""
	},
	methods: {
		init: function(){
			var _self = this;
			$.ajax({
				url: "UserInfoServlet",
				type: "post",
				data: {
					flag: "user",
				},
				dataType: "json",
				success: function(res) {
					_self.username = res.userInfo.userName;
					_self.usersex = res.userInfo.userSex;
					_self.usertel = res.userInfo.userTel;
					_self.useremail = res.userInfo.userEmail;
					
				}

			})
		},
		

		
	}
	
})

user.init();