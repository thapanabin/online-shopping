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
//create a dataset
var products = [
	['1','ABC'],
	['2','DEF'],
	['3','GHI'],
	['4','KLM'],
	['5','OPQ'],
	['6','RST'],
	['7','UVW'],
	['8','XZA'],
	['9','BCD'],
	['10','EFG']
	
	
];
var $table = $('#productListTable');

//execute the below code only where we have this table
if($table.length){
	$table.DataTable({
		lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
		pageLength:5,
		data: products
	})
}