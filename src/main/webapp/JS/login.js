function login()
{
    $.ajax({
    type:"post",
    url:"/Login",
    data:{
        "user":document.formLogin.userName.value,

        "pwd":document.formLogin.password.value
                         },
    dataType:"text",
    async:true,
    success:function(s)
    {
    	if(s=="fail")
	{
		window.alert("用户名或密码错误！！");
		}
	  else if(s=="nopass")
		  {
		  alert("账号没有通过审核");
		  }
	 else
		 {
		 	alert("登录成功");

             if(s=="victory2admin")
		 {
		 	window.location.href="../easyuidemo/HTML/index4admin.html";
		 }
	     else
	    	 {
	     window.location.href="../easyuidemo/HTML/index4user.html";
	    	 }
	     }


    },
    error:function()
    {    alert("错误");}
    });
}

