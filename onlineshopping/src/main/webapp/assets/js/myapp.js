$(function(){
	//solving the active menu problem
	switch(menu){
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	
	default:
		if(menu == 'Home') break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
	break;
		
	}
	
});

//code for jquery dataTable
var $table = $('#productListTable');

//execute this code only when we have this table

if($table.length){
	
	var jsonUrl = '';
	if(window.categoryId == ''){
		jsonUrl = window.contextRoot+'/json/data/all/products';
	}
	else{
		jsonUrl = window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
	}
	$table.DataTable({
		lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records,','ALL']],
		pageLength:5,
		ajax: {
			url: jsonUrl,
			dataSrc: ''
		},
		columns: [
			{
				data:'code',
				mRender: function(data, type, row){
					return '<img src = "'+window.contextRoot+'/resources/images/'+data+'.jpg" class = "dataTableImg"/>';
				}
			},
			{
				data:'name'
			},
			{
				data:'brand'
			},
			{
				data:'unitPrice',
				mRender: function(data, type, row){
					return '&#36; '+data //for rupee symbol
				}
			},
			{
				data:'quantity'
			},
			{
				data:'id',
				bSortable:false,//for disabling the sort function in this column
				mRender: function(data, type, row ){
					var str = '';//&#160 for adding the extra space
					str+= '<a href="'+window.contextRoot+'/show/'+data+'/product" class = "btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>&#160;'
					str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class = "btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>'
					
					return str;
				}
			}
		]
		
	})
}