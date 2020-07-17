/* function login()
    {      	 
    	var xmlhttp=false;
         function CreateXMLhttp()
    		{   
    			try{
    				xmlhttp=new XMLHttpRequest();
    			   }
    			catch (e)
    			{
    				try{
    					xmlhttp=new ActiveXObeject("Msxml2.XMLHTTP");
    				   }
    				catch(e)
    				{
    					try
    					{
    						xmlhttp=new ActiveXObeject("Microsoft.XMLHTTP");
    					}
    					catch(failed)
    					{
    						xmlhtttp=false;
    					}
    				}
    			}
    			return xmlhttp;    			
    		}  	 
   
     CreateXMLhttp();
     if(xmlhttp){
    
   //创建xmlhttprequest对象，实现ajax
 	 var userName=document.formLogin.userName.value;
	 var password=document.formLogin.password.value;
	  xmlhttp.open("Post","/work/loginhandle",true); 
     //设置发送头 以及发送
	  xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
      xmlhttp.send("user="+userName+"&pwd="+password);
      //接受成功处理函数
	 xmlhttp.onreadystatechange=function(){
		
		 if(xmlhttp.readyState==4&&xmlhttp.status == 200)
			 {
			  s=xmlhttp.responseText;
		      alert(s);
			  if(s=="fail")
				{		
				window.alert("用户名或密码错误！！");
				} 
			  else if(s=="nopass")
				  {
				  alert("账号没有通过审核");
				  }
			 else
				 {alert("登录成功");
				 if(s=="victory2admin")
				 {window.location("../easyui demo/index4admin.html");
				 } 
			     else
			    	 {
			     window.location("../easyui demo/index4user.html");
			    	 }
			     }
	         }	    
                                           }
                } 
    }*/

function login()
{     alert("进入函数");
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
		 	window.location.href="../easyuidemo/index4admin.html";
		 } 
	     else
	    	 {
	     window.location.href="../easyuidemo/index4user.html";
	    	 }
	     }
        
    
    },
    error:function()
    {    alert("错误");}
    }); 
}

