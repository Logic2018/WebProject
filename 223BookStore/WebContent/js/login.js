var goods = new Vue({
	el:'#wrapper',
	data:{
		failed:""
	},
	methods: {
		checkUser: function(){
			var _self = this;
			$.ajax({
				url: "UserInfoServlet",
				type: "post",
				data: {
					flag: "login",
					username: $("#username").val(),
					password: $("#password").val()
				},
				dataType: "json",
				success: function(res) {
					if(res.code == "200"){
						window.location.href="index2.html";
					}
					else{
						_self.failed = "Incorrect username or password";
					}
				}
			})
		}
		
	}
	
})
