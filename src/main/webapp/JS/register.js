
function register()
{
    var userName=document.registerForm.username.value;
    var passWord=document.registerForm.password.value;
    var repeatMM=document.registerForm.repeatPwd.value;
    if(passWord!=repeatMM)
    {
        alert("两次输入的密码不一致!!");
        return;
    }
    $.ajax({
        type:"post",
        url:"/Register",
        data:{
            "user":userName,

            "pwd":passWord
        },
        dataType:"text",
        async:true,
        success:function(s)
        {
            if(s=="fail")
            {
                window.alert("用户名重复！！");
            }
            else if(s=="victory")
            {
                /*  window.alert(s); */
                window.alert("注册成功");
                window.location("login.html");
            }
            else
            {
                window.alert("注册失败");
            }



        },
        error:function()
        {    alert("错误");}
    });
} 
  
