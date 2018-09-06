var goods = new Vue({
	el:'#wrapper',
	data:{
		name:"",
		password:"",
		repass:"",
		telephone:"",
		email:"",
		sex:"",
		f_name: false,
		f_pass: false,
		f_repass: false,
		f_email: false,
		f_tel: false
	},
	methods: {
		checkUser: function(){
			var _self = this;
			if(_self.f_name&&_self.f_pass&&_self.f_repass&&_self.f_email&&_self.f_tel){
				$.ajax({
					url: "UserInfoServlet",
					type: "post",
					data: {
						flag: "register",
						username: $("#username").val(),
						password: $("#password").val(),
						tel:$("#phone").val(),
						email:$("#email").val(),
						sex:$('input:radio:checked').val()				
					},
					dataType: "json",
					success: function(res) {
						if(res.code == "200"){
							alert("success！");
							window.location.href="login.html";
						}
					}
				}) 
			}
				
			
		},
		
		checkName: function(){
			var _self = this;
			var username = $("#username").val();
			if(username == "" || username == null){
				_self.name = "Username can not be empty";
				_self.f_name = false;
			}else{
				$.ajax({
					url: "UserInfoServlet",
					type: "post",
					data: {
						flag: "checkName",
						username: $("#username").val(),
										
					},
					dataType: "json",
					success: function(res) {
						if(res.code == "200"){
							_self.name = "The user already exists.";
							_self.f_name = false;
						}else{
							_self.name = "";
							_self.f_name = true;
						}
					}
				})
			}
		},
		
		checkPass: function(){
			var _self = this;
			var pass = $("#password").val();
			if(pass == "" || pass == null){
				_self.password = "Password can not be empty";
				_self.f_pass = false;
			}else{
				_self.password = "";
				_self.f_pass = true;
			}	
		},
		
		checkRePass: function(){
			var _self = this;
			var pass = $("#password").val();
			var rePass = $("#repass").val();
			if(pass == rePass){
				_self.repass = "";
				_self.f_repass = true;
			}else{
				_self.repass = "Two password inconsistency";
				_self.f_repass = false;
			}	
		},
		
		checkTel: function(){
			var _self = this;
			var tel = $("#phone").val();
			var reg = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
			if(reg.test(tel)){
				_self.telephone = "";
				_self.f_tel = true;
			}else{
				_self.telephone = "Wrong phone number format";
				_self.f_tel = false;
			}
		},
		
		checkEmail: function(){
			var _self = this;
			var email = $("#email").val();
			var reg = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
			if(reg.test(email)){
				_self.email = "";
				_self.f_email = true;
			}else{
				_self.email = "Wrong email number format";
				_self.f_email = false;
			}
		},
		
		checkSex: function(){
			var sex1 = $('input:radio:checked').val();
			var _self = this;
			if(sex1 == null || sex1 == ""){
				_self.sex = "Please choose sex";
			}else{
				_self.sex = "";
			}
		}
	}
})
