           var chart=new Highcharts.chart('container',{
                 	  	  //
                 			title: {
                 					text: '温度变化折线图'
                 			       },
                 			       tooltip:{
                 			    			       
                 			    	 formatter: function() {
                 			    		
                 			    		 if (this.series.name =='第一组')
                 						{return '时间：第' + Math.ceil(this.x)+'天<br/>'+'温度(℃)：' +this.y;}
                 			    		 else if(this.series.name =='第二组')
                 			    		{return '时间：第' + Math.ceil(this.x)+'天<br/>'+'温度(℃)：' + this.y;}
                 			    		 else if(this.series.name =='第一组变化率')
                 	 		    		{return '时间：第' + Math.ceil(this.x)+'天<br/>'+'变化率(℃)：' + this.y;}
                 			    		 else if(this.series.name =='第二组变化率')
                 	 		    		{return '时间：第' + Math.ceil(this.x)+'天<br/>'+'变化率(℃)：' + this.y;}
                 						}
                 			       },
                 	       //            		
                 			xAxis: {
                 				title: {
                 					text: '时间/天'
                 			}              		
                 			},
                 		    //
                 			legend: {
                 					layout: 'vertical',
                 					align: 'right',
                 					verticalAlign: 'middle'
                 			},
                 			//
                 			plotOptions: {
                 				series: {
                 					pointInterval:1/48
                 			}          	              			                  		
                 			},
                 			//	      
                 			series: [{
                   				name:'第一组',
                   				data:[]

                 		    },
                 		    {
                				name:'第一组变化率',
                				data:[]

                		    },
                		    {
                			name:'第二组',
                			     data:[]

                	        },
                   		    {
                				name:'第二组变化率',
                				data:[]

                		   }]
                 	   }); 
	
	/**
	* Name 数据载入
	*/
	
	
	 //ajax传递搜索数据 作图
	  function draw()
			  {
		
		  $.ajax({  			
              type:"post",                               
              url:"/TemperatureCompare",
              data:{
                  
                  "cycle":document.search.cycle.value,
                  "group":document.search.groupID.value,
                  "jar":document.search.jarID.value,
                  "cycle2":document.search.cycle2.value,
                  "group2":document.search.groupID2.value,
                  "jar2":document.search.jarID2.value,
                  "rate1":document.search.rate1.value,
                  "rate2":document.search.rate2.value
                
                   },  
          
              dataType:"json",
              async:true,
              success:function(Data)
              {   
                              
                  var data1=new Array();
                  var data2=new Array();
                  var rate1=new Array();
                  var rate2=new Array();
                  var m=0;
                  var n=0;
             
                  for(var i in Data)
                	  { if(Data[i].分类=='1组')
                	    {data1[m]=Data[i].温度;                	    
                	     rate1[m++]=Data[i].变化率;
                	  }
                	  else if(Data[i].分类=='2组')
                		  { data2[n]=Data[i].温度;
                		    rate2[n++]=Data[i].变化率;
                		  }
                	  };
                  
                	  //Highchart作图
                	  chart.series[0].setData(data1);
                	  chart.series[1].setData(rate1);
                	  chart.series[2].setData(data2);
                	  chart.series[3].setData(rate2);
            			
                      //
              },
              error:function()
              {    alert("错误");}
              }); 
			    
			  }
