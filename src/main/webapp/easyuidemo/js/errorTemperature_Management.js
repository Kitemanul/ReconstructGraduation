 
	
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
	
	 $('#datagrid-temperature').datagrid({
		
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
			
			{ field:'组号',title:'组号',width:100,sortable:true},
			{ field:'罐号',title:'罐号',width:50,sortable:true},
			{ field:'温度',title:'温度',width:100,sortable:true},
			{ field:'时间',title:'时间',width:150,sortable:true}		
					
		]]
	});
	
	 //ajax传递搜索数据
	  function searcherror()
			  {
			
			  $.ajax({  			
              type:"post",                               
              url:"/ErrorTemperatureSearch",
              data:{
                  "groupid":document.search.groupID.value,
                  "jarid":document.search.jarID.value
                   },  
          
              dataType:"json",
              async:true,
              success:function(Data)
              {   
                  $('#datagrid-temperature').datagrid('loadData', Data);
              
              },
              error:function()
              {    alert("错误");}
              }); 
			    
			  }
	