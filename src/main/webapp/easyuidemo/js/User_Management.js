

	/* Name添加记录*/
	
	function add(){
		if(document.formadduser.password.value!=document.formadduser.repeatPwd.value)
			{
			alert("两次密码输入不一致！");
			}
		else
		{
		$.ajax({  			
            type:"post",                               
            url:"/work/Adduser",  
            data:{
                "username":document.formadduser.username.value,
                "password":document.formadduser.password.value,
                "right":document.formadduser.right.value
                                 },   
            dataType:"text",
            async:true,
            success:function(Data)
            {   alert(Data);
                
            
            },
            error:function()
            {    alert("错误");}
            }); 
		}
	}
	
	/**
	* Name 修改记录
	*/
	function edit(){
		if(document.formedituser.password.value!=document.formedituser.repeatPwd.value)
		{
		alert("两次密码输入不一致！");
		}
		var item = $('#datagrid-user').datagrid('getSelected');
		$.ajax({  			
            type:"post",                               
            url:"/work/Edituser",  
            data:{
            	"_username":item.用户名,
               
                
                "username":document.formedituser.username.value,
                "password":document.formedituser.password.value,
                "right":document.formedituser.right.value,              
             
                 },   
            dataType:"text",
            async:true,
            success:function(Data)
            {   alert(Data);
                            
            },
            error:function()
            {    alert("错误");}
            }); 
 
	}
	
	
	/**
	* Name 删除记录
	*/
	function remove(){
		$.messager.confirm('信息提示','确定要删除这个用户吗', function(result){
			if(result){
				
				var items = $('#datagrid-user').datagrid('getSelected');
						
				$.ajax({
					 async:true,
				     type:'post',
					url:'/work/Removeuser',
					dataType:"text",
					data:{
		            	"_username":items.用户名,
		              
		                
		                 },
					success:function(data){
						if(data=='删除成功'){
							$.messager.alert('提示信息','删除成功');		
						}
						else
						{
							$.messager.alert('提示信息','删除失败');		
						}
					}	
				});
			}	
		});
	}
	
	/**
	* Name 打开添加窗口
	*/
	function openAdd(){
		$('#wu-form').form('clear');
		$('#wu-dialogadd').dialog({
			closed: false,
			modal:true,
            title: "添加数据",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialogadd').dialog('close');                    
                }
            }]
        });
	}
	
	/**
	* Name 打开修改窗口
	*/
	function openEdit(){
		$('#wu-form').form('clear');
		var item = $('#datagrid-user').datagrid('getSelected');
		
		$("#usernameid").attr("value",item.用户名);
		$("#rightid").attr("value",item.权限);
		
	
		$('#wu-dialogedit').dialog({
			closed: false,
			modal:true,
            title: "修改数据",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: edit
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialogedit').dialog('close');                    
                }
            }]
        });
	}	
	
	/**
	* Name 分页过滤器
	*/
	function pagerFilter(data){            
		if (typeof data.length == 'number' && typeof data.splice == 'function'){// is array                
			data = {                   
				total: data.length,                   
				rows: data               
			}            
		}        
		var dg = $(this);         
		var opts = dg.datagrid('options');          
		var pager = dg.datagrid('getPager');          
		pager.pagination({                
			onSelectPage:function(pageNum, pageSize){                 
				opts.pageNumber = pageNum;                   
				opts.pageSize = pageSize;                
				pager.pagination('refresh',{pageNumber:pageNum,pageSize:pageSize});                  
				dg.datagrid('loadData',data);                
			}          
		});           
		if (!data.originalRows){               
			data.originalRows = (data.rows);       
		}         
		var start = (opts.pageNumber-1)*parseInt(opts.pageSize);          
		var end = start + parseInt(opts.pageSize);        
		data.rows = (data.originalRows.slice(start, end));         
		return data;       
	}
	
	/**
	* Name 数据载入
	*/
	
	 $('#datagrid-user').datagrid({
		
		loadFilter:pagerFilter,		
		rownumbers:true,
		singleSelect:false,
		pageSize:20,           
		pagination:true,
		multiSort:true,
		fitColumns:true,
		loadMsg:'Processing, please wait …',
		fit:true,
		columns:[[
			{ checkbox:true},
		
			{ field:'用户名',title:'用户名',width:50},
			{ field:'权限',title:'权限',width:50},
			{ field:'审核状态',title:'审核状态',width:50}
			
		]]
	});
	
	 //ajax传递搜索数据
	  function Searchuser()
			  {
			     
			  $.ajax({  			
              type:"post",                               
              url:"/work/Userdatafromdb",  
              data:{
                  "username":document.searchuser.username.value,
                  "right":document.searchuser.right.value,
               
                   },   
              dataType:"json",
              async:true,
              success:function(Data)
              {   alert(Data.length);
                  $('#datagrid-user').datagrid('loadData', Data);
              
              },
              error:function()
              {    alert("错误");}
              }); 
			    
			  }
		
