 
	
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
			{ field:'时间',title:'时间',width:150,sortable:true}	,	
			{ field:'组号',title:'组号',width:100,sortable:true},
			{ field:'罐号',title:'罐号',width:50,sortable:true},
			{ field:'温度',title:'温度',width:100,sortable:true},
			{ field:'周期',title:'周期',width:100,sortable:true},
			{ field:'变化率',title:'变化率',width:100,sortable:true}
		
					
		]]
	});
	
	 //ajax传递搜索数据
	  function searchh()
			  {
			  
			  $.ajax({  			
              type:"post",                               
              url:"/work/temperaturefromdb",  
              data:{

                  "group":document.search.groupID.value,
                  "jar":document.search.jarID.value,
                  "cycle":document.search.cycleID.value,
                  "rate":document.search.rate.value
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
	