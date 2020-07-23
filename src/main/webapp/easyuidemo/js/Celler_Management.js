

	/* Name添加记录*/
	
	function add(){
		$.ajax({  			
            type:"post",                               
            url:"/AddCeller",
            data:{
                "time1":document.formadd.time1.value,
                "time0":document.formadd.time0.value,
                "time2":document.formadd.time2.value,
                "time3":document.formadd.time3.value,
                "group":document.formadd.group.value,
                "jar":document.formadd.jar.value,
                "cycle":document.formadd.cycle.value
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
	* Name 修改记录
	*/
	function edit(){
		var item = $('#datagrid-celler').datagrid('getSelected');
		$.ajax({  			
            type:"post",                               
            url:"/EditCeller",
            data:{
            	"_time1":item.入窖时间,
                "_time0":item.时间,
                "_time2":item.出窖时间,              
                "_group":item.组号,
                "_jar":item.罐号,
                "_cycle":item.周期,
                
                "time1":document.formedit.time1.value,
                "time0":document.formedit.time0.value,
                "time2":document.formedit.time2.value,              
                "group":document.formedit.group.value,
                "jar":document.formedit.jar.value,
                "cycle":document.formedit.cycle.value
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
		$.messager.confirm('信息提示','确定要删除这条数据吗', function(result){
			if(result){
				
				var items = $('#datagrid-celler').datagrid('getSelected');
				alert(items.时间);			
				$.ajax({
					 async:true,
				     type:'post',
					url:'/RemoveCeller',
					dataType:"text",
					data:{
		            	"_time1":items.入窖时间,
		                "_time0":items.时间,
		                "_time2":items.出窖时间,              
		                "_group":items.组号,
		                "_jar":items.罐号,
		                "_cycle":items.周期,
		                
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
		var item = $('#datagrid-celler').datagrid('getSelected');
		
		$("#time1id").attr("value",item.入窖时间);
		$("#time2id").attr("value",item.出窖时间);
		$("#time0id").attr("value",item.时间);
		$("#groupid").attr("value",item.组号);
		$("#jarid").attr("value",item.罐号);
		$("#cycleid").attr("value",item.周期);
	
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
	
	 $('#datagrid-celler').datagrid({
		
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
			{ field:'时间',title:'时间',width:150,sortable:true},
			{ field:'入窖时间',title:'入窖时间',width:150,sortable:true},
			
			{ field:'出窖时间',title:'出窖时间',width:150,sortable:true},
			{ field:'周期',title:'周期',width:50},
			{ field:'组号',title:'组号',width:50},
			{ field:'罐号',title:'罐号',width:50}
			
			
		]]
	});
	
	 //ajax传递搜索数据
	  function Search()
			  {
			     
			  $.ajax({  			
              type:"post",                               
              url:"/SearchCellerData",
              data:{
                  "time1":document.search.startime.value,
                  "time2":document.search.endtime.value,
                  "group":document.search.groupID.value,
                  "jar":document.search.jarID.value,
                  "cycle":document.search.cycle.value
                   },   
              dataType:"json",
              async:true,
              success:function(Data)
              {   alert(Data.length);
                  $('#datagrid-celler').datagrid('loadData', Data);

              
              },
              error:function()
              {    alert("错误");}
              }); 
			    
			  }
		
