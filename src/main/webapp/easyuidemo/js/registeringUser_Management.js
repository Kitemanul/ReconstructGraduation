


	
	/**
	* Name 修改记录
	*/
	function check(){
		
		var item = $('#datagrid-registeringuser').datagrid('getSelected');
		$.ajax({  			
            type:"post",                               
            url:"/work/userpass",  
            data:{
            	"result":'pass',   
            	"username":document.formcheckuser.username.value,
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
	* Name 打开审核窗口
	*/
	function opencheck(){
		$('#wu-form').form('clear');
		var item = $('#datagrid-registeringuser').datagrid('getSelected');
		
		$("#usernameid").attr("value",item.用户名);
		$("#rightid").attr("value",item.权限);
		
	
		$('#wu-dialogecheck').dialog({
			closed: false,
			modal:true,
            title: "审核用户",
            buttons: [{
                text: '通过',
                iconCls: 'icon-ok',
                handler: check
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
	
	 $('#datagrid-registeringuser').datagrid({
		
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
	  function Search_registering_user()
			  {
			     
		      $.ajax({  			
              type:"post",                               
              url:"/registeringUserdata",
              data:{
                  "username":document.search_registeringuser.username.value,
                    
                   },   
              dataType:"json",
              async:true,
              success:function(Data)
              {  
                  $('#datagrid-registeringuser').datagrid('loadData', Data);
              
              },
              error:function()
              {    alert("错误");}
              }); 
			    
			    
			  }
		
